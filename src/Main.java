package java_coding_test.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[][] check;
    static int[] move_x = {-1, 1, 0, 0};
    static int[] move_y = {0, 0, -1, 1};

    static int M, N, node;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            node = Integer.parseInt(st.nextToken()); 

            arr = new int[M + 1][N + 1];
            check = new boolean[M + 1][N + 1];
            int cnt = 0;

            for (int j = 0; j < node; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                arr[a][b] = 1;
            }

            for (int k = 0; k < M; k++) {
                for (int l = 0; l < N; l++) {
                    if (arr[k][l] == 1 && !check[k][l]) {
                        dfsR(k, l);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);

        }


    }

    public static void dfsR(int x, int y) {

        check[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int next_x = x + move_x[i];
            int next_y = y + move_y[i];
            
            if (next_x < 0 || next_y < 0 || next_x > M || next_y > N ) continue;
            if (arr[next_x][next_y] == 0 || check[next_x][next_y]) continue;

            dfsR(next_x, next_y);
        }

    }

}