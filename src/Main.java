package java_coding_test.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] arr;
    static boolean[] check = new boolean[26];

    static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);                
            }
        }
        
        dfsR(0, 0, 0);
        
        System.out.println(result);

    }

    // 백트래킹 + dfs 알고리즘
    static void dfsR(int x, int y, int cnt) {
         
        if (check[arr[x][y] - 'A']) {
            result = Math.max(cnt, result);
            return;
        } else {
            check[arr[x][y] - 'A'] = true;

            for (int i = 0; i < 4; i++) {
                int nx = pos[i][0] + x; 
                int ny = pos[i][1] + y; 

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

                dfsR(nx, ny, cnt +1);
            }

            check[arr[x][y] - 'A'] = false;
        }

    }

}