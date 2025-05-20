import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[26];
		
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - 'A';
			arr[idx]++;
		}

		int isOdd = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) isOdd++;
		}
		
		String result = "";
		if (isOdd > 1) {
			result += "I'm Sorry Hansoo";
		} else {
			StringBuilder sb = new StringBuilder();

			// start
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i]/2; j++) {
					sb.append((char)(i + 65));
				}
			}
			result += sb.toString();

			// end 
			String temp = sb.reverse().toString();

			// middle
			sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] % 2 != 0) sb.append((char)(i + 65));
			}

			result += sb.toString() + temp;
			
		}
		
		System.out.println(result);

		
	}
}