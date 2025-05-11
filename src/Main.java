import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 서류 성적 순위로 정렬한 후 면접 성적 비교하기
// 비교군 중에서 한 명이라도 서류, 면접 성적 순위가 모두 높다면 탈락! 
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];
			int cnt = 1;

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a] = b;
			}

			int compare = arr[1];
			for (int j = 2; j < N+1; j++) {
				if (compare > arr[j]) {
						cnt++;
						compare = arr[j];
				}
			}
			
			System.out.println(cnt);
			
		}
		
		
	}
}