import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이중 for문을 통해 기준 값과 기준 이전 값들을 비교하여 값을 갱신함
        // dp default : 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;    
                // dp[j] + 1을 하는 이유는 이전 부분수열에 j-1번째 원소가 추가되었기 때문
                // dp[i] > dp[j] + 1이라면 굳이 값을 갱신해줄 필요가 없음
            }               
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) max = dp[i];
        }

        System.out.println(max);
        
    }
}