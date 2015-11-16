/**
 * A bag wherein the elements always are placed in a sorted order.
 * @author jesper *
 */
public class OrderedBag extends SimpleBag{

	public boolean addString(String str) {
		//Since the list will always be sorted, as the only way to change the list is to remove elements of an type,
		//or add them, whithout one being apple to specify an index, kepping the bag sorted can be done by adding in the string sent,
		//to the place in the list, so that the element before it in the list, if there is any, comes before it in the sorting, 
		//and so the same is true for the element following it, if there is any.
		theBag.add(getSortedInsertionIndex(str), str);
		return true;
	}
	/** Returns an index for where a string needs to be placed, 
	 *  so that the list, when the element is added, still is sorted. 
	 * @param The string which new positions in the sorted list needs to be found
	 * @return The index where the string should be placed/added to.
	 */
	private int getSortedInsertionIndex(String str)
	{
		//To make the adding process fast, a version of the Newton-raphson method is used, but for lists.
		//This will reduce the time it takes for sorting the adding of random elements from (*) to (*)
		//It works by looking at the element in the middle of the list, looking at the value of the compareTo method,
		//and depending on the sign of this value, it either adds or substracts half of the half length of the list, to/from the list,
		//until the place where the element needs to go is found.
		
		//The element simply needs to be added if the list size is 0
		if (theBag.size() == 0) {
			return 0;
		} else {
			//Initilizing needed variables.
			int minValue = 0;
			int maxValue = theBag.size();
			//Loops until the place is found
			while (true) {
				int halfDifferenceMinMax = (maxValue - minValue) / 2;
				//If the place between the min and max index is 0 indexes away from either (integer division),
				//the place where the string needs to be placed is found:
				if (halfDifferenceMinMax == 0) {
					//The element should be placed before or after the element at the max index,
					//depending on the compare value.
					if (theBag.get(minValue).compareTo(str) > 0) {
						return minValue;
					} else {
						return maxValue;
					}
				}
				//If the place is not found this "turn", it, depending on whether the element should be placed after the middle element,
				//or before it, shifts the search area to the later middle half of the current search area, or the lower middle half.
				final int middle = minValue + halfDifferenceMinMax;
				final int stringComparisonResult = theBag.get(middle).compareTo(str);
				if (stringComparisonResult == 0) {
					return middle;
				}else if (stringComparisonResult > 0) {//If placed exactly in the middle(*)
					maxValue -= halfDifferenceMinMax;
				} else {
					minValue += halfDifferenceMinMax;
				}
			}
		}
	}
}
