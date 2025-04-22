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
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		long bottom = 1;
		long top = arr[N - 1];

		while (bottom <= top) {
			long mid = (bottom + top) / 2;
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				cnt += arr[i] / mid;
			}

			if (cnt >= K) {
				bottom = mid + 1;
			} else top = mid - 1;
		}

		System.out.println(top);

	}

}