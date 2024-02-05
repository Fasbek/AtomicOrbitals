package test;

import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;

public class Points {

	private Coord3d[] points;
	private Color[] colors;

	public Points(Coord3d[] points, Color[] colors) {
		this.points = points;
		this.colors = colors;
	}

	public Coord3d[] getPoints() {
		return points;
	}

	public void setPoints(Coord3d[] points) {
		this.points = points;
	}

	public Color[] getColors() {
		return colors;
	}

	public void setColors(Color[] colors) {
		this.colors = colors;
	}

}
