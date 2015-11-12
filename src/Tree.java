import java.awt.Point;
import java.util.ArrayList;
import java.awt.Color;

public class Tree {
	protected Color color;
	protected Point position;
	protected double size;
	double GROW_RATE;
	
	
	public Tree(Point pos, double initialSize)
	{
		this.size = initialSize;
		this.position = pos;
	}
	
	public Tree(Point pos, double initialSize, Color color, double growRate)
	{
		this.size = initialSize;
		this.position = pos;
		this.color = color;
		this.GROW_RATE = growRate;
	}
	
	public void grow()
	{
		size += GROW_RATE;
	}
	
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