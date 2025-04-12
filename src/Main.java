import java.io.BufferedReader;
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

			if (Math.pow(mid, 2) >= N) {
				result = mid;
				right = mid - 1; 
			} else left = mid + 1;
		}

		System.out.println(result);
		
	}
}