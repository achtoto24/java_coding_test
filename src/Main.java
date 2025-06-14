import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs & 백트래킹 문제
public class Main {

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int[] operator = new int[4];
    static int[] arr;
    static int N;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        
       dfs(arr[0], 1); 
        
        System.out.println(MAX);
        System.out.println(MIN);
        
    }

    public static void dfs(int num, int idx) {
        if(idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0 : dfs(num + arr[idx], idx + 1); break;
                    case 1 : dfs(num - arr[idx], idx + 1); break;
                    case 2 : dfs(num * arr[idx], idx + 1); break;
                    case 3 : dfs(num / arr[idx], idx + 1); break;
                }

                operator[i]++;
            }
        }
    }
    
}