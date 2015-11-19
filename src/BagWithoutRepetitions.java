
/**
 * A bag without any repeated elements - ie. a set, but with indexes.
 *
 */
public class BagWithoutRepetitions extends SimpleBag {

	public boolean addString(String str) {
		// If the string already is contained in the bag, it doesen't add the
		// element to the bag and returns false, else it add's the element and
		// returns true.
		return (theBag.contains(str)) ? theBag.add(str) : false;
	}
}
