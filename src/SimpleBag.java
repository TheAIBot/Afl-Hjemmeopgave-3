import java.awt.List;
import java.util.ArrayList;


public class SimpleBag implements Bag{
	ArrayList<String> theBag = new ArrayList<String>(){};

	@Override
	public boolean addString(String str) {
		return theBag.add(str);
	}

	@Override
	public boolean removeAllOccurrences(String str) {
		ArrayList<String> token = new ArrayList<String>(1);
		token.add(str);
		return theBag.removeAll(token);
	}

	@Override
	public String getString(int index) {
		//Størrelsen skal være over index, da indexet til det største element er size - 1
		if (theBag.size() > index && index >= 0) { 
			return theBag.get(index);
		}else return null;
	}

	@Override
	public int noOfElements() {
		return theBag.size(); //If there are no elements(*)Hvad med null? Og skulle der -1 til?
	}

}
