package java_coding_test.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[] check;
    
    static int node, line;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        arr = new int[node + 1][node + 1];
        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        check = new boolean[node + 1];

        int start = 1;
        dfsR(start);

        System.out.println(cnt - 1);

    }

    public static void dfsR(int start) {

        check[start] = true;
        cnt++;

        for (int i = 1; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i]) dfsR(i);
        }

    }

}