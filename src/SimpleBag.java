import java.util.ArrayList;
import java.util.Collections;


public class SimpleBag implements Bag{
	protected ArrayList<String> theBag = new ArrayList<String>();

	@Override
	public boolean addString(String str) {
		return theBag.add(str);
	}

	@Override
	public boolean removeAllOccurrences(String str) {
		return theBag.removeAll(Collections.singleton(str));
	}

	@Override
	public String getString(int index) {
		//Størrelsen skal være over index, da indexet til det største element er size - 1
		return (theBag.size() > index && index >= 0)? theBag.get(index): null;
	}

	@Override
	public int noOfElements() {
		return theBag.size(); //If there are no elements(*)Hvad med null? Og skulle der -1 til?
	}

}
