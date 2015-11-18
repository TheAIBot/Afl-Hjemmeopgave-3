import java.util.Collections;


public class OrderedBagWithoutRepetitions extends OrderedBag{
	
	public boolean addString(String str) {

		int indexBinarySearch = Collections.binarySearch(theBag, str);
		if(indexBinarySearch < 0){
			theBag.add(-1*(indexBinarySearch + 1),str);
			return true;
		} else return false;
		/*
		int[] strInsertioninformation = getSortedInsertionIndexAndIsContained(str);
		//Since the list will always be sorted, as the only way to change the list is to remove elements of an type,
		//or add them, whithout one being apple to specify an index, kepping the bag sorted can be done by adding in the string sent,
		//to the place in the list, so that the element before it in the list, if there is any, comes before it in the sorting, 
		//and so the same is true for the element following it, if there is any.
		
		if (strInsertioninformation[CONTAINS_INDEX] == DOES_NOT_CONTAIN_STRING) {
			theBag.add(strInsertioninformation[INSERTION_INDEX], str);
		}
		return false;
		*/
		
	}
}
