import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '<') {
				if (!stack.isEmpty()) {
					while (!stack.isEmpty())
						sb.append(stack.pop());
				}
				sb.append(str.charAt(i));
				int j = i + 1;
				while (str.charAt(j) != '>') {
					sb.append(str.charAt(j));
					j++;
				}
				i = j;
				sb.append(str.charAt(i));
				continue;
			}else if (str.charAt(i) == ' ') {
				while (!stack.isEmpty()) 
					sb.append(stack.pop());
				sb.append(" ");
			}else {
				stack.push(str.charAt(i));		
			}
		}

		if (!stack.isEmpty()) {
			while (!stack.isEmpty())
				sb.append(stack.pop());
			sb.append(" ");
		}

		System.out.println(sb);

	}

}
