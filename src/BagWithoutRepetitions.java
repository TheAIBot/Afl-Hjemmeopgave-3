

/**
 * A bag without any repeated elements - ie. a set, but with indexes.
 * @author jesper
 *
 */
public class BagWithoutRepetitions extends SimpleBag{
	//Skal man tage højde for hvis den sættes lig med noget?(*)
	
	public boolean addString(String str) {
		return (theBag.contains(str))? theBag.add(str): false;
	}
}
