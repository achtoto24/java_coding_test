import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        int cnt = 0;
        int stack_len = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                if (str.charAt(i+1) == ')') {
                    cnt += stack_len;
                    i++;
                }
                else {
                    stack.push(ch);
                    stack_len++;
                    cnt++;    
                }
            } else {
                stack.pop();
                stack_len--;
            }
        }

        System.out.println(cnt);

    }
}