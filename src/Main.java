package java_coding_test.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[][] check;

    static int[] move_x = {-1, 1, 0, 0};
    static int[] move_y = {0, 0, -1, 1};


    static int M, N, area;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        check = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st2.nextToken());
            int y1 = Integer.parseInt(st2.nextToken());
            int x2 = Integer.parseInt(st2.nextToken());
            int y2 = Integer.parseInt(st2.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    arr[k][j] = 1;  
                }
            }
        }

        int res = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0 && !check[i][j]) {
                    area = 0;
                    dfsR(i, j);
                    list.add(area);
                    res++;
                } 
                    
            }
        }

        Collections.sort(list);
        
        System.out.println(res);
        for (int i = 0 ; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }

    static void dfsR(int x, int y) {

        check[x][y] = true;
        area++;

        for (int i = 0; i < 4; i++) {
            int next_x = move_x[i] + x;
            int next_y = move_y[i] + y;

            if (next_x < 0 || next_y < 0 || next_x >= M || next_y >= N) continue;
            if (arr[next_x][next_y] == 1 || check[next_x][next_y]) continue;

            dfsR(next_x, next_y);
        }

    }

}