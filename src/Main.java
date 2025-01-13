package java_coding_test.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][][] arr;
    static boolean[][][] check;
    static int[][] pos = {
                          {-1, 0, 0}, {1, 0, 0}, {0, -1, 0},
                          {0, 1, 0}, {0, 0, -1}, {0, 0, 1}
                         };

    static int M, N, H;
    static int day = 0;
    static int label = 1;
    
    static Queue<Node> que = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        check = new boolean[H][N][M];
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st2.nextToken());
                    if(arr[i][j][k] == 1) que.offer(new Node(j, k, i, label));
                    else if (arr[i][j][k] == 0) cnt++;
                }
            }
        }

        if (cnt != 0) {
            bfs();
        } else {
            System.out.println(0);
            return;
        }
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0 && !check[i][j][k]) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(day);
        
                
    }

    static void bfs() {

        int temp_label = 1;
        while (!que.isEmpty()) {
            Node n = que.poll();
            if (temp_label != n.label) {
                temp_label = n.label;
                day++;
            }
            label = n.label + 1;

            for (int i = 0; i < 6; i++) {
                int nx = pos[i][0] + n.x;
                int ny = pos[i][1] + n.y;
                int nz = pos[i][2] + n.z;

                if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue;
                if (arr[nz][nx][ny] == -1 || check[nz][nx][ny]) continue;
                
                check[nz][nx][ny] = true;
                que.offer(new Node(nx, ny, nz, label));
            }

        }
        
    }

}

class Node {
    
    int x, y, z, label;

    Node(int x, int y, int z, int label) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.label = label;
    }

}