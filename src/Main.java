package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map, dist;
    static boolean[][][] visit;
    static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int N, M;
    static Queue<Node> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N - 1 == 0 && M - 1 == 0) {
            System.out.println(1);
            System.exit(0);
        }

        map = new int[N][M];    // 미로 배열
        dist = new int[N][M];   // 거리 측정 배열
        visit = new boolean[2][N][M];   // 벽을 부순 여부에 따라 방문 여부 기록

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

    }

    static void bfs() {

        que.offer(new Node(0, 0, 0));

        while (!que.isEmpty()) {
            Node n = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos[i][0] + n.x;
                int ny= pos[i][1] + n.y;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (map[nx][ny] == 1) {                         // 벽이 있을 때 : 벽을 부순적이 있는지, 그 벽을 방문한 적이 있는지 체크
                    if (n.crash == 0 && !visit[1][nx][ny]) {
                        visit[n.crash][nx][ny] = true;
                        dist[nx][ny] = dist[n.x][n.y] + 1;
                        que.offer(new Node(nx, ny, 1));
                    }
                } else {                                        // 벽이 없을 때 : 벽을 부순 여부에 따른 방문을 했는지 체크
                    if (!visit[n.crash][nx][ny]) {
                        visit[n.crash][nx][ny] = true;
                        dist[nx][ny] = dist[n.x][n.y] + 1;
                        que.offer(new Node(nx, ny, n.crash));
                    }
                }

                if (nx == N - 1 && ny == M - 1) {
                    System.out.println(dist[nx][ny] + 1);
                    System.exit(0);
                }
            }
        }

        System.out.println(-1);

    }
    
}


class Node {

    int x, y, crash;

    Node(int x, int y, int crash) {
        this.x = x;
        this.y = y;
        this.crash = crash;
    }

}