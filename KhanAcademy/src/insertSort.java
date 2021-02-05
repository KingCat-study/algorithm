import java.util.Arrays;

//칸아카데미 응용: 삽입 정렬 구현
public class insertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3, 5, 7, 11, 13, 2, 9, 6};
		int[] sortedArray = {2,3,5,6,7,9,11,13};
		myInsertSort(array);
		System.out.println(Arrays.equals(array, sortedArray));
		
		array = new int[] {45,5,-10,66,-2,1,5};
		sortedArray = new int[] {-10,-2,1,5,5,45,66};
		myInsertSort(array);
		System.out.println(Arrays.equals(array, sortedArray));
	}
	
	public static void myInsert(int[] array, int rightIndex, int value)
	{
		int i = 0;
		for(i = rightIndex; i >= 0 && array[i] > value; i--) {
			array[i + 1] = array[i];
		}
		array[i + 1] = value;
	}
	
	public static void myInsertSort(int[] array) {
		for(int i = 1; i < array.length; i++) {
			myInsert(array, i-1, array[i]);
		}
	}
}
