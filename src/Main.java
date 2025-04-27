import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); 
		String[] arr = new String[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
 
		Arrays.sort(arr);

		int cnt = 0;
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();

			int left = 0;
			int right = N - 1;
			while (left <= right) {
				int mid = (left + right) / 2;

				if (str.equals(arr[mid].substring(0, str.length())))  {
					cnt++;
					break;
				}
				else {
					if (arr[mid].compareTo(str) >= 0) right = mid - 1;
					else left = mid + 1;
				} 
			}
		}

		System.out.println(cnt);
				
	}

}