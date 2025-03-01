import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합 공식(파스칼 공식)을 이용하기
public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int[][] dp = new int[30][30];

        for (int i = 1; i < 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i = 2; i < 30; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(dp[M][N]);

        }
        
    }

}