import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int bottom = 1;
		int top = N;
		int result = 0;

		while (bottom <= top) {
			int mid = (bottom + top) / 2;
			boolean flag = true;

			int point = 0;
			for (int i = 0; i < M; i++) {
				if (arr[i] - mid <= point) point = arr[i] + mid;
				else flag = false;
			}

			if (N - point > 0) flag = false;
			else flag = true;

			if (flag) {					// 모두 비출 수 있음
				result = mid;
				top = mid - 1;
			} else bottom = mid + 1;	// 모두 비출 수 없음
		}
		
		System.out.println(result);

	}
	
}