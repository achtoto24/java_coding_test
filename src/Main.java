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
        check = new boolean[N];
        arr2 = new int[M];
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        
        Arrays.sort(arr);
        
        dfs(0);
        
        System.out.println(sb);
        
    }
    
    static void dfs(int depth) {
        
        
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr2[i] + " ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < N; i++) {
                int before = 0; 
                if (!check[i] && arr[i] != before) {
                    check[i] = true;
                    before = arr[i];
                    arr2[depth] = arr[i];
                    dfs(depth + 1);
                    check[i] = false;
                }
            }
        }
        
    }
    
}