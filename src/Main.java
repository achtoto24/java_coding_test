import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner((System.in));
        int N = sc.nextInt();
        int cnt1 = 0;
        int cnt2 = 0;
        int n3 = 0;
        int n5 = 0;

        if (N % 5 == 0) 
            cnt1 = N / 5;
        else if (N % 3 == 0) 
            cnt1 = N / 3;
        loop :
        for (int i = 1; i <= N / 3; i++) {
            for (int j = 1; j <= N / 5; j++) {
                if (3 * i + 5 * j == N) {
                    cnt2 = i + j;   // 처음 게산된 cnt2 값이 가장 작은 값이므로 이중for문을 바로 나와야 함
                    break loop;
                }
            }
        }


        if (cnt1 > 0 && cnt2 > 0) 
            System.out.println(Math.min(cnt1, cnt2));
        else if (cnt1 > 0 && cnt2 == 0)
            System.out.println(cnt1);
        else if (cnt1 == 0 && cnt2 > 0)
            System.out.println(cnt2);
        else
            System.out.println(-1);
        

    }

}