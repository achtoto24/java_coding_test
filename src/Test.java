import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine(); // 다음 줄바꿈을 소비합니다.

        char[][] arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) 
                arr[i][j] = str.charAt(j);
        }

        int min = Integer.MAX_VALUE;

        // 체스판 패턴을 비교
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int count1 = 0; // 'B'로 시작하는 경우
                int count2 = 0; // 'W'로 시작하는 경우

                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        char expectedChar1 = (k + l) % 2 == 0 ? 'B' : 'W';
                        char expectedChar2 = (k + l) % 2 == 0 ? 'W' : 'B';

                        if (arr[i + k][j + l] != expectedChar1) {
                            count1++;
                        }
                        if (arr[i + k][j + l] != expectedChar2) {
                            count2++;
                        }
                    }
                }
                min = Math.min(min, Math.min(count1, count2));
            }
        }

        System.out.println(min);
        sc.close(); // Scanner를 닫습니다.
    }
}
