import java.awt.Point;
import java.awt.Color;

public class Beech extends Tree {
	
	
	public Beech(Point pos, double initialSize) {
		super(pos, initialSize, new Color(0, 0, 255), 1);
		/*
		super(pos, initialSize);
		color = new Color(0, 0, 255);
		GROW_RATE = 1;
		*/
	}
}
