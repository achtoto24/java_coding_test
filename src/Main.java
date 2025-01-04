package java_coding_test.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static long A, B;
    static HashMap<Long, Integer> check = new HashMap<>();
    static Queue<Long> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        System.out.println(bfs(A));

    }

    static int bfs(long start) {

        que.offer(start);
        check.put(start, 1);

        while (!que.isEmpty()) {
            start = que.poll();

            if (start == B) return check.get(start);

            if (start * 2 <= B && !check.containsKey(start * 2)) {
                que.offer(start * 2);
                check.put(start * 2, check.get(start) + 1);
            }
            if (start * 10 + 1 <= B && !check.containsKey(start * 10 - 1)) {
                que.offer(start * 10 + 1);
                check.put(start * 10 + 1, check.get(start) + 1);
            }
        }
        
        return -1;
    }
}