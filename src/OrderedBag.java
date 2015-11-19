import java.util.Collections;

/**
 * A bag which is always sorted
 * 
 */
public class OrderedBag extends SimpleBag {

	/**
	 * Add the string "str" to the strings in the bag so the bag continues to be
	 * sorted. If str was added then the method returns "true" and "false"
	 * otherwise.
	 * @param str The element to be added to the bag.
	 * @return true if successfully added
	 */
	public boolean addString(String str) {
		// To make it so the bag is always sorted, the elements are added in a
		// position, where the result is a sorted list.
		// Since this is the only way to add an element to the bag, the binary
		// search method can be implemented, to speed up the process - the list
		// is always sorted.
		int indexBinarySearch = betterBinarySearch(str);
		// Finds the index where the element should be placed.
		// IndexBinarySearch can be negative to indicate whether the value is
		// already contained in the bag.
		// Since repetition doesn't matter in OrderedBag, the index where it
		// should be placed is simply found.
		int indexToBeAdded = getIndexFromBinarySearchIndex(indexBinarySearch);
		theBag.add(indexToBeAdded, str);
		return true;
	}

	/**
	 * Returns the value found by java's binarySearch method, where the
	 * comparator is made to handle null.
	 * @param str Element to find the index of.
	 * @return Returns the same value as Java's binarySearch but with null handling.
	 */
	protected int betterBinarySearch(String str) {
		// If the element searched for is found with binary search, it returns
		// the index of one of the occurrences.
		// Binary search returns -(index - 1) if the collection doesn't contain
		// the value already, where index is the index where the element that is
		// searched for can be added to, without unsorting the list.
		return Collections.binarySearch(theBag, str, (x, t) -> {
			// Handles null by moving it to the start of the list
			if (t == null && x == null) {
				return 0;
			} else if (t == null) {
				return 1;
			} else if (x == null) {
				return -1;
			}
			return x.compareTo(t);
		});
	}

	/**
	 * Returns whether or not an element is contained in a bag/list/collection,
	 * based on a binary search result.
	 * @param binaryIndex
	 * @return Search result from a binarySearch.
	 */
	protected boolean isContainedBinarySearch(int binaryIndex) {
		// A binary search returns a positive result or 0 if an element searched
		// for in a collection is contained, else a negative.
		return (binaryIndex >= 0);
	}

	/**
	 * Returns an index, based on a binarySearch index, where an element can be
	 * placed in a sorted list, so it is still sorted. 
	 * @param binaryIndex Search result from a binarySearch.
	 * @return The non-negative index where the element should be placed.
	 */
	protected int getIndexFromBinarySearchIndex(int binaryIndex) {
		// binarySearch returns -(index - 1) if the collection doesn't contain
		// the value that's looked for or else the index of (one of) the
		// occurrence(s) in the collection.
		// To return the index where it should be placed, the reversed formula
		// is returned if the binary search didn't find the element in the
		// collection,
		// or if it is contained, it returns the index found.
		return (!isContainedBinarySearch(binaryIndex)) ? -(binaryIndex + 1) : binaryIndex;
	}
}
