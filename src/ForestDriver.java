import java.util.ArrayList;
import java.util.List;

public class ForestDriver {

	public static void main(String[] args) {

		System.out.println("--Ordered Bags Test--");
		testTimeForBags(new OrderedBag(), new FasterOrderedBag());
		
		System.out.println("--Ordered Bags Without Repetition Test--");
		testTimeForBags(new OrderedBagWithoutRepetitions(), new FasterOrderedBagWithoutRepetition());
		
		
		
		//ForestSimulation fSim = new ForestSimulation(120,300);
		//fSim.run();
	}
	
	private static void testTimeForBags(Bag normal, Bag Faster)
	{
		List<Long> fasterTimes = new ArrayList<Long>();
		List<Long> normalTimes = new ArrayList<Long>();
		
		for (int i = 0; i < 20000; i++) {
			long startT = System.nanoTime();
			Faster.addString(String.valueOf(i));
			fasterTimes.add(System.nanoTime() - startT);
		}
		
		for (int i = 0; i < 20000; i++) {
			long startT = System.nanoTime();
			normal.addString(String.valueOf(i));
			normalTimes.add(System.nanoTime() - startT);
		}
		boolean fasterIsCorrect = true;
		for (int i = 0; i < Faster.noOfElements(); i++) {
			if (!Faster.getString(i).equals(normal.getString(i))) {
				fasterIsCorrect = false;
				break;
			}
		}
		System.out.println("is faster correct: " + String.valueOf(fasterIsCorrect));
		System.out.println("Faster: " + calculateAverage(fasterTimes));
		System.out.println("Normal: " + calculateAverage(normalTimes));
		System.out.println("");
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
