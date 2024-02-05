package test;

public class WaveFunctionsHidrogenAtom {

	public double orbital2PYO2PX(double radius) {
		
		double aSubCero = 1;
		double den = radius / aSubCero;
		double exponent = den/2;
		double num = 0.2325 * Math.pow(Math.E, exponent);
		double senFractionRes = num / den;
		double root = Math.asin(senFractionRes);

		return root;
		
	}
	
	public double orbital2PZ(double radius) {
		
		double aSubCero = 1;
		double den = radius / aSubCero;
		double exponent = den/2;
		double num = 0.2325 * Math.pow(Math.E, exponent);
		double senFractionRes = num / den;
		double root = Math.acos(senFractionRes);

		return root;
		
	}

}
