import java.util.Collections;

public class SlowOrderedBag extends SimpleBag {
	public boolean addString(String string){
		theBag.add(string);
		Collections.sort(theBag);
		return true;
	}
}
