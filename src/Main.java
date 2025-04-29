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
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num1_idx = 0;
			int num2_idx = 0;

			int left = 0;
			int right = N - 1;
			while (left <= right) {
				int mid = (left + right) / 2;

				if (arr[mid] < num1) left = mid + 1;
				else right = mid - 1;
			}

			num1_idx = left;
			if (num1_idx == arr[left]) num1_idx = left;
			// System.out.println("num1_idx : " + num1_idx);			
			left = 0;
			right = N - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				
				if (arr[mid] < num2) left = mid + 1;
				else right = mid - 1;
			}
			
			num2_idx = left;
			// System.out.println("num1_idx : " + num2_idx);			
			
			System.out.println(num2_idx - num1_idx);

		}
		
	}
}