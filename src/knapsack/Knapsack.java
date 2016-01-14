package knapsack;

import java.util.Arrays;
import static knapsack.Main.*;

public class Knapsack {

	
	int capacity;
	Item[] items;
	
	public int calculateWithSort(float epsilon){
		Arrays.parallelSort(items);
		return mainCalculate(calculateDeviderForSorted(epsilon));
	}
	public int calculate(float epsilon) {
		
		return mainCalculate(calculateDevider(epsilon));
		
	}
	
public int mainCalculate(int eDivider) {
		
		int aproxValuesSum = 0;
		int aroxTableValue[] = new int[N];
		int tempValue = 0;
		for (int i = 0; i < N; i++) {
			tempValue = items[i].value / eDivider;
			aroxTableValue[i] = tempValue;
			aproxValuesSum +=tempValue;
		}
		int previousValuesTable[] = new int[aproxValuesSum + 1];
		int currentValuesTable[] = new int[aproxValuesSum + 1];
		previousValuesTable[0] = 0;
		

		for (int x = 1; x <= aproxValuesSum; x++)
			previousValuesTable[x] = MAX_VALUE+1;

		for (int i = 0; i < N; i++) { //sprawdzamy kazdy przedmiot
			
			for (int x = 0; x <= aproxValuesSum; x++) {
				
				currentValuesTable[x] = previousValuesTable[x];
				int value = calculateValue(aroxTableValue[i], items[i].weight, x, previousValuesTable);
				if (value < currentValuesTable[x])
					currentValuesTable[x] = value;
			}

			previousValuesTable = currentValuesTable;
			currentValuesTable = new int[aproxValuesSum + 1];
		}
		for(int i = 0;i<aproxValuesSum;i++){
			if(previousValuesTable[i] > capacity)
				return eDivider * (i - 1);				
		}
		return aproxValuesSum;		
	}


	
	public int calculateDevider(float epsilon){		
		int valueMax=-1;
		for (int i = 0; i < N; i++) {
			if ( items[i].value> valueMax)
				valueMax = items[i].value;
		}
		int eDivider=0;
			eDivider = (int) ((epsilon * valueMax) / N);
		if (eDivider == 0)
			eDivider = 1;
		return eDivider;
	}
public int calculateDeviderForSorted(float epsilon){		
		int valueMax=items[items.length-1].value;
		int eDivider=0;
			eDivider = (int) ((epsilon * valueMax) / N);
		if (eDivider == 0)
			eDivider = 1;
		return eDivider;
	}
	public int calculateValue(int aValue, int weight, int iteration, int previousValuesTable[]){
		int value;

		if (aValue >= iteration)
			value = weight;
		
		else {
			int previousValue = previousValuesTable[iteration - aValue];
			if (previousValue == MAX_VALUE + 1)
				value = MAX_VALUE+1;		
			else
				value = weight+previousValue;
		}
		return value;
	}
}
