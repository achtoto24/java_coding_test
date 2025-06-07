import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] check;
    static int[] move_x = {-1, 1, 0, 0};
    static int[] move_y = {0, 0, -1, 1};
    
    static int n, m, cnt;
    
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check = new boolean[n][m];
        int max = 0;        
        int total = 0;
        for (int  i = 0 ; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !check[i][j]) {
                    cnt = 0;
                    dfsR(i, j);
                    max = Math.max(max, cnt);
                    total++;
                }
            }
        }
                
        System.out.println(total);
        System.out.println(max);
        
    }

    static void dfsR(int x, int y) {
        
        check[x][y] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int next_x = move_x[i] + x;
            int next_y = move_y[i] + y;

            if (next_x < 0 || next_y < 0 || next_x >= n || next_y >= m) continue;
            if (map[next_x][next_y] == 0 || check[next_x][next_y]) continue;

            dfsR(next_x, next_y);
        }

    }
    
}