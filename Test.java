import java.util.Arrays;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		int[] data = createRandomSortedArray(10000, false);
		int[] data2 = Arrays.copyOf(data, data.length);
		int[] data3 = Arrays.copyOf(data, data.length);
		int[] data4 = Arrays.copyOf(data, data.length);
		
		
		long before = System.currentTimeMillis();
		bubbleSort(data2);
		long after = System.currentTimeMillis();
		System.out.println("Bubble time: " + (after-before));
		
		
		before = System.currentTimeMillis();
		insertionSort(data3);
		after = System.currentTimeMillis();
		System.out.println("Insertion time: " + (after-before));
		
		before = System.currentTimeMillis();
		selectionSort(data4);
		after = System.currentTimeMillis();
		System.out.println("Selection time: " + (after-before));

	}
	
	private static int[] createRandomArray(int size) {
		Random rnd = new Random();
		int[] result = new int[size];
		for (int i=0;i<size;i++) {
			result[i] = rnd.nextInt(1000)+1;
		}
		return result;
		
	}
	
	private static int[] createRandomArrayWithFewUniques(int size) {
		Random rnd = new Random();
		int[] result = new int[size];
		for (int i=0;i<size;i++) {
			result[i] = rnd.nextInt(10)+1;
		}
		return result;
		
	}
	
	private static int[] createRandomSortedArray(int size, boolean up) {
		Random rnd = new Random();
		int[] result = new int[size];
		result[0] = rnd.nextInt(1000)+1;
		for (int i=1;i<size;i++) {
			if (up)
				result[i] = result[i-1] + rnd.nextInt(1000)+1;
			else
				result[i] = result[i-1] - rnd.nextInt(1000)+1;
		}
		return result;
		
	}

	private static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}



	private static void selectionSort(int[] arr) {
		int iMin, temp;
		for(int i = 0; i < arr.length - 1; i++)
		{
			iMin=i;

			for(int j = i + 1; j < arr.length; j++)
				if(arr[j] < arr[iMin])
					iMin = j;

			temp = arr[iMin];
			arr[iMin] = arr[i];
			arr[i] = temp;
		} 
	}

	private static void bubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					// swap arr[j+1] and arr[j]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

}
