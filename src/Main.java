import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());

		long left = 0;
		long right = N;
		long result = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			System.out.println(mid);

			result = mid;
			long temp = mid * mid;
			System.out.println("temp :" + temp);

			if (temp < N) right = mid - 1; 
			else left = mid + 1;
		}

		System.out.println(result);


		
	}
}