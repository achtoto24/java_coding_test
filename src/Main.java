import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

/*
 * <'스택 수열' 문제>
 * 스택에는 배열 요소의 인덱스가 담김
 * 조회하는 배열의 요소와 스택의 최상위 요소를 인덱스로 하는 요소를 비교하여
 * 조회하는 요소가 크다면 그것을 스택의 최상위 요소를 인덱스로 하는 요소 값으로 변경
 * 이 과정에서 스택에서 pop하여 스택의 최상위 요소를 변경
 * 반복문이 끝나면 조회하는 요소의 인덱스를 스택에 push함
 */
public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>();
			
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i])
			arr[stack.pop()] = arr[i];
			
			stack.push(i);
		}
			
		while (!stack.isEmpty()) 
			arr[stack.pop()] = -1;
		
		StringBuilder sb = new StringBuilder();
		for (int i : arr)
			sb.append(i).append(" ");		
	
		System.out.println(sb);
	}

}
