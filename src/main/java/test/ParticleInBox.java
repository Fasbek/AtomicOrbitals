package test;

import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;

public class ParticleInBox {
	
	public Points iniciar() {
		
		int size = 60;
        float x;
        float y;
        float z;
        float a;
        Integer index = 0;
	        
        Coord3d[] points = new Coord3d[size*size*size];
        Color[] colors = new Color[size*size*size];

        float red = 0.0f;
        float g = 0.0f;
        float b = 1f;
        
        for (int i = 0; i < size; i++) {
        	for(int j = 0; j < size; j++) {
        		for(int w = 0; w < size; w++) {
        			
        			x= (float) i/30;
        			y= (float) j/30;
        			z= (float) w/30;
        			
            		float probabilidad = (float) calcularFuncion(2, x, size/30, 2, y, 1, z);
            		float probFormat = probabilidad;
        			
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

                    points[index] = new Coord3d(x, y, z);
                    
                    colors[index] = new Color(red, g, b, 0.5f);
                    index++;
        		}
        	}
        }
	     
        Points pointsDto = new Points(points, colors);
	    
        return pointsDto;
        
	}
	
	public double calcularFuncion(int nx, float x, int L, int ny, float y, int nz, float z) {
		Double constantarg = Math.PI/L;
		Double pot = Math.pow(L, 3.0);
		Double a = 8 / pot;
		Double constantind = a;
		
		//Argumentos de las razones trigonométricas Seno
		Double argx = (constantarg * nx * x);
		Double argy = (constantarg * ny * y);
		Double argz = (constantarg * nz * z);

		//Seno de cada eje
		double sinx = Math.sin(argx);
		double siny = Math.sin(argy);
		double sinz = Math.sin(argz);
		
		//Seno al cuadrado
		double potx = Math.pow(sinx, 2.0);
		double poty = Math.pow(siny, 2.0);
		double potz = Math.pow(sinz, 2.0);
		
		//Probabilidad
		double prob = constantind * potx * poty * potz;
		
		return prob;
	}
}
