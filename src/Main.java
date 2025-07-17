import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr, arr2;
    static boolean[] check; 
    static int N, M;
    static StringBuilder sb = new StringBuilder();    

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());    
        M = Integer.parseInt(st.nextToken());    

        arr = new int[N];
        arr2 = new int[M];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        dfs(0);

        System.out.println(sb);
        
    }

    static void dfs(int depth) {

        if (depth == M) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < M-1; i++) {
                for (int j = i+1; j < M; j++)
                    if (arr2[i] == arr2[j]) return;
                sb2.append(arr2[i] + " ");
            }
            sb2.append(arr2[M-1]);
            sb.append(sb2 + "\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            check[i] = true;
            arr2[depth] = arr[i];
            dfs(depth + 1);
            check[i] = false;
        }

    }  
    
}