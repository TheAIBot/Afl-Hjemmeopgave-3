import java.awt.Point;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Base class for all trees. It contains relevant methods used by a tree, and
 * the basic information associated with an arbitrary tree.
 */
public abstract class Tree {
	// A tree always have the following traits, where only one changes, the size.
	protected Point position;
	protected double size;
	protected final double GROW_RATE;
	private final Color COLOR;

	/**
	 * The basis for all tree's, which has all the basic traits that all trees
	 * have. It is defined by it's position in the "forrest", its initial size,
	 * the color of the tree, and how fast it grows. 
	 * @param pos The position the tree starts at. If it is an illegal position, 
	 * then a new random legal position is found for the tree to start at.
	 * @param initialSize The initial size of the tree. Must not be negative.
	 * @param color The color of the tree.
	 * @param growRate The growth rate of the tree, ie. how much the size changes
	 * every tick.
	 */
	
	public Tree(Point pos, double initialSize, Color color, double growRate) {
		//The starting position musn't be illegal, so if it is illegal,
		//then a random legal position is chosen for the tree.
		if (!ConstAndUtil.positionOK(pos)) {
			pos = ConstAndUtil.getLegalRandomPosition();
		}
		this.size = initialSize;
		this.position = pos;
		this.COLOR = color;
		this.GROW_RATE = growRate;
	}

	/**
	 * Grows the tree using the formula size(n) = size(n-1) + c, where n is the
	 * current tick/turn, and c is the constant Growth_Rate.
	 */
	public void grow() {
		// When the tree grows, it's size changes depending on the growth rate.
		size += GROW_RATE;
	}

	/**
	 * Gets the color of the tree. 
	 * @return The color of the tree.
	 */
	public Color getColor() {
		return COLOR;
	}

	/**
	 * Gets the position of the tree 
	 * @return The position of the tree.
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Gets the size of the tree. 
	 * @return The size of the tree.
	 */
	public double getSize() {
		return size;
	}
}