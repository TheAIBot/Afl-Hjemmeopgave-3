
public class SlowOrderedBagWithoutRepetition extends SlowOrderedBag {
	public boolean addString(String str)
	{
		if (!theBag.contains(str)) {
			return super.addString(str);
		}
		return false;
	}
}
