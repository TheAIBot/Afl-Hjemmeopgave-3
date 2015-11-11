
public class OrderedBagWithoutRepetitions extends OrderedBag{
	public boolean addString(String str) {
		if (theBag.contains(str))
			return false;
		else { 
			return super.addString(str);
		}		
	}
}
