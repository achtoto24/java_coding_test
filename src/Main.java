import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr, arr2;
    static boolean[] check;
    static int N, M;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        check = new boolean[N];
        arr2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
                
        Arrays.sort(arr);

        dfs(0);
                
    }

    static void dfs(int depth) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr2[i] + " ");
            }
            System.out.println();
        }

        else {
            int before = 0;
            for (int i = 0; i < N; i++) {
                if (!check[i] && before != arr[i]) {
                    check[i] = true;
                    arr2[depth] = arr[i];
                    before = arr[i];
                    dfs(depth + 1);
                    check[i] = false;
                 }
            }
        }
        
    }
    
}