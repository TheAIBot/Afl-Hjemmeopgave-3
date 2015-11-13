import java.awt.Point;
import java.awt.Color;

public class Spruce extends Tree {
	
	public Spruce(Point pos, double initialSize) {
		super(pos, initialSize, Color.GREEN, 0.5);
		/*
		super(pos, initialSize);
		color = new Color(255, 0, 0);
		GROW_RATE = 0.5;
		*/
	}
}
