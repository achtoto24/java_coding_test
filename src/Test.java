import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

	static String A4 = "AAAA";
	static String B2 = "BB";

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		StringTokenizer st = new StringTokenizer(str, ".");
		StringTokenizer st2 = new StringTokenizer(str, "X");

		StringBuilder sb = new StringBuilder();
		while (st.hasMoreTokens()) {
			int len = st.nextToken().length();
			while (len > 0) {
				if (len - 4 >= 0) {
					sb.append(A4);
					len -= 4;
					continue;
				} else if (len - 2 >= 0) {
					sb.append(B2);
					len -= 2;
					continue;
				} else{
					System.out.println(-1);
					return;
				}
			}
			if (st2.hasMoreTokens()) sb.append(st2.nextToken());
			
		}
		
		System.out.println(sb);
		
	}
	 
} 