import java.awt.Point;
import java.awt.Color;

public class MagicTree extends Tree {
	//The magic tree is a kind of tree, and therefore extends Tree. Other than the normal traits of a tree,
	//it has the special chareteristic of sometimes shrinking, 
	//and sometimes teleporting (and it always teleport atleast once every 20 step). 
	
	//The extra variables/constans needed for the tree:
	final int SHRINK_RATE = 10; //The magic tree has a 1/10 chance of shrinking
	private int TELEPORT_FREQUENCY = 20; //The magic tree has abaut a 1/20 chance of teleporting.
	private int stepsSinceLastTeleport = 1;	//A counter of the number of turns since the last teleport.
	
	/**
	 * A magic tree, which has the normal traits of a tree, but alsom sometimes shrinks and teleports, 
	 * and always starts in the middle of the board.
	 * It is gray, and grows the second fastest of all the trees.. 
	 * @param pos The position that the magic tree should start at.
	 * @param initialSize The size that the magic tree starts with.
	 */
	public MagicTree(Point pos, double initialSize) {
		super(pos, initialSize, Color.GRAY, 0.8);
	}
	
	/**
	 * Grows the tree one tick/turns worth of growth.
	 */
	public void grow()
	{
		//The growth is a little different from the normal trees, as it has a 1/10 chance of shrinking. 
		//This is determined by getting a random value:
		if (ConstAndUtil.getRandomIntBetween(1, SHRINK_RATE) == SHRINK_RATE &&
			size - GROW_RATE > 0) {
			size -= GROW_RATE;
		} else {
			size += GROW_RATE;
		}
		//It should also sometimes teleport:
		if (shouldDoTeleport()) {
			teleport();
			stepsSinceLastTeleport = 1;
		}
		else {
			stepsSinceLastTeleport++;
		}
	}
	
	/**
	 * Method for checking if the magic tree should teleport or not.
	 * @return True/false depending on whether or not it should teleport.
	 */
	private boolean shouldDoTeleport()
	{
		//Checks if it has been 20 turns since the last teleport, and if so, returns true. 
		//If not, it checks if "is time" for a random teleport.
		return (stepsSinceLastTeleport == TELEPORT_FREQUENCY)? true: (ConstAndUtil.getRandomIntBetween(1, TELEPORT_FREQUENCY) == TELEPORT_FREQUENCY);		
	}
	
	/**
	 * Teleports the tree to a random legal position. (*)Eventuelt omnavngiv	
	 */
	private void teleport()
	{
		position = ConstAndUtil.getLegalRandomPosition();
	}
}
