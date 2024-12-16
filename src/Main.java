package java_coding_test.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] check;
    static int[] move_x = {1, -1, 0, 0};
    static int[] move_y = {0, 0, 1,  -1};
    
    static int N, M;

    static Queue<Spot> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = str.charAt(j) - '0';
        }

        check = new boolean[N][M];
        bfs(0, 0);
        System.out.println(map[N - 1][M - 1]);
        
    }
    
    public static void bfs(int x, int y) {
        
        que.offer(new Spot(x, y));
        check[0][0] = true;

        while (!que.isEmpty()) {
            Spot start = que.poll();
            
            for (int i = 0; i < 4; i++) {
                int next_x = start.x + move_x[i];
                int next_y = start.y + move_y[i];
                
                if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= M) continue;
                if (check[next_x][next_y] || map[next_x][next_y] != 1) continue;
                
                que.offer(new Spot(next_x, next_y));
                check[next_x][next_y] = true;
                map[next_x][next_y] = map[start.x][start.y] + 1;
            }

        }

    }

}

class Spot {
    
    int x;
    int y;
    Spot(int x, int y) {
        this.x = x;
        this.y = y;
    }

}