package test;

import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;

public class HydrogenAtom {
	
	public Points iniciar() {
     	
    	Double reducePlanck = 1.054471817;
    	Double electronMass = 9.109383;
    	Double electronCharge = 1.602176;
    	Double electronChargeSquare = Math.pow(electronCharge, 2);
    	
    	Double reducePlanckSquare = Math.pow(reducePlanck, 2.0);
    	Double denomin = electronMass * electronChargeSquare;
    	
    	//aSubCero x E1
    	Double aSubCeroNotCient = reducePlanckSquare / denomin;
    	Double aSubCero = aSubCeroNotCient * 10;
    
		//Radio de 0 a 4 X 10-18
		Double radius = 0.0;
//     	Double radiusParts = radiusMax / 30;
//     	Double getRadius = 0.05;
    	
	    Coord3d[] points = new Coord3d[20000];
	    Color[] colors = new Color[20000];
	    
	    Integer index = 0;
	    
		int size = 40;
//	    float x;
//	    float y;
//	    float z;
//	    float a;
	    
	    float red = 0.0f;
	    float g = 0.0f;
	    float b = 1f;
    	
    	//para theta:   0<=theta<=maxTheta
    	Double maxTheta = Math.PI;
    	Double thetaParts = maxTheta / 40;
    	System.out.println("Theta " + maxTheta + " " +thetaParts);
    	Double getAngleTheta = 0.0;
    	
    	//para phi:   0<=phi<=maxphi
    	Double maxPhi = Math.PI * 2;
    	Double phiParts = maxPhi / 50;
    	System.out.println("Theta " + maxPhi + " " +phiParts);
    	Double getAnglePhi = 0.0;
    	
	    for(int r = 0; r < 10; r++) {
	    	radius = aSubCero * r;
	    	for(int i=0; i < 50; i++) {
	    		//Para "x"
	    		for(int j=0; j < 40; j++) {
	    			Double x = radius * Math.sin(getAngleTheta) * Math.cos(getAnglePhi);
	    			Double y = radius * Math.sin(getAngleTheta) * Math.sin(getAnglePhi);
	    			Double z = radius * Math.cos(getAngleTheta);
	    			getAngleTheta = getAngleTheta + thetaParts;
	    			
//            		float probabilidad = (float) calcularFuncionNlLoMo(radius, aSubCero);
            		float probabilidad = (float) calcularFuncionNllLlMo(radius, getAngleTheta, aSubCero);
            		float probFormat = Float.parseFloat(String.format("%.7f", probabilidad));
	    			
	    			if(probFormat < 0.3333333) {
	    				red = 1;
	    				g = 0;
	    				b = 0;
	    			}else if(probFormat < 0.6666666) {
	    				red = 0;
	    				g = 1;
	    				b = 0;
	    			}else {
	    				red = 0;
	    				g = 0;
	    				b = 1;
	    			}
	    			
//	    			getRadius = getRadius + radiusParts;
	                points[index] = new Coord3d(x, y, z);
	                
	                colors[index] = new Color(red, g, b, 0.5f);
	                index++;
	    		}
	    		getAnglePhi = getAnglePhi + phiParts;
	    		getAngleTheta = 0.0;
	    	}
	    	getAnglePhi = 0.0;
	    	getAngleTheta = 0.0;
	    }
    	Points pointsDto = new Points(points, colors);
    	return pointsDto;

	}

    
    public double calcularFuncionNlLoMo(Double radius, Double aSubCero) {
		
    	Double exponencial = Math.E;
//    	Double reducePlanck = 1.054471817;
//    	Double electronMass = 9.109383;
//    	Double electronCharge = 1.602176;
//    	Double electronChargeSquare = Math.pow(electronCharge, 2);
    	
//    	Double reducePlanckSquare = Math.pow(reducePlanck, 2.0);
//    	Double denomin = electronMass * electronChargeSquare;
    	
    	//aSubCero x E1
//    	Double aSubCeroNotCient = reducePlanckSquare / denomin;
//    	Double aSubCero = aSubCeroNotCient * 10;
    	
    	Double rootBase = Math.PI * Math.pow(aSubCero, 3.0);
    	
//    	Double denominCoeficient = Math.sqrt(rootBase);
    	
    	Double coeficient = 1 / rootBase;
    	
    	Double exponencialFraction = 2 / aSubCero;
    	
    	Double exponent = exponencialFraction * radius;
    	Double exponencialRes = 1 / (Math.pow(exponencial, exponent));
    	
    	Double probFunction = exponencialRes * coeficient;
     
	   return probFunction;
//    	
//    	Double constantarg = Math.PI/L;
//		Double pot = Math.pow(L, 3.0);
//		Double a = 8 / pot;
//		Double constantind = a;
//		
//		//Argumentos de las razones trigonométricas Seno
//		Double argx = Double.parseDouble(String.format("%.7f", constantarg * nx * x));
//		Double argy = (constantarg * ny * y);
//		Double argz = (constantarg * nz * z);
//
//		//Seno de cada eje
//		double sinx = Math.sin(argx);
//		double siny = Math.sin(argy);
//		double sinz = Math.sin(argz);
//		
//		//Seno al cuadrado
//		double potx = Math.pow(sinx, 2.0);
//		double poty = Math.pow(siny, 2.0);
//		double potz = Math.pow(sinz, 2.0);
		
		//Probabilidad
//		double prob = constantind * potx * poty * potz;
//		
//		return prob;
	}
    
    public double calcularFuncionNllLlMo(Double radius, Double theta, Double aSubCero) {
		
    	Double exponencial = Math.E;
	
    	Double rootBase = 32 * Math.PI * Math.pow(aSubCero, 5.0);
    	
//    	Double denominCoeficient = Math.sqrt(rootBase);
    	
    	Double coeficient = (1 / rootBase) * (Math.pow(radius, 2.0));
    	
    	Double exponencialFraction = 1 / aSubCero;
    	
    	Double exponent = exponencialFraction * radius;
    	Double exponencialRes = 1 / (Math.pow(exponencial, exponent));
    	
    	Double cosine = Math.cos(theta);
    	Double cosSquare = Math.pow(cosine, 2.0);
    	
    	Double probFunction = exponencialRes * coeficient *cosSquare;
	    
    	System.out.println("Prob: " + probFunction);
    	
    	if(probFunction > 0.7) {
    		System.out.println("Prob aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa: " + probFunction);
    	}
	   return probFunction;
//    	
//    	Double constantarg = Math.PI/L;
//		Double pot = Math.pow(L, 3.0);
//		Double a = 8 / pot;
//		Double constantind = a;
//		
//		//Argumentos de las razones trigonométricas Seno
//		Double argx = Double.parseDouble(String.format("%.7f", constantarg * nx * x));
//		Double argy = (constantarg * ny * y);
//		Double argz = (constantarg * nz * z);
//
//		//Seno de cada eje
//		double sinx = Math.sin(argx);
//		double siny = Math.sin(argy);
//		double sinz = Math.sin(argz);
//		
//		//Seno al cuadrado
//		double potx = Math.pow(sinx, 2.0);
//		double poty = Math.pow(siny, 2.0);
//		double potz = Math.pow(sinz, 2.0);
		
		//Probabilidad
//		double prob = constantind * potx * poty * potz;
//		
//		return prob;
	}
    
}
