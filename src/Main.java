import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int N, min=Integer.MAX_VALUE, answer = -1;

    static class info {

        int index, count;
        public info(int index, int count) {
            this.index = index;
            this.count = count;
        }

    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            map[A][B] = map[B][A] = 1;
        }
        

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        System.out.println(answer);
        
    }

    static void bfs(int start) {

        Queue<info> que = new LinkedList<>();

        boolean[] check = new boolean[N + 1];

        que.offer(new info(start, 0));
        check[start] = true;
        int result = 0;

        while (!que.isEmpty()) {
            info cur = que.poll();

            for (int i = 1; i <= N; i++) {
                if (map[cur.index][i] == 1 && !check[i]) {
                    result += cur.count + 1;
                    check[i] = true;
                    que.offer(new info(i, cur.count + 1));
                }
            }
        }

        if (result < min) {
            min = result;
            answer = start;
        }
        
    }

}