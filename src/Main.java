import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String A4 = "AAAA";
	static String B2 = "BB";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		StringBuilder sb = new StringBuilder();
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == 'X') {
				count++;
			} else {
				// 'X' 덩어리 처리
				if (count % 2 != 0) {
					System.out.println(-1);
					return;
				}
				while (count >= 4) {
					sb.append(A4);
					count -= 4;
				}
				while (count >= 2) {
					sb.append(B2);
					count -= 2;
				}
				sb.append('.'); // '.' 그대로 추가
			}
		}

		// 마지막에 X로 끝났을 때 처리
		if (count % 2 != 0) {
			System.out.println(-1);
			return;
		}
		while (count >= 4) {
			sb.append(A4);
			count -= 4;
		}
		while (count >= 2) {
			sb.append(B2);
			count -= 2;
		}

		System.out.println(sb);
	}
}
