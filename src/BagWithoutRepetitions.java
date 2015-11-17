

/**
 * A bag without any repeated elements - ie. a set, but with indexes.
 * @author jesper
 *
 */
public class BagWithoutRepetitions extends OrderedBagWithoutRepetitions{
	//Skal man tage højde for hvis den sættes lig med noget?(*)

	public boolean addString(String str) {
		int[] strInsertioninformation = getSortedInsertionIndexAndIsContained(str);
		if (strInsertioninformation[CONTAINS_INDEX] == DOES_NOT_CONTAIN_STRING) {
			theBag.add(str);
		}
		return false;
	}
}
