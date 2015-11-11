import java.awt.Point;
import java.awt.Color;

public class Beech extends Tree {
	
	
	public Beech(Point pos, double initialSize) {
		super(pos, initialSize);
		color = new Color(0, 0, 255);
		GROW_RATE = 1;
	}

	public void grow()
	{
		size += GROW_RATE;
	}
}
