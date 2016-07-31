package duaratus;

import java.util.Random;

public class SortAlgorithm {
	public static void insertionSort(int[] data) {
		for (int i = 1; i < data.length; i++) {
		int key = data[i];
		int j = i-1;
		while (j >= 0 && key < data[j]) {
			data[j + 1] = data[j];
			j--;
		}
		data[j + 1] = key;
		}
		for (int item : data)
		{
			System.out.print(item + " ");
		}
	}
	public static void main(String[] args) {
		Random generate = new Random();
		int[] data;
		data = new int[10];
		for (int i =0; i<data.length; i++)
		{
			data[i]=generate.nextInt()%100;
			System.out.print(data[i] + " ");
		}
		System.out.println("\nsorted : ");
		insertionSort(data);
	}
}
