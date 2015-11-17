import java.util.*;
import java.util.Collections;

/**
 * A bag of string. To this there can be added elements, removed some, 
 * a copy can be taken out, and the number of elements can be found.
 * @author jesper
 *
 */
public class SimpleBag implements Bag{
	protected final List<String> theBag = new ArrayList<String>();

	@Override
	public boolean addString(String str) {
		//Add returns the truth value true, no matter what.
		return theBag.add(str);
	}

	@Override
	public boolean removeAllOccurrences(String str) {
		//removeAll returns true if at least one lement is removed, or else false. 
		//An singleton is used, as only one element needs to be checkes for and removed.
		return theBag.removeAll(Collections.singleton(str));
	}

	@Override
	public String getString(int index) {
		//The size of the bag needs to be greater than the index, as the size of the bag - 1 is the last element.
		return (theBag.size() > index && index >= 0)? theBag.get(index): null;
	}

	@Override
	public int noOfElements() {
		return theBag.size(); //If there are no elements(*)Hvad med null? Og skulle der -1 til?
	}

}
