/**
 * A bag wherein the elements always are placed in a sorted order.
 * @author jesper *
 */
public class OrderedBag extends OrderedBagWithoutRepetitions{

	public boolean addString(String str) {
		int[] strInsertioninformation = getSortedInsertionIndexAndIsContained(str);
		theBag.add(strInsertioninformation[INSERTION_INDEX], str);
		return true;
	}
}
