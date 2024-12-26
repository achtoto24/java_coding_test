package java_coding_test.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] check;
    static int[] move_x = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] move_y = {0, 0, -1, 1, -1, 1, -1, 1};

    static int w, h;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        while (w != 0 && h != 0) {
            map = new int[h][w];
            check = new boolean[h][w];
            int cnt = 0;
            
            for (int i = 0; i < h; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st2.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !check[i][j]) cnt += dfsR(i, j);
                }
            }
            
            System.out.println(cnt);

            StringTokenizer st3 = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st3.nextToken());
            h = Integer.parseInt(st3.nextToken());
        }
    }

    static int dfsR(int x, int y) {

        check[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int next_x = move_x[i] + x;
            int next_y = move_y[i] + y;

            if (next_x < 0 || next_y < 0 || next_x >= h || next_y >= w) continue;
            if (map[next_x][next_y] == 0 || check[next_x][next_y]) continue;

            dfsR(next_x, next_y);
        }

        return 1;
    }
}