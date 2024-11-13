import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++)
            arr[i] = Integer.parseInt(br.readLine());
        
        Stack<Float> stack = new Stack<>();
        HashMap map = new HashMap<>();

        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (currentChar == '+') {
                float n1 = stack.pop();
                float n2 = stack.pop();
                float rst = n2 + n1;
                stack.push(rst);
            } else if (currentChar == '-') {
                float n1 = stack.pop();
                float n2 = stack.pop();
                float rst = n2 - n1;
                stack.push(rst);
            } else if (currentChar == '*') {
                float n1 = stack.pop();
                float n2 = stack.pop();
                float rst = n2 * n1;
                stack.push(rst);
            } else if (currentChar == '/') {
                float n1 = stack.pop();
                float n2 = stack.pop();
                float rst = n2 / n1;
                stack.push(rst);
            } else {
                
                stack.push((float)arr[cnt++]);
            }
        }

        System.out.printf("%.2f",stack.pop());

    }
}