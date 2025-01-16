package java_coding_test.src;

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
    static int max_value = Integer.MIN_VALUE;
    static Queue<Node> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfsR(0); 

        System.out.println(max_value);

    }

    static void dfsR(int cnt) {

        if (cnt == 3) {
            arr2 = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr2[i][j] = arr[i][j];
                }
            }
            check = new boolean[N][M];

            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfsR(cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }

    }

    static void bfs() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) que.offer(new Node(i, j));
            }
        }

        while (!que.isEmpty()) {
            Node n = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos[i][0] + n.x;
                int ny = pos[i][1] + n.y;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (arr[nx][ny] != 0 || check[nx][ny]) continue;

                que.offer(new Node(nx, ny));
                check[nx][ny] = true;
                arr2[nx][ny] = 2;
            }
        }

        result_max();

    }

    static void result_max() {

        int temp_max_value = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr2[i][j] == 0) temp_max_value++; 
            }
        }

        if (max_value < temp_max_value) max_value = temp_max_value;

    }


}

class Node {

    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

}