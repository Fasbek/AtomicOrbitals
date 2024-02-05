package test;

import java.util.Random;
import java.util.Scanner;

import org.jzy3d.analysis.AbstractAnalysis;
import org.jzy3d.analysis.AnalysisLauncher;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;
public class Test extends AbstractAnalysis{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AnalysisLauncher.open(new Test());
	}
	
//	@Override
	public void init() {

		ParticleInBox particleInBox = new ParticleInBox();
		HydrogenAtom hydrogen = new HydrogenAtom();
		SphericalHarmonics sphericalHarmonics = new SphericalHarmonics();
		Orbitales orbitals = new Orbitales();
		
		String m = "";
		Scanner read = new Scanner(System.in);
		System.out.println("Ingresar número cuántico n: ");
		int n = read.nextInt();
		System.out.println("Ingresar número cuántico l: ");
		int l = read.nextInt();
		if(n == 2 && l == 1) {
			System.out.println("Ingresar el eje del orbital (px, py o pz): ");
			m = read.next();
		}else {
			System.out.println("Ingresar número cuántico m: ");
			m = read.next();  
		}

//
//		System.out.println("Mostrar grÃ¡fico con corte transversal: ");
//		System.out.println("1 = SÃ­, 0 = No");
//		int corte = read.nextInt();
//		Points pointsDto = sphericalHarmonics.iniciarPrueba(n, l, m, corte);
//		Points pointsDto = sphericalHarmonics.iniciar(n, l, m);
//		Points pointsDto = sphericalHarmonics.iniciarFunction(n, l, m);
		Points pointsDto = orbitals.iniciar(n, l, m);
//		Points pointsDto = particleInBox.iniciar();
//		double r = Math.asin(0.5);
//		System.out.println("Res: " + r);
		
//        float probabilidadPrueba = (float) particleInBox.calcularFuncion(2, 28.95502437f, 4, 2, 28.95502437f, 2, 28.95502437f);
//        System.out.println("prob prueba " + probabilidadPrueba);
        
        Scatter scatter = new Scatter(pointsDto.getPoints(), pointsDto.getColors());
        chart = AWTChartComponentFactory.chart(Quality.Advanced, "newt");
        chart.getScene().add(scatter);
    }

}
