public class FasterOrderedBag extends SimpleBag {
	public boolean addString(String str) { //Laver en indsættelses manøvre(*)
		if (theBag.size() == 0) {
			theBag.add(str);
			return true;
		} else {
			int minValue = 0;
			int maxValue = theBag.size();
			while (true) {
				int middle = minValue + (maxValue - minValue) / 2;
				if (middle == 0 || minValue == maxValue || middle >= theBag.size()) {
					/*if (theBag.get(minValue).compareTo(str) > 0) {
						theBag.add(minValue, str);
					} else {
						theBag.add(minValue + 1, str);
					}*/
					theBag.add(minValue, str);
					return true;
				}
				if (theBag.get(middle).compareTo(str) > 0) {
					maxValue -= middle;
				} else {
					minValue += middle;
				}
			}
			/*
			for (int i = 0; i< theBag.size(); i++) {
				if (theBag.get(i).compareTo(str) > 0) {
					theBag.add(i, str);
					return true;
				}
			}
			*/
		}
		//theBag.add(str);
		//return true;
	}
}
