package geometri;

import java.awt.Color;
import java.awt.Graphics;
/**
 * A Class for modeling a oval. The Oval class is an extension of the GeometricalObject class
 * @author mselin and rikhel
 */
public class Oval extends GeometricalObject {
	/**
	 * A constructor for creating basic oval of specified length, color and position.
	 * @param x x-position
	 * @param y y-position
	 * @param width of oval
	 * @param height of oval
	 * @param c color of oval
	 * @throws IllegalPositionException if either coordinate is negative
	 */
	public Oval(int x, int y, int width,int height, Color c) throws IllegalPositionException{
		super(x,y,width,height,calcPerimeter(width,height),calcArea(width,height),c);
	}

	/**
	 * Constructor which creates a oval of specified size and color. 
	 * The oval will be positioned at same place as the object given.
	 * @param f object which this will be at same position as
	 * @param side width of oval
	 * @param c color of oval
	 */
	public Oval(GeometricalForm f, int width,int height, Color c){
		super(f,width,height,calcPerimeter(width,height),calcArea(width,height),c);
	}
	/**
	 * Function for calculating oval area
	 * @param width width of oval
	 * @param height height of oval
	 * @return area of oval
	 */
	private static int calcArea(int width, int height){
		return ((int) (3.14/4*width*height));
	}
	/**
	 * Function for calculating oval perimeter
	 * @param width width of oval
	 * @param height height of oval
	 * @return perimeter of oval
	 */
	private static int calcPerimeter(int width, int height){
		return (int) (3.14*2*Math.sqrt(((height)*(height)+(width)*(width))/8.0));
	}
	@Override
	/**
	 * paints the oval
	 */
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), getWidth(), getHeight());
	}
	@Override
	/**
	 * Creates hashCode
	 */
	public int hashCode() {
		return 5 + 7*getColor().hashCode();
	}

}
