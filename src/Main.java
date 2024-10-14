import java.util.Scanner;

public class Main {
    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) {

        Scanner sc = new Scanner((System.in));

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = sc.next();

            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W')
                    arr[i][j] = true;   // 'W'일 때 true
                else
                    arr[i][j] = false;  // 'B'일 때 false
            }
        }

        // (i, j)는 8x8 체스판의 시작 지점
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                find(i, j);
            }
        }

        System.out.println(min);

    }

    static void find(int x, int y) {
        boolean tf = arr[x][y]; // 기준 칸 값
        int count = 0;
        
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (arr[i][j] != tf)
                    count++;
                    
                tf = !(tf);     // 다음 칸은 현재(기준) 칸 값과 반대
            }
            tf = !(tf); // 다음 줄 첫 번째 칸은 현재 줄 첫 번째 칸 값과 반대
        }

        int min_count = Math.min(count, 64 - count);    // 첫 번째 칸이 'W'이거나 'B' 두가지 경우 비교 

        min = Math.min(min, min_count);
    }

}