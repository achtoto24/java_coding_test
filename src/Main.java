import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] rst = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i<= N; i++) {
			int cnt = 0;
			int idx = 1;
			while (cnt <= arr[i]) {
				if (rst[idx] == 0) cnt++; 
				else {
					idx++;
					continue;
				}
				idx++;
			}
			rst[--idx] = i;
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(rst[i] + " ");
		}
		
	}

}