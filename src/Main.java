import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        Stack<Integer> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] count = new int[1_000_001];
        int[] result = new int[N];
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            count[arr[i]]++;
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && count[arr[i]] > count[arr[stack.peek()]])
                result[stack.pop()] = arr[i];
            stack.push(i);
        }        

        while (!stack.isEmpty())
            result[stack.pop()] = -1;
        
        StringBuilder sb = new StringBuilder();
        for (int i : result)
            sb.append(i).append(" ");

        System.out.println(sb);

    }
}