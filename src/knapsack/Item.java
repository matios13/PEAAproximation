package knapsack;

public class Item implements Comparable<Item> {
	public int value;
	public int weight;
	
	public Item(int value, int weight){
		this.value = value;
		this.weight = weight;
	}

	@Override
	public int compareTo(Item o) {
		if (value==o.value)
			return 0;
		if (value>o.value)
			return 1;
		return -1;
	}
}
