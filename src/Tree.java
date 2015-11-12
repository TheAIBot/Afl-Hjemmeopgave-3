import java.awt.Point;
import java.util.ArrayList;
import java.awt.Color;

public class Tree {
	protected Point position;
	protected double size;
	protected final double GROW_RATE;
	private final Color COLOR;
	
	/*
	public Tree(Point pos, double initialSize)
	{
		this.size = initialSize;
		this.position = pos;
	}
	*/
	
	public Tree(Point pos, double initialSize, Color color, double growRate)
	{
		this.size = initialSize;
		this.position = pos;
		this.COLOR = color;
		this.GROW_RATE = growRate;
	}
	
	public void grow()
	{
		size += GROW_RATE;
	}
	
	public Color getColor()
	{
		return COLOR;
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