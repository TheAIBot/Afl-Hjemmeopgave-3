import java.util.ArrayList;
import java.util.List;

public class ForestDriver {

	public static void main(String[] args) {
		FasterOrderedBag fisk = new FasterOrderedBag();
		OrderedBag lol = new OrderedBag();
		List<Long> fisktimes = new ArrayList<Long>();
		List<Long> loltimes = new ArrayList<Long>();
		
		for (int i = 0; i < 20000; i++) {
			long startT = System.nanoTime();
			fisk.addString(String.valueOf(i));
			fisktimes.add(System.nanoTime() - startT);
		}
		
		for (int i = 0; i < 20000; i++) {
			long startT = System.nanoTime();
			lol.addString(String.valueOf(i));
			loltimes.add(System.nanoTime() - startT);
		}
		boolean fasterIsCorrect = true;
		for (int i = 0; i < fisk.noOfElements(); i++) {
			if (!fisk.getString(i).equals(lol.getString(i))) {
				fasterIsCorrect = false;
				break;
			}
		}
		System.out.println("is faster correct: " + String.valueOf(fasterIsCorrect));
		System.out.println("Faster: " + calculateAverage(fisktimes));
		System.out.println("Normal: " + calculateAverage(loltimes));
		
		
		
		
		//ForestSimulation fSim = new ForestSimulation(120,300);
		//fSim.run();
	}

	private static double calculateAverage(List<Long> marks) {
		Long sum = 0L;
		if (!marks.isEmpty()) {
			for (Long mark : marks) {
				sum += mark;
			}
			return sum.doubleValue() / marks.size();
		}
		return sum;
	}

}
