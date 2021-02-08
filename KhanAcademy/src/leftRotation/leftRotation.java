package leftRotation;

import java.util.ArrayList;
import java.util.List;
/**
 * 해커랭크 Left Rotation
 * 입력받은 숫자 d 가 배열의 오른쪽(size-1) 가장 끝으로 올 때 까지 배열의 요소를 주어진 순서를 지킨채 왼쪽으로 옮긴다.
 * 
 * @author ljh
 *
 */
public class leftRotation {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		
		int n = 5; //arr size 
		int d = 4; //찾는 숫자.
		int j = 0; //인덱스
		int divideIndex = d;
		
		//초기화
		for (int i = 0; i < n; i++) {
			arr.add(i+1);
			temp.add(0);
		}
		
		//입력 받은 d 를 기준으로 오른쪽에 있는 요소를 새로 생성한 배열의 인덱스 0 부터 채운다.
		while(divideIndex < n) {
			temp.set(j, arr.get(divideIndex));
			j++;
			divideIndex++;
		}
		
		//입력 받은 d 를 기준으로 d를 포함해 왼쪽에 있는 요소를 새로 생성한 배열의 나머지를 차례로 채운다.
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
