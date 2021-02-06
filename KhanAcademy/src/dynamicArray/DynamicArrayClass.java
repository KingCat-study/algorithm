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
	 * ��Ŀ��ũ Dynamic Array 
	 * �� �迭�� ������ 2 ���� �迭�� ����ϴ�. ��� �迭�� �ε����� 0�Դϴ�. == list
	 * lastAsw �� ��Ƽ���� �����ϰ� 0���� �ʱ�ȭ
	 * �ΰ��� Ÿ���� ������ ����
	 * ù��° ���� : 1 x y �� ���
	 *     index �� ((x^lastAsw) % n)
	 *     list �� index �� �ش��ϴ� �迭�� y �� append �Ѵ�.
	 *     
	 * �ι�° ���� : 2 x y �� ���
	 *     index �� ((x^lastAsw) % n)
	 *     list �� index �� �ش��ϴ� �迭�� ã����
	 *     ã�� �迭���� y % list[index].size �� �ε����� ���� ���� ã�� lastAsw �� ����.
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
