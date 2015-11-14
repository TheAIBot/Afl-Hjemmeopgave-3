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
				int halfDifferenceMinMax = (maxValue - minValue) / 2;
				if (halfDifferenceMinMax == 0) {
					if (theBag.get(minValue).compareTo(str) > 0) {
						return minValue;
					} else {
						return maxValue;
					}
				}
				int middle = minValue + halfDifferenceMinMax;
				if (theBag.get(middle).compareTo(str) > 0) {
					maxValue -= halfDifferenceMinMax;
				} else {
					minValue += halfDifferenceMinMax;
				}
			}
		}
	}
}
