import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdln = new Scanner(System.in);
        int N = stdln.nextInt();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int num = stdln.nextInt();
            boolean flag = true;

            if (num == 1)
                continue;

            for (int j = 2; j <= Math.sqrt(num); j++) {  // 소수인지 검증하는 방법 : 2부터 입력한 숫자의 제곱근보다 
                if (num % j == 0) {                     // 작거나 같을 때까지 나머지 계산 
                    flag = false;
                    break;
                }
            }

            if (flag)
                cnt++;
        }

        System.out.println(cnt);
        stdln.close();
    }
}