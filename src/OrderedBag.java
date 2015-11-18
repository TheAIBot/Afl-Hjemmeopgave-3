import java.util.Collections;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * A bag wherein the elements always are placed in a sorted order.
 * @author jesper *
 */
public class OrderedBag extends SimpleBag{

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
	*/
}
