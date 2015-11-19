import java.awt.Point;
import java.awt.Color;

/**
 * A class representing a spruce tree, containing all the relevant methods and
 * information concerning such a tree.
 */
public class Spruce extends Tree {
	// The Spruce is a kind of tree, and therefore extends Tree. It has no
	// special traits compare to other trees,
	// and is therefore simply an initialization of a Tree, with the traits
	// described below:
	/**
	 * A spruce tree, which has the normal traits of a tree, is green, and grows
	 * the slowest of all the trees. 
	 * @param pos The position that the spruce should start at.
	 * @param initialSize The size that the spruce tree starts with.
	 */
	public Spruce(Point pos, double initialSize) {
		// The growth rate of the spruce needs to be the lowest, why it is set
		// equal to 0.5.
		super(pos, initialSize, Color.GREEN, 0.5);
	}
}
