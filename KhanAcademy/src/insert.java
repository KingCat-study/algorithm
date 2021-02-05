import java.util.Arrays;

//Ä­¾ÆÄ«µ¥¹Ì ÀÀ¿ë: »ğÀÔ ±¸Çö
public class insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3, 5, 7, 11, 13, 2, 9, 6};
		
		myInsert(array,4,2);
		int[] sortedArray = {2, 3, 5, 7, 11, 13, 9, 6};
		System.out.println(Arrays.equals(array, sortedArray));
		
		sortedArray = new int[]{2, 3, 5, 7, 9, 11, 13, 6};
		myInsert(array,5,9);
		System.out.println(Arrays.equals(array, sortedArray));
		
		sortedArray = new int[]{2, 3, 5, 6, 7, 9, 11, 13};
		myInsert(array,6,6);
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
}
