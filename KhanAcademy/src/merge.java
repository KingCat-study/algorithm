/**
 * 칸아카데미 응용 : 병합 구현
 * @author ljh
 *
 */
public class merge {

	public static void main(String[] args) {
		int[] array = {3, 7, 12, 14, -11, 2, 6, 9};
		
		myMerge(array,0,(int)Math.floor((0+array.length-1) /2),array.length-1);
		
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d ", array[i]);
		}
	}
	
	
	public static void myMerge(int[] array, int p,int q,int r) {
		int[] lowHalf = new int[q+1];
		int[] highHalf = new int[r-q];
		
		int k = p;
		int i = 0,j = 0;
		
		for(i = 0; k <= q; i++,k++) {
			lowHalf[i] = array[k];
		}
		
		for(j = 0; k <= r; j++,k++) {
			highHalf[j] = array[k];
		}
		
		k = p;
		i = 0;
		j = 0;
		
		
		while(i < q+1 && j < r-q) {
			if(lowHalf[i] < highHalf[j]) {
				array[k++] = lowHalf[i++];
			} else {
				array[k++] = highHalf[j++];
			}
		}
		
		while(i < lowHalf.length) {
			array[k++] = lowHalf[i++];
		}
		
		while(j < highHalf.length) {
			array[k++] = highHalf[j++];
		}
		
	}
}
