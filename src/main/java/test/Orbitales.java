package test;

import java.util.ArrayList;
import java.util.List;

import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;

public class Orbitales {
	
	public Points iniciar(int n, int l, String m) {
		
		int ms = 0;
		
//		if(m == "px") {
//			ms = 1; 
//		}else if(m == "py") {
//			ms = -1;
//		}
		
    	Double reducePlanck = 6.6260693;
    	Double electronMass = 9.109383;
    	Double electronCharge = 1.602176;
    	Double electronChargeSquare = Math.pow(electronCharge, 2);
    	
//		double epsilonSubCero = 8.8541878176;
    	
    	Double reducePlanckSquare = Math.pow(reducePlanck, 2.0);
//    	Double denomin = electronMass * electronChargeSquare;
    	
//		double radioBohrNum = 4 * Math.PI *  epsilonSubCero * reducePlanckSquare;
    	
    	//aSubCero x E1
//    	Double aSubCeroNotCient = radioBohrNum / denomin;   //
//    	Double aSubCero = aSubCeroNotCient * 10;
    
		//Radio de 0 a 4 X 10-18
    	float theta = 0.0F;
		float harmonics = 0.0F;
//     	Double radiusParts = radiusMax / 30;
//     	Double getRadius = 0.05;
    	
	    Coord3d[] points = new Coord3d[7800];
	    Color[] colors = new Color[7800];
	    
	    Integer index = 0;
	    
	    List<Double> list = new ArrayList<Double>();
	    list.add(0.0);
	    
		int size = 40;

	    float red = 0.0f;
	    float g = 0.0f;
	    float b = 1f;
    	
    	//para alpha:   0<=alpha<=maxAlpha
    	Double maxAlpha = Math.PI * 2;
    	Double alphaParts = maxAlpha / 130;
    	System.out.println("Theta " + maxAlpha + " " + alphaParts);
    	Double getAngleAlpha = 0.0;

    	WaveFunctionsHidrogenAtom waveFunction = new WaveFunctionsHidrogenAtom();
    	
	    for(int r = 1; r <= 30; r++) {

	    	double rPart = (double) r / 4.16;
	    	System.out.println(rPart);
	    	
	    	if(n == 2 && l == 1 && (m.equals("y") || m.equals("x"))) {
		    	theta = (float) waveFunction.orbital2PYO2PX(rPart);
			    System.out.println("Radial Function: " + theta);
			    double radRot = rPart * Math.cos(theta);
			    
			    if(m.equals("y")) {

		    		for(int j=0; j < 130; j++) {
						
						Double x = radRot * Math.sin(getAngleAlpha);
						Double y = rPart * Math.sin(theta);
						Double z = radRot * Math.cos(getAngleAlpha);
				    	
						getAngleAlpha = getAngleAlpha + alphaParts;
						
						points[index] = new Coord3d(x, y, z);
						colors[index] = new Color(0, 0, 1, 1f);
						
						points[index + 1] = new Coord3d(x, -y, z);
						colors[index + 1] = new Color(1, 0, 0, 1f);
						
						index = index + 2;
						
		    		}
			    }else if(m.equals("x")) {
				    
		    		for(int j=0; j < 130; j++) {
						
						Double x = rPart * Math.sin(theta);
						Double y = radRot * Math.sin(getAngleAlpha);
						Double z = radRot * Math.cos(getAngleAlpha);
				    	
						getAngleAlpha = getAngleAlpha + alphaParts;
						
						points[index] = new Coord3d(x, y, z);
						colors[index] = new Color(0, 0, 1, 1f);
						
						points[index + 1] = new Coord3d(-x, y, z);
						colors[index + 1] = new Color(1, 0, 0, 1f);
						
						index = index + 2;
						
		    		}
			    }
			    getAngleAlpha = 0.0;
			    
	    	}else if(n == 2 && l == 1 && m.equals("z")) {
		    	theta = (float) waveFunction.orbital2PZ(rPart);
			    System.out.println("Radial Function: " + theta);
			    double radRot = rPart * Math.sin(theta);
			    
			    for(int j=0; j < 130; j++) {
					
					Double x = radRot * Math.cos(getAngleAlpha);
					Double y = radRot * Math.sin(getAngleAlpha);
					Double z = rPart * Math.cos(theta);
			    	
					getAngleAlpha = getAngleAlpha + alphaParts;
					
					points[index] = new Coord3d(x, y, z);
					colors[index] = new Color(0, 0, 1, 1f);
					
					points[index + 1] = new Coord3d(x, y, -z);
					colors[index + 1] = new Color(1, 0, 0, 1f);
					
					index = index + 2;
					
	    		}
			    getAngleAlpha = 0.0;
			    
	    	}

	    }
    	Points pointsDto = new Points(points, colors);
    	return pointsDto;

	}
	
	 public double calcularR20(Double theta) {

		 double cosineSquare = (3 * Math.pow(Math.cos(theta), 2.0)) - 1;
		 double fraction = 5 / Math.PI;
		 double root = Math.sqrt(fraction);
		 double res = 0.25 *root * cosineSquare;
		 
		 return res;

	}
	 
	 public double calcularR00() {

		 double base = 4 * Math.PI;
		 double root = Math.sqrt(base);
		 double res = 1 / root;
		 
		 return res;

	}
		
	 public double calcularR10(Double theta) {

		 double cosine = Math.cos(theta);
		 double fraction = 3 / Math.PI;
		 double root = Math.sqrt(fraction);
		 double res = 0.5 *root * Math.abs(cosine);
		 
		 return res;

	}
	
	 public double calcularR1MasMenos1(Double theta, Double phi) {
		 
		 double sine = Math.sin(theta);
		 double sineSquare = Math.pow(sine, 2.0);
		 double cosine = Math.sin(2 * phi);
		 double fraction = 15 / (Math.PI * 2);
		 double root = Math.sqrt(fraction);
		 double res = 0.25 * root * cosine * sineSquare;
		 
		 return res;

	}
	 
		public Points iniciarPrueba(int n, int l, int m, int corte) {
	     	
	    	Double reducePlanck = 6.6260693;
	    	Double electronMass = 9.109383;
	    	Double electronCharge = 1.602176;
	    	Double electronChargeSquare = Math.pow(electronCharge, 2);
	    	
//			double epsilonSubCero = 8.8541878176;
	    	
	    	Double reducePlanckSquare = Math.pow(reducePlanck, 2.0);
//	    	Double denomin = electronMass * electronChargeSquare;
	    	
//			double radioBohrNum = 4 * Math.PI *  epsilonSubCero * reducePlanckSquare;
	    	
	    	//aSubCero x E1
//	    	Double aSubCeroNotCient = radioBohrNum / denomin;   //
//	    	Double aSubCero = aSubCeroNotCient * 10;
	    
			//Radio de 0 a 4 X 10-18
	    	float radiusMax = 5.0F;
	    	double radius = 0.0F;
	    	float functionProb = 0.0F;
			float harmonics = 0.0F;
			double aSubCero = 0.002;
//	     	Double radiusParts = radiusMax / 30;
//	     	Double getRadius = 0.05;
		    
		    Integer index = 0;
		    
			int size = 40;
//		    float x;
//		    float y;
//		    float z;
//		    float a;
		    
		    float red = 0.0f;
		    float g = 0.0f;
		    float b = 1f;
		    float opacity = 0.5f;
		    
		    Integer vertexPoints = 140000;
		    Integer vertexColor = 140000;
	    	
	    	//para theta:   0<=theta<=maxTheta
	    	Double maxTheta = Math.PI * 2;
	    	Double thetaParts = maxTheta / 100;
	    	Integer halfTheta = 100;
	    	if(corte == 1) {
	    		halfTheta = 50;
	    		vertexPoints = 70000;
	    		vertexColor = 70000;
	    	}
	    	
	    	System.out.println("Theta " + maxTheta + " " +thetaParts);
	    	Double getAngleTheta = 0.0;
	    	
	    	//para phi:   0<=phi<=maxphi
	    	Double maxPhi = Math.PI;
	    	Double phiParts = maxPhi / 70;
	    	System.out.println("Phi " + maxPhi + " " +phiParts);
	    	Double getAnglePhi = 0.0;
	    	
		    Coord3d[] points = new Coord3d[vertexPoints];
		    Color[] colors = new Color[vertexColor];
	    	
		    for(int r = 0; r < 20; r++) {
		    	RadialFunction radialFunction = new RadialFunction();
//		    	double rPart = (double) r / 20;
		    	radius = (float) r/500;
		    	double rPart = (double) radius; 
		    	System.out.println(rPart);
		    	if(corte == 1) {
		    		getAngleTheta = 0.0;
		    	}
		    	
		    	if(radius > 0.1) {
		    		System.out.println("Heyyyyyyyyyyyyyyyyasdkfhsadlkjfhlskdjfñalsdkfhaksdhfajsdlkhf");
		    	}
		    	for(int i=0; i < halfTheta; i++) {
		    		//Para "x"
		    		for(int j=0; j < 70; j++) {
		    			
//		    			if(l == 0 && m == 0) {
//			    			harmonics = (float) calcularR00();    
//		    			}else if(l == 1 && m == 0) {
//		    				harmonics = (float) calcularR10(getAngleTheta);    	    				
//		    			}else if(l == 1 && (m == 1 || m == -1)){
//		    				harmonics = (float) calcularR1MasMenos1(getAngleTheta, getAnglePhi);    
//		    			}else if(l == 2 && m == 0) {
//		    				harmonics = (float) calcularR20(getAngleTheta);    
//		    			}else {
//		    				break;
//		    			}

		    			Double x = rPart * Math.sin(getAnglePhi) * Math.cos(getAngleTheta);
		    			Double y = rPart * Math.sin(getAnglePhi) * Math.sin(getAngleTheta);
		    			Double z = rPart * Math.cos(getAnglePhi);
		    			
				    	if(n == 1 && l == 0) {
				    		functionProb = (float) radialFunction.calcularR10Prueba(rPart);
					    	System.out.println("Radial Function: " + radius);
				    	}else if(n == 2 && l == 0){
				    		functionProb = (float) radialFunction.calcularR20Prueba(rPart, aSubCero);
					    	System.out.println("Radial Function: " + radius);
				    	}else if(n == 2 && l == 1){
				    		functionProb = (float) radialFunction.calcularR21Prueba(rPart, getAngleTheta);
					    	System.out.println("Radial Function: " + radius);
				    	}else if(n == 2 && l == 1 && m == -1){
				    		functionProb = (float) radialFunction.calcularR21menos1Prueba(rPart, getAngleTheta);
					    	System.out.println("Radial Function: " + radius);
				    	}
		    			
		    			getAnglePhi = getAnglePhi + phiParts;
		    			
		    			double prop = (double) functionProb * functionProb * radius * radius * aSubCero;
		    			
		    			System.out.println("Probability: "+ prop);
//		    			System.out.println("Prob: " + harmonics * harmonics);
		    			System.out.println("Radius: " + radius);
//	            		float probabilidad = (float) calcularFuncionNlLoMo(radius, aSubCero);
//	            		float probFormat = Float.parseFloat(String.format("%.7f", probabilidad));
//		    			
		    			if(prop < 0.001033333) {
		    				red = 1;
		    				g = 0;
		    				b = 0;
		    				opacity = 0.2f;
		    			}else if(prop < 0.001566666) {
		    				red = 1;
		    				g = 0;
		    				b = 0;
		    				opacity = 0.5f;
		    			}else if(prop < 0.002566666) {
		    				red = 1;
		    				g = 0;
		    				b = 0;
		    				opacity = 0.9f;
		    			}else if(prop < 0.003366666) {
		    				red = 0;
		    				g = 1;
		    				b = 0;
		    				opacity = 0.9f;
		    			}else if(prop < 0.00966666) {
		    				red = 0;
		    				g = 1;
		    				b = 0;
		    				opacity = 0.7f;
		    			}else if(prop < 0.01366666) {
		    				red = 0;
		    				g = 0;
		    				b = 1;
		    				opacity = 0.9f;
		    			}else if(prop < 0.01966666) {
		    				red = 0;
		    				g = 0;
		    				b = 1;
		    				opacity = 0.7f;
		    			}else if(prop < 0.033366666) {
		    				red = 0;
		    				g = 0;
		    				b = 1;
		    				opacity = 0.2f;
		    			}else {
		    				red = 0;
		    				g = 0;
		    				b = 1;
		    			}
		    			
//		    			getRadius = getRadius + radiusParts;
		                points[index] = new Coord3d(x, y, z);
		                
		                colors[index] = new Color(red, g, b, opacity);
		                index++;
		    		}
		    		getAngleTheta = getAngleTheta + thetaParts;
		    		getAnglePhi = 0.0;
		    	}
//		    	getAnglePhi = 0.0;
//		    	getAngleTheta = 0.0;
		    }
	    	Points pointsDto = new Points(points, colors);
	    	return pointsDto;

		}
	
}
