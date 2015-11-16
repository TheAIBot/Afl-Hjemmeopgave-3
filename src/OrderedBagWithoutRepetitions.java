
public class OrderedBagWithoutRepetitions extends OrderedBag{
	private static final int CONTAINS_STRING = 0;
	private static final int DOES_NOT_CONTAIN_STRING = 1;
	
	public boolean addString(String str) {
		int[] strInsertioninformation = getSortedInsertionIndexAndIsContained(str);
		if (strInsertioninformation[1] == DOES_NOT_CONTAIN_STRING) {
			theBag.add(strInsertioninformation[0], str);
		}
		return false;
	}

	private int[] getSortedInsertionIndexAndIsContained(String str)
	{
		if (theBag.size() == 0) {
			return new int[] {0, DOES_NOT_CONTAIN_STRING};
		} else {
			int minValue = 0;
			int maxValue = theBag.size();
			while (true) {
				final int halfDifferenceMinMax = (maxValue - minValue) / 2;
				if (halfDifferenceMinMax == 0) {
					final int stringComparisonResult = theBag.get(minValue).compareTo(str);
					if (stringComparisonResult == 0) {
						return new int[] {maxValue, CONTAINS_STRING};
					}
					else if (stringComparisonResult > 0) {
						return new int[] {minValue, DOES_NOT_CONTAIN_STRING};
					} else {
						return new int[] {maxValue, DOES_NOT_CONTAIN_STRING};
					}
				}
				final int middle = minValue + halfDifferenceMinMax;
				final int stringComparisonResult = theBag.get(middle).compareTo(str);
				if (stringComparisonResult == 0) {
					return new int[] {middle, CONTAINS_STRING};
				}
				else if (theBag.get(middle).compareTo(str) > 0) {
					maxValue -= halfDifferenceMinMax;
				} else {
					minValue += halfDifferenceMinMax;
				}
			}
		}
	}
}
