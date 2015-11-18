import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * A bag wherein the elements always are placed in a sorted order.
 * 
 * @author jesper *
 */
public class OrderedBag extends SimpleBag {

	public boolean addString(String str) {
		int indexBinarySearch = betterBinarySearch(str);
		if(indexBinarySearch < 0) {
			int fisk = -1*(indexBinarySearch + 1);
			theBag.add(fisk,str);
		}
		else theBag.add(indexBinarySearch,str);
		return true;				
	}

	protected int betterBinarySearch(String str) {
		return Collections.binarySearch(theBag, str, (x, t) -> {
			if (t == null && x == null) {
				return 0;
			}
			else if (t == null) {
				return 1;
			} else if (x == null) {
				return -1;
			}
			return x.compareTo(t);
		});
	}

	@Override
	public boolean removeAllOccurrences(String str) {
		// removeAll returns true if at least one lement is removed, or else
		// false.
		// An singleton is used, as only one element needs to be checkes for and
		// removed.
		int insertionIndex = betterBinarySearch(str);
		if (insertionIndex >= 0) {
			int minSameValueIndex = insertionIndex;
			int maxSameValueIndex = insertionIndex;
			while (minSameValueIndex > 0 && theBag.get(minSameValueIndex).equals(str)) {
				minSameValueIndex--;
			}
			while (maxSameValueIndex < theBag.size() - 1 && theBag.get(maxSameValueIndex).equals(str)) {
				maxSameValueIndex++;
			}
			List<String> newbag = new ArrayList<String>(theBag.size() - (maxSameValueIndex - minSameValueIndex));
			newbag.addAll(theBag.subList(0, minSameValueIndex));
			newbag.addAll(theBag.subList(maxSameValueIndex, theBag.size() - 1));
			
			theBag = newbag;
			return true;
		} else {
			return false;
		}
	}
}
