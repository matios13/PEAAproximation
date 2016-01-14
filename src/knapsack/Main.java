package knapsack;

import java.io.IOException;

public class Main {
	// -----------------------STA£E
	static int MAX_VALUE = 2000;
	static float EPSILON = 0.6f;
	static int CAPACITY= 9000;
	static int N = 100;
	static boolean test = true;

	public static void main(String args[]) throws IOException {
		

		RandomGenerator generatoe = new RandomGenerator(N, MAX_VALUE);

		Item[] items = generatoe.generateItemTable();
		if (test) {
			Test.testEpsilon(items);
		} else {
			Knapsack knapsack = new Knapsack();
			knapsack.capacity = CAPACITY;
			knapsack.items=items;
			Long time = System.nanoTime();
			int solution = knapsack.calculateWithSort(EPSILON);
			time = System.nanoTime() - time;
			System.out.println("Solution : "+solution+" time : " + time);
		}

	}

	public static double calculatePercent(long base, long value) {
		return ((value * 100.0) / base);
	}
}
