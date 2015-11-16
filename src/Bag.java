import java.util.ArrayList;

/**
 * @author pafi
 *
 */
public interface Bag {
	
	
	/** Add the string "str" to the strings in the bag as the last 
	 * element. It str was added then the method returns "true" and
	 * "false" otherwise.
	 * @param str
	 * @return true iff succesfully added
	 */
	public  boolean addString(String str);
	
	/** Removes all ocurrences of "str" from the bag.
	 * If "str" occurred at least once in the bag then the method
	 * returns "true" and "false" otherwise.
	 * @param str
	 * @return true iff str occured at least once
	 */
	public boolean removeAllOccurrences(String str);
	
	/** Returns the string which currently is at the position given
	 * by "index". In case the operation cannot be conducted, the 
	 * method returns "null".
	 * @param index
	 * @return string at index or null
	 */
	public  String getString(int index);
	
    /** returns the number of elements currently in the bag.
     *  Indexing starts with 0.
     * 
     * @return number of elements in the bag
     */
    public  int noOfElements();
}
