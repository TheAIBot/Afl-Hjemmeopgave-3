import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ForestDriver {

	public static void main(String[] args) {
		
		//System.out.println("ss".compareTo(null));
		
		OrderedBag oBag = new OrderedBag();
		Random fdisk = new Random(12);
		for (int i = 0; i < 5; i++) {
			oBag.addString(null);
			for (int j = 0; j < 3; j++) {
				oBag.addString(String.valueOf(fdisk.nextInt(4)));
			}
		}
		System.out.println(oBag.theBag);
		oBag.removeAllOccurrences("2");
		System.out.println(oBag.theBag);
		
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
		/*
		SimpleBag normalOrderedBag = new OrderedBag();
		System.out.println("--Ordered Bags Test--");
		testTimeForBags(normalOrderedBag, normalOrderedBag, 20000);
		testTimeForBags(normalOrderedBag, normalOrderedBag, 20000);
		*/
		/*
		
		SimpleBag normalOrderedBagWithoutRepetition = new OrderedBagWithoutRepetitions();
		System.out.println("--Ordered Bags Without Repetition Test--");
		testTimeForBags(normalOrderedBagWithoutRepetition, normalOrderedBagWithoutRepetition, 20000);
		testTimeForBags(normalOrderedBagWithoutRepetition, normalOrderedBagWithoutRepetition, 20000);
		
		SimpleBag bagWithoutRepetition = new BagWithoutRepetitions();
		System.out.println("--Bag Without Repetition Test--");
		testTimeForBags(bagWithoutRepetition, bagWithoutRepetition, 20000);
		testTimeForBags(bagWithoutRepetition, bagWithoutRepetition, 20000);
		*/
		
		ForestSimulation fSim = new ForestSimulation(120,300);
		fSim.run();
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
