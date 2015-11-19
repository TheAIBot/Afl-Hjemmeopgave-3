import java.util.ArrayList;
import java.util.List;

public class Tests {
	
	public static void testBagRemoveAllOccurencesSpeed()
	{
		System.out.println("------RemoveAllOccurences Test------");
System.out.println("");
		
		SimpleBag normalOrderedBag = new OrderedBag();
		System.out.println("--Ordered Bags Test--");
		testBagRemoveAllSpeed(normalOrderedBag, normalOrderedBag, 100);
		System.out.println("");
		
		SimpleBag normalOrderedBagWithoutRepetition = new OrderedBagWithoutRepetitions();
		System.out.println("--Ordered Bags Without Repetition Test--");
		testBagRemoveAllSpeed(normalOrderedBagWithoutRepetition, normalOrderedBagWithoutRepetition, 100);
		System.out.println("");
		
		SimpleBag bagWithoutRepetition = new BagWithoutRepetitions();
		System.out.println("--Bag Without Repetition Test--");
		testBagRemoveAllSpeed(bagWithoutRepetition, bagWithoutRepetition, 100);
		System.out.println("");
	}
	
	private static void testBagRemoveAllSpeed(Bag normal, Bag faster, int times)
	{
		List<Long> fasterTimes = new ArrayList<Long>(2 * times);
		List<Long> normalTimes = new ArrayList<Long>(2 * times);
		List<String> toDelete = new ArrayList<String>(times); 
		
		for (int i = 1; i < times; i++) {
			toDelete.add(String.valueOf(i));
			for (int j = 0; j < i; j++) {
				normal.addString(String.valueOf(i));
			}
		}
		while (toDelete.size() > 0) {
			long startTime = System.nanoTime();
			faster.removeAllOccurrences(toDelete.get(toDelete.size() / 2));
			fasterTimes.add(System.nanoTime() - startTime);
			
			startTime = System.nanoTime();
			normal.removeAllOccurrences(toDelete.get(toDelete.size() / 2));
			normalTimes.add(System.nanoTime() - startTime);
			
			if (!bagSame(normal, faster)) {
				System.out.println("remove test failed. Bags don't remove the same things");
				return;
			}
			toDelete.remove(toDelete.size() / 2);
		}
		System.out.println("Faster: " + getAverageTime(fasterTimes));
		System.out.println("Normal: " + getAverageTime(normalTimes));
		
	}
	
	public static void testBagInsertionSpeed()
	{
		System.out.println("------Insertion Speed Test------");
		System.out.println("");
		
		SimpleBag normalOrderedBag = new OrderedBag();
		SimpleBag slowOrderedBag = new SlowOrderedBag();
		System.out.println("--Ordered Bags Test--");
		testBagSpeed(slowOrderedBag, normalOrderedBag, 20000);
		System.out.println("");
		
		SimpleBag normalOrderedBagWithoutRepetition = new OrderedBagWithoutRepetitions();
		SimpleBag slowOrderedBagWithoutRepetition = new SlowOrderedBagWithoutRepetition();
		System.out.println("--Ordered Bags Without Repetition Test--");
		testBagSpeed(slowOrderedBagWithoutRepetition, normalOrderedBagWithoutRepetition, 20000);
		System.out.println("");
		
		SimpleBag bagWithoutRepetition = new BagWithoutRepetitions();
		System.out.println("--Bag Without Repetition Test--");
		testBagSpeed(bagWithoutRepetition, bagWithoutRepetition, 20000);
		System.out.println("");
	}
	
	private static void testBagSpeed(Bag normal, Bag faster, int times)
	{
		testTimeForBags(normal, faster, times);
		testTimeForBags(normal, faster, times);
		System.out.println("is faster correct: " + bagSame(normal, faster));
	}
	
	private static void testTimeForBags(Bag normal, Bag faster, int times)
	{
		List<Long> fasterTimes = new ArrayList<Long>(2 * times);
		List<Long> normalTimes = new ArrayList<Long>(2 * times);
		
		for (int i = 0; i < times; i++) {
			long startT = System.nanoTime();
			faster.addString(String.valueOf(i));
			fasterTimes.add(System.nanoTime() - startT);
		}
		
		for (int i = 0; i < times; i++) {
			long startT = System.nanoTime();
			normal.addString(String.valueOf(i));
			normalTimes.add(System.nanoTime() - startT);
		}
		
		System.out.println("Faster: " + getAverageTime(fasterTimes));
		System.out.println("Normal: " + getAverageTime(normalTimes));
	}
	
	private static boolean bagSame(Bag first, Bag second)
	{
		
		if (first.noOfElements() == second.noOfElements()) {
			for (int i = 0; i < second.noOfElements(); i++) {
				if (!second.getString(i).equals(first.getString(i))) {
					return false;
				}
			}
		}
		else {
			return false;
		}
		return true;
	}

	private static double getAverageTime(List<Long> times) {
		long sum = 0;
		for (int i = 0; i < times.size(); i++) {
			sum += times.get(i);
		}
		return sum / times.size();
	}
}
