import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0) break;
			
			int[] arr1 = new int[N];
			int[] arr2 = new int[M];
			

			for (int i = 0; i < N; i++) {
				arr1[i] =  Integer.parseInt(br.readLine());
			}

			for (int i = 0; i < M; i++) {
				arr2[i] = Integer.parseInt(br.readLine());
			}

			int cnt = 0;

			for (int i = 0; i < N; i++) {
				int num = arr1[i];

				int left = 0;
				int right = M - 1;
				while (left <= right) {
					int mid = (left + right) / 2;

					if (arr2[mid] < num) left = mid + 1;
					else if (arr2[mid] > num) right = mid - 1;
					else {
						cnt++;
						break;
					}
				}
			}

			System.out.println(cnt);

		}
		
	}
}