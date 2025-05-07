import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		int sum = 0;
		boolean flag = true;

		while (st.hasMoreTokens()) {
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
			int temp = 0;
			
			while (st2.hasMoreTokens()) {
				temp += Integer.parseInt(st2.nextToken());
			}

			if (flag) {
				sum += temp;
				flag = false;
			}
			else sum -= temp;
		}

		System.out.println(sum);
		
	}
}