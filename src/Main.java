import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		if (n == 1 || n == 3) {
			System.out.println(-1);
			return;
		}
		
		int cnt = 0;
		int temp = n;

		while (temp % 5 != 0) {
			temp -= 2;
			cnt++; 
		}

		cnt += temp / 5;

		
		System.out.println(cnt);
		
	}
}