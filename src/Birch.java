import java.awt.Point;
import java.awt.Color;

/**
 * A class representing a birch tree, containing all the relevant methods and
 * information concerning such a tree. The best tree - Jesper Birch.
 */
public class Birch extends Tree {
	// The birch is a kind of tree, and therefore extends Tree. It has no
	// special traits compare to other trees,
	// and is therefore simply an initialization of a Tree, with the traits
	// described below:
	
	/**
	 * A Birch tree, which has the normal traits of a tree, is blue, and is the
	 * second slowest growing tree. 
	 * @param pos The position that the beech should start at.
	 * @param initialSize The size that the beech tree starts with.
	 */
	public Birch(Point pos, double initialSize) {
		super(pos, initialSize, Color.BLUE, 0.7);
	}
}
