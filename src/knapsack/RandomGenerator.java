package knapsack;

import java.util.ArrayList;
import java.util.Random;

public class RandomGenerator {
	int numberOfItems;
	int maxWeigth;
	ArrayList<Item> listOfItem;
	public RandomGenerator(int number, int maxWeigth ) {
		Random generator = new Random();
		this.numberOfItems = number;
		this.maxWeigth=maxWeigth;
		listOfItem = new ArrayList<Item>();
		for(int i=0;i<numberOfItems;i++){
			listOfItem.add(new Item(generator.nextInt(maxWeigth), generator.nextInt(maxWeigth)));
		}
	}
	public Item[] generateItemTable(){
		Item[] items = new Item[numberOfItems];
		listOfItem.toArray(items);
		return items;		
	}
	public ArrayList<Item> generateListOfItem(){
		return listOfItem;
	}
	public int[] generateTableOfValue(){
		return null;
	}
	public int[] generateTableOfWeigth(){
		return null;
	}
	public ArrayList<Integer> generateListOfValue(){
		return null;
	}
	public ArrayList<Integer> generateListOfWeigth(){
		return null;
	}
}
