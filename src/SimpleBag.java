import java.util.*;
import java.util.Collections;

/**
 * A bag of string. To this there can be added elements, removed some, a copy of
 * an element can be taken out, and the number of elements can be found.
 *
 */
public class SimpleBag implements Bag {
	// An ArrayList where the strings are stored.
	protected final List<String> theBag = new ArrayList<String>();

	@Override
	public boolean addString(String str) {
		// Adds the element to the bag - the .add method always returns true, in
		// the case of an normal ArrayList.
		return theBag.add(str);
	}

	@Override
	public boolean removeAllOccurrences(String str) {
		// removeAll returns true if at least one element is removed, or else false.
		// A singleton is used, as only one element needs to be checked for and removed.
		return theBag.removeAll(Collections.singleton(str));
	}

	@Override
	public String getString(int index) {
		// A boundary check is made to make sure the index is valid.
		return (theBag.size() > index && index >= 0) ? theBag.get(index) : null;
	}

	@Override
	public int noOfElements() {
		return theBag.size();
	}

}
