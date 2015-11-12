
public class OrderedBagWithoutRepetitions extends OrderedBag{
	public boolean addString(String str) {
		return (theBag.contains(str))? false : super.addString(str);
	}
}
