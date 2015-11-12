


public class BagWithoutRepetitions extends SimpleBag{
	//Skal man tage højde for hvis den sættes lig med noget?(*)

	public boolean addString(String str) {
		return (theBag.contains(str))? super.addString(str): false;
	}
		
}
