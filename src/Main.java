package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr, arr2;
    static boolean[][] check;
    static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int N, M;
    static int min_len = Integer.MAX_VALUE;
    static int no_end_cnt = 0;
    static Queue<Node> que = new LinkedList<>();
    static Queue<Pos> que2 = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
                if (arr[i][j] == 1) que2.offer(new Pos(i, j));
            }
        }
        
        break_wall();

        if (no_end_cnt == que2.size()) System.out.println(-1);
        else System.out.println(min_len);
        
    }

    static void break_wall() {

        for (int i = 0; i < que2.size(); i++) {
            check = new boolean[N][M];
            Pos p = que2.poll();
            arr[p.x][p.y] = 0;
            bfs();
            arr[p.x][p.y] = 1;
        }

    }

    static void bfs() {

        int len = 0;
        que.offer(new Node(0, 0, len));
        check[0][0] = true;

        while (!que.isEmpty()) {
            Node n = que.poll();
            if (len == n.len) len++;
            else n.len = len;

            for (int i = 0; i < 4; i++) {
                int nx = pos[i][0] + n.x;
                int ny = pos[i][1] + n.y;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (arr[nx][ny] != 0 || check[nx][ny]) continue;

                que.offer(new Node(nx, ny, len));
                check[nx][ny] = true;
            }
        }

        if (!check[N-1][M-1]) {
            no_end_cnt++;
            return;
        } else min_length(len);


    }

    static void min_length(int temp) {

        if (min_len > temp) min_len = temp;

    }
    
}

class Pos {

    int x, y;

    Pos (int x, int y) {
        this.x = x;
        this.y = y;
    }

}


class Node {

    int x, y, len;

    Node(int x, int y, int len) {
        this.x = x;
        this.y = y;
        this.len = len;
    }

}