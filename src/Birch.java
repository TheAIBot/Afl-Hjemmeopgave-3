import java.awt.Point;
import java.awt.Color;

public class Birch extends Tree {
	
	
	public Birch(Point pos, double initialSize) {
		super(pos, initialSize);
		color = new Color(0, 255, 0);
		GROW_RATE = 0.7;
	}
}
