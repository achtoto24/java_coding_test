import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long[] road = new long[N-1];
		long[] price = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i <N-1; i++) {
			road[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Long.parseLong(st.nextToken());
		}

		long total = 0;
		long min = price[0];
		total += price[0] * road[0];
		for (int i = 1; i < N-1; i++) {
			if (min > price[i]) {
				total += price[i] * road[i];
				min = price[i];
			} else total += min * road[i];
		}

		System.out.println(total);

		
	}
}