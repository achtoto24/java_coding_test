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

    static int[] move_x = {-2, 2, -1, 1, -2, 2, -1, 1};
    static int[] move_y = {1, 1, 2, 2, -1, -1, -2, -2};

    static int N;
    static int start_x, start_y, last_x, last_y;

    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        while (T != 0) {
            
            N = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine());    
            start_x = Integer.parseInt(st.nextToken());
            start_y = Integer.parseInt(st.nextToken());
            
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            last_x = Integer.parseInt(st2.nextToken()); 
            last_y = Integer.parseInt(st2.nextToken()); 
            
            map = new int[N][N];
            check = new boolean[N][N];
            
            System.out.println(bfs(start_x, start_y, last_x, last_y));
            
            T--;
        }
    }
    
    static int bfs(int start_x, int start_y, int last_x, int last_y) {
        
        Queue<Spot> que = new LinkedList<>();
        que.offer(new Spot(start_x, start_y, 0));
        check[start_x][start_y] = true;

        while (!que.isEmpty()) {
            Spot s = que.poll();

            if (s.x == last_x && s.y == last_y) return s.cnt;

            for (int i = 0; i < 8; i++) {
                int next_x = move_x[i] + s.x;
                int next_y = move_y[i] + s.y;

                if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= N) continue;
                if (check[next_x][next_y]) continue;

                que.offer(new Spot(next_x, next_y, s.cnt + 1));
                check[next_x][next_y] = true;
            }

        }

        return - 1;

    }


}

class Spot {
    int x, y, cnt;

    Spot(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}