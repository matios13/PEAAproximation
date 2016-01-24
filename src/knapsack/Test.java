package knapsack;

import java.util.ArrayList;
import static knapsack.Main.calculatePercent;
import static knapsack.Main.CAPACITY;

public class Test {

	public static void testEpsilon(Item[] items){
		Knapsack knapsack;
		
		System.out.println("start");
		ArrayList<Long> times = new ArrayList<Long>();
		ArrayList<Integer> solutions = new ArrayList<Integer>();
		ArrayList<Long> timesWithSort = new ArrayList<Long>();
		ArrayList<Integer> solutionsWithSort = new ArrayList<Integer>();
		int i =0;
		for(float epsilon = 0f ; epsilon<1;epsilon+=0.05f){
			knapsack = new Knapsack();
			knapsack.capacity=CAPACITY;
			knapsack.items = copyItems(items);
			Long time = System.nanoTime();
			int solution = knapsack.calculate(epsilon);
			time = System.nanoTime() - time;
			times.add(time);
			solutions.add(solution);
			System.out.println(epsilon+"------------------------------------------");
			System.out.println("value : "+solutions.get(i)+" time : " +times.get(i));
			System.out.println("value -0 : "+ calculatePercent(solutions.get(0),solutions.get(i))+" time : " +calculatePercent(times.get(0),times.get(i)));
			System.out.println("------------------------------------------");
			time = System.nanoTime();
			solution = knapsack.calculateWithSort(epsilon);
			time = System.nanoTime() - time;
			timesWithSort.add(time);
			solutionsWithSort.add(solution);
			System.out.println(epsilon+"########################################");
			System.out.println(" time : " +timesWithSort.get(i));
			System.out.println("value : "+calculatePercent(solutions.get(i),solutionsWithSort.get(i))+" time : " +calculatePercent(times.get(i),timesWithSort.get(i)));
			System.out.println("value -0 : "+calculatePercent(solutionsWithSort.get(0),solutionsWithSort.get(i))+" time : " +calculatePercent(timesWithSort.get(0),timesWithSort.get(i)));
			System.out.println("########################################");		
			i++;
		}
		
		
	}
	private static Item[] copyItems(Item[] items){
		Item[] newItems = new Item[items.length];
		for(int i=0;i<items.length;i++){
			newItems[i]=items[i];
		}
		return newItems;
	}
}
