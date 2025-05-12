import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int[] arr = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i) - '0';
		}

		Arrays.sort(arr);

		int sum = 0;
		for (int i : arr) {
			sum += i;
		}

		if (sum % 3 == 0 && arr[0] == 0) {
			for (int i = arr.length - 1; i >= 0; i--) {
				sb.append(arr[i]);
			}
			System.out.println(sb);
		} else System.out.println(-1);
					
	}
	
}