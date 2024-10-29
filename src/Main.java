import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * '('는 스택에 push하고 ')'는 스택에서 pop을 하면 됨
 * 결과적으로 스택에 '(' 이나 ')'이 남아있으면 VPS를 만족하지 못 함 
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String S = br.readLine();
			
			Stack<Character> stack = new Stack<Character>();
			
			for (int j = 0; j < S.length(); j++) {
				if (S.charAt(j) == '(') 
					stack.push(S.charAt(j));
				else {
					//비어있는지를 먼저 본다.
					if (stack.isEmpty()) {
						stack.push(S.charAt(j));
						break;
					}else 
						stack.pop();
				}
			}
			if (stack.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}