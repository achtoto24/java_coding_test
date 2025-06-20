import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int cnt = 0;
    static int N, S;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (S == 0) cnt--;  // 아무 원소도 선택하지 않을 경우도 카운트되므로 빼야 함

        System.out.println(cnt);
        
    }

    static void dfs(int idx, int sum) {

        if (idx == N) {
            if (sum == S) cnt++;
            return;
        } 

        dfs(idx + 1, sum + arr[idx]);   // idx번째 원소를 포함하여 sum을 계산한 경우
        dfs(idx + 1, sum);              // idx번쨰 원소를 포함하지 않고 sum을 계산한 경우
        
    }

}