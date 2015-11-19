import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ForestDriver {

	public static void main(String[] args) {
		//Tests.testBagInsertionSpeed();
		Tests.testBagRemoveAllOccurencesSpeed();
		
		/*
		Random r = new Random();
		OrderedBagWithoutRepetitions testBag = new OrderedBagWithoutRepetitions();
		List<String> sortedBag = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			String addRandomString = String.valueOf(r.nextInt(4));
			if(!sortedBag.contains(addRandomString)) sortedBag.add(addRandomString);
			testBag.addString(addRandomString);
		}
		Collections.sort(sortedBag);
		System.out.println(sortedBag.equals(testBag.theBag));
		for (int i = 0; i < sortedBag.size(); i++) {
			System.out.println(testBag.getString(i));
			System.out.println(sortedBag.get(i));
			System.out.println();
		}
		
		
		ForestSimulation fSim = new ForestSimulation(120,300);
		fSim.run();
		*/
	}
	


}
