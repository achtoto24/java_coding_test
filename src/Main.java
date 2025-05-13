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

		int[] arr1 = new int[M];
		int[] arr2 = new int[M];


		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			arr1[i] = Integer.parseInt(st.nextToken());
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int num1 = N / 6;
		int num2 = N % 6;

		int cost1 = (num1 + 1) * arr1[0];
		int cost2 = num1 * arr1[0] + num2 * arr2[0];
		int cost3 = N * arr2[0];
		
		System.out.println(Math.min(cost1, Math.min(cost2, cost3)));
		
	}
}