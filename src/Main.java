package java_coding_test.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int[][] map;
    static boolean[][] check;
    static int[] move_x = {1, -1, 0, 0};
    static int[] move_y = {0, 0, 1, -1};
    
    static int N;
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) 
                map[i][j] = str.charAt(j) - '0';
        }

        check = new boolean[N + 1][N + 1];
        ArrayList<Integer> list = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !check[i][j]) {
                    cnt = 0;
                    dfsR(i, j);
                    list.add(cnt);
                    result++;
                }
            }
        }

        Collections.sort(list);
        
        System.out.println(result);
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

    }

    public static void dfsR(int x, int y) {

        check[x][y] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int next_x = move_x[i] + x;
            int next_y = move_y[i] + y;

            if (next_x < 0 || next_y < 0 || next_x > N || next_y > N) continue;
            if (map[next_x][next_y] == 0 || check[next_x][next_y]) continue;

            dfsR(next_x, next_y);

        }
        


    }
    
}

