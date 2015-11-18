import java.util.ArrayList;
import java.util.List;

public class ForestDriver {

	public static void main(String[] args) {
		
		OrderedBag oBag = new OrderedBag();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				oBag.addString(String.valueOf(i));
			}
		}
		int fisk = 0;
		fisk = 1;
		oBag.removeAllOccurrences("2");
		fisk = 2;
		System.out.println(fisk);
		/*
		SimpleBag normalOrderedBag = new OrderedBag();
		System.out.println("--Ordered Bags Test--");
		testTimeForBags(normalOrderedBag, normalOrderedBag, 20000);
		testTimeForBags(normalOrderedBag, normalOrderedBag, 20000);
		
		
		SimpleBag normalOrderedBagWithoutRepetition = new OrderedBagWithoutRepetitions();
		System.out.println("--Ordered Bags Without Repetition Test--");
		testTimeForBags(normalOrderedBagWithoutRepetition, normalOrderedBagWithoutRepetition, 20000);
		testTimeForBags(normalOrderedBagWithoutRepetition, normalOrderedBagWithoutRepetition, 20000);
		
		SimpleBag bagWithoutRepetition = new BagWithoutRepetitions();
		System.out.println("--Bag Without Repetition Test--");
		testTimeForBags(bagWithoutRepetition, bagWithoutRepetition, 20000);
		testTimeForBags(bagWithoutRepetition, bagWithoutRepetition, 20000);
		*/
		
		
		//ForestSimulation fSim = new ForestSimulation(120,300);
		//fSim.run();
	}
	
	private static void testTimeForBags(Bag normal, Bag Faster, int times)
	{
		List<Long> fasterTimes = new ArrayList<Long>(2 * times);
		List<Long> normalTimes = new ArrayList<Long>(2 * times);
		
		for (int i = 0; i < times; i++) {
			long startT = System.nanoTime();
			Faster.addString(String.valueOf(i));
			fasterTimes.add(System.nanoTime() - startT);
		}
		
		for (int i = 0; i < times; i++) {
			long startT = System.nanoTime();
			normal.addString(String.valueOf(i));
			normalTimes.add(System.nanoTime() - startT);
		}
		boolean fasterIsCorrect = true;
		if (normal.noOfElements() == Faster.noOfElements()) {
			for (int i = 0; i < Faster.noOfElements(); i++) {
				if (!Faster.getString(i).equals(normal.getString(i))) {
					fasterIsCorrect = false;
					break;
				}
			}
		}
		else {
			fasterIsCorrect = false;
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
