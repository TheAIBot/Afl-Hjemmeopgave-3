

/**
 * A bag without any repeated elements - ie. a set, but with indexes.
 * @author jesper
 *
 */
public class BagWithoutRepetitions extends SimpleBag{
	//Skal man tage højde for hvis den sættes lig med noget?(*)

	public boolean addString(String str) {
		//It onl
		return (theBag.contains(str))? false : super.addString(str);
	}
		
}
