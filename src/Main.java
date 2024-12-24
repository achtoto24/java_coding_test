package java_coding_test.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> list[];
    static boolean[] check;

    static HashMap<Integer, Integer> map = new HashMap<>();

    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        check = new boolean[N + 1];

        for (int i = 1; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list[a].add(b);
            list[b].add(a);
        }

        dfsR(1, 0);

        for (int i = 2; i <= N; i++) {
            System.out.println(map.get(i));
        }

    }

    static void dfsR(int start, int parent) {

        map.put(start, parent);
        check[start] = true;

        for (int i : list[start]) {
            if (!check[i]) dfsR(i, start);
        }

    }

}