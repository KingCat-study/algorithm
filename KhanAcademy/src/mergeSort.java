
public class mergeSort {
	
	public static void main(String[] args) {
		int[] array = {3, 7, 12, 14, 2, 6, 9, -11};
		myMergeSort(array,0,array.length-1);
		
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d ", array[i]);
		}
	}
	
	public static void myMergeSort(int[] array,int start,int end) {
		if(start < end) {
			int middle = (start + end) / 2;
			myMergeSort(array, start , middle);
			myMergeSort(array, middle+1,end);
			merge(array,start,middle,end);
		}
	}
	
	
	public static void merge(int[] array, int start,int middle,int end) {
		int i = start;
		int j = middle + 1;
		int k = i;
		
		int[] sortedArray = new int[end+1];
		
		while(i <= middle && j <= end) {
			if(array[i] < array[j]) {
				sortedArray[k++] = array[i++];
			} else {
				sortedArray[k++] = array[j++];
			}
		}

		if(i > middle) {
			for(int t = j; t <= end; t++) {
				sortedArray[k++] =  array[t];
			}
		} else {
			for(int t = i; t <= middle; t++) {
				sortedArray[k++] =  array[t];
			}
		}
		
		for(int t = start; t <= end; t++) {
			array[t] = sortedArray[t];
		}
	}
}
