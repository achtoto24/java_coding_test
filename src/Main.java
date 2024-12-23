package java_coding_test.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] arr = new int[100001];  // 방문 거리 기록
    static boolean[] check = new boolean[100001];  // 방문 여부

    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));

    }

    static int bfs(int start, int end) {
        que.offer(start);
        check[start] = true;
        arr[start] = 0; 

        while (!que.isEmpty()) {
            start = que.poll();

            if (start == end) {
                return arr[start];
            }

            if (start - 1 >= 0 && !check[start - 1]) {  
                que.offer(start - 1);
                check[start - 1] = true;
                arr[start - 1] = arr[start] + 1;  
            }
            if (start + 1 <= 100000 && !check[start + 1]) {  
                que.offer(start + 1);
                check[start + 1] = true;
                arr[start + 1] = arr[start] + 1;  
            }
            if (start * 2 <= 100000 && !check[start * 2]) {  
                que.offer(start * 2);
                check[start * 2] = true;
                arr[start * 2] = arr[start] + 1;  
            }
        }

        return -1;  
    }
}
