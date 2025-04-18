import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];

		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int left = 1;
		int right = arr[M - 1];
		int result = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;

			for (int i = 0; i < M; i++) {
				if (mid <= arr[i] && arr[i] % mid != 0) cnt += arr[i] / mid + 1; 
				else if (mid <= arr[i] && arr[i]% mid == 0) cnt += arr[i] / mid;
				else cnt++;
			}

			if (cnt > N) {
				left = mid + 1;
			}	
			else {
				result = mid;
				right = mid - 1;
			}
		}
		
		System.out.println(result);

	}
	
}