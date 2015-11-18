import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * A bag wherein the elements always are placed in a sorted order.
 * 
 * @author jesper *
 */
public class OrderedBag extends OrderedBagWithoutRepetitions {

	public boolean addString(String str) {
		int[] strInsertioninformation = getSortedInsertionIndexAndIsContained(str);
		theBag.add(strInsertioninformation[INSERTION_INDEX], str);
		return true;
	}

	@Override
	public boolean removeAllOccurrences(String str) {
		// removeAll returns true if at least one lement is removed, or else
		// false.
		// An singleton is used, as only one element needs to be checkes for and
		// removed.
		int insertionIndex = Collections.binarySearch(theBag, str);
		if (insertionIndex >= 0) {
			int minSameValueIndex = insertionIndex;
			int maxSameValueIndex = insertionIndex;
			while (minSameValueIndex > 0 && theBag.get(minSameValueIndex - 1).equals(str)) {
				minSameValueIndex--;
			}
			minSameValueIndex = (minSameValueIndex > 0)? minSameValueIndex-- : minSameValueIndex;
			while (maxSameValueIndex < theBag.size() - 1 && theBag.get(maxSameValueIndex + 1).equals(str)) {
				maxSameValueIndex++;
			}
			maxSameValueIndex = (maxSameValueIndex < theBag.size() - 1)? ++maxSameValueIndex : maxSameValueIndex;
			List<String> newbag = new ArrayList<String>(theBag.size() - (maxSameValueIndex - minSameValueIndex));
			if (minSameValueIndex != 0) {
				newbag.addAll(theBag.subList(0, minSameValueIndex));
			}
			if (maxSameValueIndex != theBag.size() - 1) {
				newbag.addAll(theBag.subList(maxSameValueIndex, theBag.size() - 1));
			}
			return true;
		}
		else {
			return false;
		}
	}
	
}
