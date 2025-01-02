import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[] check;

    static int N, line;
    static int cnt;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        
        arr = new int[N + 1][N + 1];
        check = new boolean[N + 1];
        line = Integer.parseInt(br.readLine());
        for (int i = 0; i < line; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            
            arr[a][b] = arr[b][a] = 1;
        }

        cnt = 0;
        System.out.println(dfsR(num1, num2));
        
    }

    static int dfsR(int start, int end) {

        check[start] = true;
        if (start == end) return cnt;
        cnt++;
        
        for (int i = 1; i <= N; i++) {
            if (arr[start][i] == 1 && !check[i]) dfsR(i, end);
        }
        
        

    }
}