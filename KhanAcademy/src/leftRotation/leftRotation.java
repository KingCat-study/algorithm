package leftRotation;

import java.util.ArrayList;
import java.util.List;
/**
 * ��Ŀ��ũ Left Rotation
 * �Է¹��� ���� d �� �迭�� ������(size-1) ���� ������ �� �� ���� �迭�� ��Ҹ� �־��� ������ ��Ųä �������� �ű��.
 * 
 * @author ljh
 *
 */
public class leftRotation {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		
		int n = 5; //arr size 
		int d = 4; //ã�� ����.
		int j = 0; //�ε���
		int divideIndex = d;
		
		//�ʱ�ȭ
		for (int i = 0; i < n; i++) {
			arr.add(i+1);
			temp.add(0);
		}
		
		//�Է� ���� d �� �������� �����ʿ� �ִ� ��Ҹ� ���� ������ �迭�� �ε��� 0 ���� ä���.
		while(divideIndex < n) {
			temp.set(j, arr.get(divideIndex));
			j++;
			divideIndex++;
		}
		
		//�Է� ���� d �� �������� d�� ������ ���ʿ� �ִ� ��Ҹ� ���� ������ �迭�� �������� ���ʷ� ä���.
		divideIndex = 0;
		while(divideIndex < d) {
			temp.set(j, arr.get(divideIndex));
			j++;
			divideIndex++;
		}
		
		for(int k : temp) {
			System.out.println(k);
		}
	}

}
