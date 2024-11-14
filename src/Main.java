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
        
        Stack<Double> stack = new Stack<>();
        HashMap<Character, Integer> map = new HashMap<>();

        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (currentChar == '+') {
                double n1 = stack.pop();
                double n2 = stack.pop();
                double rst = n2 + n1;
                stack.push(rst);
            } else if (currentChar == '-') {
                double n1 = stack.pop();
                double n2 = stack.pop();
                double rst = n2 - n1;
                stack.push(rst);
            } else if (currentChar == '*') {
                double n1 = stack.pop();
                double n2 = stack.pop();
                double rst = n2 * n1;
                stack.push(rst);
            } else if (currentChar == '/') {
                double n1 = stack.pop();
                double n2 = stack.pop();
                double rst = n2 / n1;
                stack.push(rst);
            } else {
                if (!map.containsKey(currentChar)) 
                    map.put(currentChar, arr[cnt++]); 
                stack.push((double)map.get(currentChar));
            }
        }

        System.out.printf("%.2f",stack.pop());

    }
}