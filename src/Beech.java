import java.awt.Point;
import java.awt.Color;

/**
 * A class representing a beech tree, 
 * containing all the relevant methods and information concerning such a tree.
 */
public class Beech extends Tree {
	// The beech is a kind of tree, and therefore extends Tree. It has no
	// special traits compared to other trees,
	// and is therefore simply an initialization of a Tree, with the traits
	// described below:
	/**
	 * A beech tree, which has the normal traits of a tree, is cyan colored, and
	 * grows the fastest of all the different tree species. 
	 * @param pos The position that the beech should start at.
	 * @param initialSize The size that the beech tree starts with.
	 */
	public Beech(Point pos, double initialSize) {
		// The beech was to be the fastest growing tree, why its growrate is set
		// equal to 1, which is higher than every other tree's growthrate.
		super(pos, initialSize, Color.CYAN, 1);
	}
}
