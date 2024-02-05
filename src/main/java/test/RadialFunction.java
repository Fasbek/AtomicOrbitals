package test;

public class RadialFunction {
		
	 public double calcularR20(Double theta) {

		 double cosineSquare = (3 * Math.pow(Math.cos(theta), 2.0)) - 1;
		 double fraction = 5 / Math.PI;
		 double root = Math.sqrt(fraction);
		 double res = 0.25 *root * cosineSquare;
		 
		 return res;

	}
	 
	 public double calcularR10(double radius) {
		 
		 double z = 1.0;
		 
		 //Se considera al radio de bohr como 1 
		 //por ser constante y debido a que los valores
		 //para el radio serán sus múltiplos
		 double aSubCero = 1.0;
		 double aSubCeroCube = Math.pow(aSubCero, 3);
		 double aSubCeroSquareDen = Math.sqrt(aSubCeroCube);
		 double factorASubCeroSquare = 1 / aSubCeroSquareDen;
		 
		 //Exponencial
		 double exponent = radius / aSubCero;
		 double exponential = 1 / Math.pow(Math.E, exponent);
		 
		 //Radial Function
		 double radialFunction = exponential * 2 * factorASubCeroSquare;
		 
		 System.out.println("radius Past: " + radius);
		 System.out.println("Radial Function Past: " + radialFunction);
		 return radialFunction;

	}
	 
	 public double calcularR10Prueba(double radius) {
		 
		 double z = 1.0;
		 
		 //Se considera al radio de bohr como 1 
		 //por ser constante y debido a que los valores
		 //para el radio serán sus múltiplos
		 double aSubCero = 1.0;
		 double aSubCeroCube = Math.pow(aSubCero, 3);
		 double aSubCeroSquareDen = Math.sqrt(aSubCeroCube);
		 double factorASubCeroSquare = 1 / aSubCeroSquareDen;
		 double sqrtPi = Math.sqrt(Math.PI);
		 double overSqrtPi = 1 / sqrtPi;
		 double factorNorm = factorASubCeroSquare * overSqrtPi;
		 
		 //Exponencial
		 double exponent = radius / aSubCero;
		 double exponential = 1 / Math.pow(Math.E, exponent);
		 
		 //Radial Function
		 double function = exponential * factorNorm;
		 
		 System.out.println("radius Past: " + radius);
		 System.out.println("Radial Function Past: " + function);
		 return function;

	}
	 
	 public double calcularR20Prueba(double radius, double aSubCero) {
		 
		 double z = 1.0;
		 
		 //Se considera al radio de bohr como 1 
		 //por ser constante y debido a que los valores
		 //para el radio serán sus múltiplos
		 
		 double aSubCeroPowerThree = Math.pow(aSubCero, 3);
		 double aSubCeroSquareDen = Math.sqrt(aSubCeroPowerThree);
		 double factorASubCeroSquare = 1 / aSubCeroSquareDen;
		 double sqrtPiTimesFour = Math.sqrt(Math.PI * 32);
		 double overSqrtPi = 1 / sqrtPiTimesFour;
		 double factorNorm = factorASubCeroSquare * overSqrtPi;
		 
		 //Factor medio (2-r/a)
		 double div = radius / aSubCero;
		 double resta = 2 - div;
		 
		 //Exponencial
		 double twoTimesASubCero = aSubCero * 2;
		 double exponent = radius / twoTimesASubCero;
		 double exponential = 1 / Math.pow(Math.E, exponent);
		 
		 //Radial Function
		 double function = exponential * resta * factorNorm;
		 
		 
		 System.out.println("radius Past: " + radius);
		 System.out.println("Radial Function Past: " + function);
		 return function;

	}
	 
	 public double calcularR21Prueba(double radius, double theta) {
		 
		 double z = 1.0;
		 
		 //Se considera al radio de bohr como 1 
		 //por ser constante y debido a que los valores
		 //para el radio serán sus múltiplos
		 double aSubCero = 1.0;
		 double aSubCeroPowerFive = Math.pow(aSubCero, 5);
		 double aSubCeroSquareDen = Math.sqrt(aSubCeroPowerFive);
		 double factorASubCeroSquare = 1 / aSubCeroSquareDen;
		 double sqrtPiTimesFour = 4 * Math.sqrt(Math.PI * 2);
		 double overSqrtPi = 1 / sqrtPiTimesFour;
		 double factorNorm = factorASubCeroSquare * overSqrtPi;
		 
		 //Exponencial
		 double twoTimesASubCero = aSubCero * 2;
		 double exponent = radius / twoTimesASubCero;
		 double exponential = 1 / Math.pow(Math.E, exponent);
		 
		 //Radial Function
		 double function = exponential * factorNorm * radius * Math.cos(theta);
		 
		 System.out.println("radius Past: " + radius);
		 System.out.println("Radial Function Past: " + function);
		 return function;

	}
	 
	 public double calcularR21menos1Prueba(double radius, double theta) {
		 
		 double z = 1.0;
		 
		 //Se considera al radio de bohr como 1 
		 //por ser constante y debido a que los valores
		 //para el radio serán sus múltiplos
		 double aSubCero = 1.0;
		 double aSubCeroPowerFive = Math.pow(aSubCero, 5);
		 double aSubCeroSquareDen = Math.sqrt(aSubCeroPowerFive);
		 double factorASubCeroSquare = 1 / aSubCeroSquareDen;
		 double sqrtPiTimesFour = 4 * Math.sqrt(Math.PI * 2);
		 double overSqrtPi = 1 / sqrtPiTimesFour;
		 double factorNorm = factorASubCeroSquare * overSqrtPi;
		 
		 //Exponencial
		 double twoTimesASubCero = aSubCero * 2;
		 double exponent = radius / twoTimesASubCero;
		 double exponential = 1 / Math.pow(Math.E, exponent);
		 
		 //Radial Function
		 double function = exponential * factorNorm * radius * Math.cos(theta);
		 
		 System.out.println("radius Past: " + radius);
		 System.out.println("Radial Function Past: " + function);
		 return function;

	}
		
	 public double calcularR21(Double radius) {

		 double aSubCero = 0.2;
		 double aSubCeroExp = Math.pow(aSubCero, 5);
		 double aSubCeroSquareDen = Math.sqrt(aSubCeroExp);
		 double factorASubCeroSquare = 1 / aSubCeroSquareDen;
		 
		 //Factor fracción
		 double fraction = (double) 1 / 24;
		 double fracRoot = Math.sqrt(fraction);
		 
		 //Factor Rho
//		 double factorRho = radius / aSubCero;
		 
		 //Exponencial
		 double exponent = radius / (aSubCero * 2);
		 double exponential = 1 / Math.pow(Math.E, exponent);
		 
		 //Radial Function
		 double radialFunction = exponential * radius * fracRoot * factorASubCeroSquare;
		 
		 System.out.println("radius Past: " + radius);
		 System.out.println("Radial Function Past: " + radialFunction);
		 
		 return radialFunction;

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
	
}
