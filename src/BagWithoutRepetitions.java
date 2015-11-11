


public class BagWithoutRepetitions extends SimpleBag{
	//Skal man tage højde for hvis den sættes lig med noget?(*)

	public boolean addString(String str) {
		if (theBag.contains(str))
			return false;
		else { 
			return super.addString(str);
		}		
	}
		
}
