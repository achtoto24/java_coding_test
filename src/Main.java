
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] check;
    static Queue<Spot> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        check = new boolean[F + 1];

        int result = bfs(F, S, G, U, D);
        if (result == -1) System.out.println("use the stairs");
        else System.out.println(result);
        
    }

    static int bfs(int height, int start, int end, int up, int down) {

        que.offer(new Spot(start, 0));
        check[start] = true;
        
        while (!que.isEmpty()) {
            Spot spot = que.poll();

            if (spot.layer == end) {
                return spot.cnt;
            }

            if (spot.layer + up <= height && !check[spot.layer + up]) {
                que.offer(new Spot(spot.layer + up, spot.cnt + 1));
                check[spot.layer + up] = true;
            }
            
            if (spot.layer - down >= 1 && !check[spot.layer - down]) {
                que.offer(new Spot(spot.layer - down, spot.cnt + 1));
                check[spot.layer - down] = true;
            }
        }

        return -1;
        
    }
    
}

class Spot {

    int layer, cnt;

    Spot(int layer, int cnt) {
        this.layer = layer;
        this.cnt = cnt;
    }
    
}