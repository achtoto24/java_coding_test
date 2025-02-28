import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
처음으로 완벽하게 푼 dp문제...
백준 실버 20문제 만에 풀었다...ㅠㅠ
*/ 
public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2 + 1][n + 1];
            int[][] dp = new int[2 + 1][n + 1];
            StringTokenizer st;

            for (int j = 1; j <= 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];

            int max = dp[1][1] > dp[2][1] ? dp[1][1] : dp[2][1];
            if (n >= 2) {
                for (int j = 2; j <= n; j++) {
                    dp[1][j] = Math.max(dp[2][j - 1], dp[2][j - 2]) + arr[1][j];
                    dp[2][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[2][j];
                    if (dp[1][j] > max) max = dp[1][j];
                    if (dp[2][j] > max) max = dp[2][j];
                }
            }

            System.out.println(max);

        }
        
    }

}