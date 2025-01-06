package java_coding_test.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static char[][] arr;
    static boolean[][] check;
    static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    static ArrayList<Character> list = new ArrayList<>();
    static int R, C, cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            } 
        }

        check = new boolean[R][C];
        cnt = 1;
        dfsR(0, 0);

        System.out.println(cnt);

    }

    public static void dfsR(int x, int y) {

        check[x][y] = true;
        char temp = arr[x][y];
        list.add(temp);

        a :
        for (int i = 0; i < 4; i++) {
            int next_x = pos[i][0] + x; 
            int next_y = pos[i][1] + y; 

            if (next_x < 0 || next_y < 0 || next_x >= R || next_y >= C) continue;
            for (int j = 0; j < list.size(); j++) {
                if (arr[next_x][next_y] == list.get(j)) continue a;
            }
            if (check[next_x][next_y]) continue;

            cnt++;
            dfsR(next_x, next_y);
        }

    }
}