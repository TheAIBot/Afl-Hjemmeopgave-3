import java.awt.Point;
import java.awt.Color;

public class MagicTree extends Tree {
	final int SHRINK_RATE = 10;
	private int TELEPORT_FREQUENCY = 20;
	private int stepsSinceLastTeleport = 1;
	
	
	public MagicTree(Point pos, double initialSize) {
		super(pos, initialSize, new Color(255, 0, 255), 0.7);
		/*
		super(pos, initialSize);
		color = new Color(255, 0, 255);
		GROW_RATE = 0.7;
		*/
	}

	public void grow()
	{
		if (ConstAndUtil.getRandomIntBetween(0, 100) <= SHRINK_RATE &&
			size - GROW_RATE > 0) {
			size -= GROW_RATE;
		} else {
			size += GROW_RATE;
		}
		if (shouldDoTeleport()) {
			teleport();
			stepsSinceLastTeleport = 1;
		}
		else {
			stepsSinceLastTeleport++;
		}
	}
	
	private boolean shouldDoTeleport()
	{
		//Oneliners for the win!!! Dont delete it, please Andreas...
		return (stepsSinceLastTeleport == TELEPORT_FREQUENCY)? true: (ConstAndUtil.getRandomIntBetween(0, 20) == 0);		
		/*
		if (stepsSinceLastTeleport == TELEPORT_FREQUENCY) {
			return true;
		}
		return (ConstAndUtil.getRandomIntBetween(0, 20) == 0); 
		*/
	}
	
	private void teleport()
	{
		position = ConstAndUtil.getLegalRandomPosition();
	}
}
