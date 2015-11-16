public class FasterOrderedBag extends SimpleBag {
	public boolean addString(String str) {
		theBag.add(getSortedInsertionIndex(str), str);
		return true;
	}
	
	private int getSortedInsertionIndex(String str)
	{
		if (theBag.size() == 0) {
			return 0;
		} else {
			int minValue = 0;
			int maxValue = theBag.size();
			while (true) {
				final int halfDifferenceMinMax = (maxValue - minValue) / 2;
				if (halfDifferenceMinMax == 0) {
					final int stringComparisonResult = theBag.get(minValue).compareTo(str);
					if (theBag.get(minValue).compareTo(str) > 0) {
						return minValue;
					} else {
						return maxValue;
					}
				}
				final int middle = minValue + halfDifferenceMinMax;
				final int stringComparisonResult = theBag.get(middle).compareTo(str);
				if (stringComparisonResult == 0) {
					return middle;
				}
				else if (stringComparisonResult > 0) {
					maxValue -= halfDifferenceMinMax;
				} else {
					minValue += halfDifferenceMinMax;
				}
			}
		}
	}
}
