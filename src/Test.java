import java.util.Scanner;
 
public class Test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        
		int N = in.nextInt();
 
		for (int i = 2; i <= Math.sqrt(N); i++) {	// 또는 i * i <= N
			while (N % i == 0) {
				System.out.println(i);
				N /= i;
			}
		}

		if (N != 1)     // N % i == 0을 만족시키지 못 했을 경우 최종 N은 출력을 하지 못하는 것을 방지
			System.out.println(N);
		
	}
}