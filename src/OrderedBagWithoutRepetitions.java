import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class OrderedBagWithoutRepetitions extends SimpleBag{
	protected static final int CONTAINS_STRING = 0;
	protected static final int DOES_NOT_CONTAIN_STRING = 1;
	protected static final int INSERTION_INDEX = 0;
	protected static final int CONTAINS_INDEX = 1;
	
	public boolean addString(String str) {
		int[] strInsertioninformation = getSortedInsertionIndexAndIsContained(str);
		//Since the list will always be sorted, as the only way to change the list is to remove elements of an type,
		//or add them, whithout one being apple to specify an index, kepping the bag sorted can be done by adding in the string sent,
		//to the place in the list, so that the element before it in the list, if there is any, comes before it in the sorting, 
		//and so the same is true for the element following it, if there is any.
		if (strInsertioninformation[CONTAINS_INDEX] == DOES_NOT_CONTAIN_STRING) {
			theBag.add(strInsertioninformation[INSERTION_INDEX], str);
		}
		return false;
	}
	/** Returns an index for where a string needs to be placed and a value if the list already contains the value, 
	 * @param The string which new positions in the sorted list needs to be found
	 * @return The insertion index and contains information.
	 */
	protected int[] getSortedInsertionIndexAndIsContained(String str)
	{
		//To make the adding process fast, a version of the Newton-raphson method is used, but for lists.
		//This will reduce the time it takes for sorting the adding of random elements from (*) to (*)
		//It works by looking at the element in the middle of the list, looking at the value of the compareTo method,
		//and depending on the sign of this value, it either adds or substracts half of the half length of the list, to/from the list,
		//until the place where the element needs to go is found.
		
		//The list can't contain the value of there is nothing in the list
		//and if there is nothing in the list then add to the frirst index
		if (theBag.size() == 0) {
			return new int[] {0, DOES_NOT_CONTAIN_STRING};
		} else {
			//These two variables marks the area that is being checked
			int minValue = 0;
			int maxValue = theBag.size();
			//Loop runs forever, because it will return eventually thus making sure
			//that it can't get stuck
			while (true) {
				//finds half the distance between the searched area.
				//If this value is 0, then that means that the area that is being searched
				//is only 1 value wide o when this happens then only one more chekc has to be made
				//to find the insertion index.
				final int halfDifferenceMinMax = (maxValue - minValue) / 2;
				if (halfDifferenceMinMax == 0) {
					final int stringComparisonResult = theBag.get(minValue).compareTo(str);
					//if the value being checked is the same as the one that should be inserted, then
					//then it doesn't matter if minValue of maxValue is being returned as
					//the insertion index because it would result in the same list either way.
					//This also means that the list conatins the value already
					if (stringComparisonResult == 0) {
						return new int[] {maxValue, CONTAINS_STRING};
					}
					//If the new value is uniqe then chekc wether it should be added tto the left or right side
					// of the last value that is checked and return that
					else if (stringComparisonResult > 0) {
						return new int[] {minValue, DOES_NOT_CONTAIN_STRING};
					} else {
						return new int[] {maxValue, DOES_NOT_CONTAIN_STRING};
					}
				}
				final int middle = minValue + halfDifferenceMinMax;
				//get the index of the middle value and omtaire it to the new value.
				final int stringComparisonResult = theBag.get(middle).compareTo(str);
				//if they are the same then the list already contains the string at the middle index
				if (stringComparisonResult == 0) {
					return new int[] {middle, CONTAINS_STRING};
				}
				//else make the searched area half the size and run the loop again
				else if (stringComparisonResult > 0) {
					maxValue -= halfDifferenceMinMax;
				} else {
					minValue += halfDifferenceMinMax;
				}
			}
		}
	}
}
