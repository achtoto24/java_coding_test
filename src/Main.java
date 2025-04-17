import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] str = new String[N];
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			str[i] = st.nextToken();	
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(br.readLine());

			int left = 0;
			int right = N - 1;
			int result = 0;

			while (left <= right) {
				int mid = (left + right) / 2;

				if (arr[mid] < num) left = mid + 1;
				else {
					result = mid;
					right = mid - 1;
				}
			}

			System.out.println(str[result]);
		}
		
	}
	
}