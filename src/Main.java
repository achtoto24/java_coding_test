package java_coding_test.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] check;

    static int[] move_x = {-1, 1, 0, 0};
    static int[] move_y = {0, 0, -1, 1};

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        int maxDepth = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > maxDepth) maxDepth = map[i][j];
            }
        }
                
        int max = 0;
        for (int depth = 0; depth <= maxDepth; depth++) {
            check = new boolean[N][N];
            int area = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > depth && !check[i][j]) {
                        dfsR(i, j, depth);
                        area++;
                    } 
                }
            }
            
            max = Math.max(area, max);
        }

        System.out.println(max);

    }

    static void dfsR(int x, int y, int depth) {

        check[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int next_x = move_x[i] + x;
            int next_y = move_y[i] + y;

            if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= N) continue;
            if (map[next_x][next_y] <= depth || check[next_x][next_y]) continue;

            dfsR(next_x, next_y, depth);
        }

    }

}

