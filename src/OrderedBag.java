import java.util.Collections;


public class OrderedBag extends SimpleBag{
	
	public boolean addString(String str) { //Laver en indsættelses manøvre(*)
		super.addString(str);
		Collections.sort(theBag);
		return true;
	}
}
