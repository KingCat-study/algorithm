/*
 * ĭ��ī���� : �� ���� ��ü ����
 * �ۼ� �Լ� 
 * swap : �迭�� �� ����� ��ġ�� ���� ����
 * partition : �ǹ����� �������� low �׷�� greater �׷����� ����
 * quickSort : ���ȣ���� �̿��� ������ ���� 
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
	 * @param p �迭�� ���� �ε���
	 * @param r �迭�� �� �ε���
	 * @return �ǹ��� �ε���
	 */
	public static int partition(int[] array,int p, int r) {
		//q,j,p �� ��� ���� ������ �ʱ�ȭ �ȴ�.
		int q = p;
		for(int j = p; j < r; j++) {
			//�ǹ��� array[r] ���� array[j] �� �۰ų� ������  q�� j �� ��ġ�� ���� �� q�� ���������� ��ĭ �̵�
			//�ǹ��� array[r] ���� array[j] �� ũ�� j �� �������� greater �׷��� ��ĭ �÷���
			if(array[r] >= array[j]) {
				swap(array,q,j);
				q++;
			}
		}
		//j�� r�� �����ϰ� �Ǹ� greater �׷��� �������� q�� r �� ��ġ�� ���� ������ �ǹ��� �������� ������ low �������� greater �� ������ ��
		swap(array,q,r);
		return q;
	}
	
	public static void myQuickSort(int[] array, int p, int r) {
		if(p < r) {
			int q = partition(array,p,r);//�ǹ��� 
			myQuickSort(array, p,q-1);
			myQuickSort(array, q+1,r);
		}
	}
}
