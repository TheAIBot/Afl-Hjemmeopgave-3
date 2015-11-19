/**
 * A bag which is always sorted without repeating elements.
 *
 */
public class OrderedBagWithoutRepetitions extends OrderedBag {

	/**
	 * Add the string "str" to the strings in the bag so the bag continues to be
	 * sorted if it's not already in the bag. If str was added then the method
	 * returns "true" and "false" otherwise.
	 * 
	 * @param str
	 * @return true if successfully added
	 */
	public boolean addString(String str) {

		// Using betterBinarySearch to figure out if the element is already in
		// the bag, and at the same time to find the index that element should be
		// inserted at, if it is not already in the bag.
		int indexBinarySearch = betterBinarySearch(str);
		if (!isContainedBinarySearch(indexBinarySearch)) {
			theBag.add(getIndexFromBinarySearchIndex(indexBinarySearch), str);
			return true;
		}
		return false;
	}

	public boolean removeAllOccurrences(String str) {
		// because the bag is sorted and becausethere is only 0 or 1 elements to
		// remove, betterBinarySearch is used to find the index of the element to remove
		// if it is in the bag.
		int deletionIndex = betterBinarySearch(str);
		if (isContainedBinarySearch(deletionIndex)) {
			theBag.remove(deletionIndex);
			return true;
		}
		return false;
	}

}
