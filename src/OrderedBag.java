<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
=======
import java.util.Collections;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
>>>>>>> origin/master

/**
 * A bag wherein the elements always are placed in a sorted order.
 * 
 * @author jesper *
 */
<<<<<<< HEAD
public class OrderedBag extends OrderedBagWithoutRepetitions {
=======
public class OrderedBag extends SimpleBag{
>>>>>>> origin/master

	public boolean addString(String str) {
		int indexBinarySearch = Collections.binarySearch(theBag, str);
		if(indexBinarySearch <= 0) theBag.add(-1*(indexBinarySearch + 1),str);
		else theBag.add(indexBinarySearch,str);
		return true;				
	}
	/*
	public boolean removeAll(String str) {
		int indexBinarySearch = Collections.binarySearch(theBag, str);
		if(indexBinarySearch >= 0){
			int indexEndOfOccurences = indexBinarySearch;
			int indexBegginingOfOccurences = indexBinarySearch;
			while (theBag.get(indexBinarySearch).equals(str)) indexEndOfOccurences++;
			while(theBag.get(indexBinarySearch).equals(str)) indexBegginingOfOccurences++;
			List<String> newBag1 = theBag.subList(0, indexBegginingOfOccurences);
			theBag = newBag1.addAll(theBag.subList(indexEndOfOccurences, theBag.size() - 1));
			return true;
		} else return false;
	}
<<<<<<< HEAD

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
	
=======
	*/
>>>>>>> origin/master
}
