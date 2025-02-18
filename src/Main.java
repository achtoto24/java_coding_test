import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int  n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[1] = arr[1];
        int max = arr[1];
        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
                max = Math.max(max, dp[i]);
            }
        }
        
        // 마지막 dp[n] 값이 max가 되는 게 아니라 dp[1]~dp[n]까지 값들 중 max를 구하는 것
        System.out.println(max);

    }
}