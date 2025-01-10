package java_coding_test.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[][] check;
    static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int M, N, label;
    static int cnt = 0;

    static Queue<Node> que = new LinkedList<>(); 

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int cnt2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1)  {
                    que.offer(new Node(i, j, 1));
                    cnt2++;
                }
            }
        }

        if (cnt2 == N * M) {
            System.out.println(0);
            return;
        } else bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 && !check[i][j])  {
                    System.out.println(-1); 
                    return;
                }
            }
        }

        System.out.println(cnt - 1);

    }

    static void bfs() {

        int temp_label = label;
        
        while (!que.isEmpty()) {
            Node n = que.poll();
            if (n.label != temp_label) {
                cnt++;
                temp_label = n.label;
                label++;
            } 
            label = n.label + 1;

            for (int i = 0; i < 4; i++) {
                int nx = pos[i][0] + n.x;
                int ny = pos[i][1] + n.y;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (arr[nx][ny] == -1 || check[nx][ny]) continue;
                    
                que.offer(new Node(nx, ny, label));
                check[nx][ny] = true;
            }
        }
        
    }
   
}

class Node {

    int x, y, label;

    Node (int x, int y, int label) {
        this.x = x;
        this.y = y;
        this.label = label;
    }

}