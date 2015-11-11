import java.awt.Point;
import java.util.ArrayList;
import java.awt.Color;

public abstract class Tree {
	protected Color color;
	protected Point position;
	protected double size;
	double GROW_RATE;
	
	public Tree(Point pos, double initialSize)
	{
		size = initialSize;
		position = pos;
	}
	
	public abstract void grow();
	
	public Color getColor()
	{
		return color;
	}
	
	public Point getPosition()
	{
		return position;
	}
	
	public double getSize()
	{
		return size;
	}
}