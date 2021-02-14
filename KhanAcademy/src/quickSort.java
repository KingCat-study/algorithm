/*
 * 칸아카데미 : 퀵 정렬 전체 구현
 * 작성 함수 
 * swap : 배열의 두 요소의 위치를 서로 변경
 * partition : 피벗값을 기준으로 low 그룹과 greater 그룹으로 나눔
 * quickSort : 재귀호출을 이용한 퀵정렬 구현 
 */
public class quickSort {
	
	public static void main(String[] args) {
		int[] array = {-9, 7, 5, -11, 12, 0, 14, 3, 10, 6};
		
		myQuickSort(array,0,array.length-1);
		
		for(int i : array) {
			System.out.print(i+" ");
		}
	}
	
	public static void swap(int[] array,int firstIndex, int secondIndex) {
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}
	
	/**
	 * 
	 * @param array
	 * @param p 배열의 시작 인덱스
	 * @param r 배열의 끝 인덱스
	 * @return 피벗의 인덱스
	 */
	public static int partition(int[] array,int p, int r) {
		//q,j,p 는 모두 같은 값으로 초기화 된다.
		int q = p;
		for(int j = p; j < r; j++) {
			//피벗값 array[r] 보다 array[j] 가 작거나 같으면  q와 j 의 위치를 변경 후 q를 오른쪽으로 한칸 이동
			//피벗값 array[r] 보다 array[j] 가 크면 j 를 증가시켜 greater 그룹을 한칸 늘려줌
			if(array[r] >= array[j]) {
				swap(array,q,j);
				q++;
			}
		}
		//j가 r에 도달하게 되면 greater 그룹의 시작점인 q와 r 의 위치를 서로 변경해 피벗값 기준으로 왼쪽은 low 오른쪽은 greater 로 나뉘게 됨
		swap(array,q,r);
		return q;
	}
	
	public static void myQuickSort(int[] array, int p, int r) {
		if(p < r) {
			int q = partition(array,p,r);//피벗값 
			myQuickSort(array, p,q-1);
			myQuickSort(array, q+1,r);
		}
	}
}
