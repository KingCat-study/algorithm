package dynamicArray;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DynamicArrayClass {
	/**
	 * 해커랭크 Dynamic Array 
	 * 빈 배열로 구성된 2 차원 배열을 만듭니다. 모든 배열은 인덱스가 0입니다. == list
	 * lastAsw 를 인티저로 생성하고 0으로 초기화
	 * 두가지 타입의 쿼리가 있음
	 * 첫번째 쿼리 : 1 x y 일 경우
	 *     index 는 ((x^lastAsw) % n)
	 *     list 의 index 에 해당하는 배열에 y 를 append 한다.
	 *     
	 * 두번째 쿼리 : 2 x y 일 경우
	 *     index 는 ((x^lastAsw) % n)
	 *     list 의 index 에 해당하는 배열을 찾은뒤
	 *     찾은 배열에서 y % list[index].size 를 인덱스로 갖는 값을 찾아 lastAsw 에 저장.
	 *      
	 * @param n
	 * @param queries
	 * @return
	 */
	 public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		 List<Integer> result = new ArrayList<>();
		 List<List<Integer>> list = new ArrayList<>();
		 
		 int lastAsw = 0;
		 
		 for(int i = 0; i < n; i++) {
			 list.add(new ArrayList<>());
		 }
		 
		 for(List<Integer> arr : queries) {
			 int index = (arr.get(1) ^ lastAsw) % n;
			 if(arr.get(0) == 1) {
				 list.get(index).add(arr.get(2));
			 } else if(arr.get(0) == 2) {
				 lastAsw = list.get(index).get(arr.get(2) % list.get(index).size());
				 result.add(lastAsw);
			 }
		 }
		 return result;
	 }
	
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./dynamicArray_input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./dynamicArray_input_result.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

		
        List<Integer> result = DynamicArrayClass.dynamicArray(n, queries);

        for(int i : result) {
        	System.out.println(i);
        }
        
        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
	
	
}
