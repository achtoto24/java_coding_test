
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] check;
    
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        check = new boolean[N];

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int depth) {

        if (depth == M) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < M-1; i++) {
                if (arr[i] > arr[i+1]) return;
                sb2.append(arr[i] + " ");
            }
            sb2.append(arr[M-1]);
            sb.append(sb2 + "\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            check[i] = true;
            arr[depth] = i + 1;
            dfs(depth + 1);
            check[i] = false;
        }

    }

}