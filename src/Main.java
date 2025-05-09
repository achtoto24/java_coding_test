import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st, st2;
		
		String S = br.readLine();
		int num_0 = 0, num_1 = 0;
		String temp;

		st = new StringTokenizer(S,"0");
		 while (st.hasMoreTokens()) {
			temp = st.nextToken();
			num_0++;
		 }

		 
		st2 = new StringTokenizer(S,"1");
		while (st2.hasMoreTokens()) {
			temp = st2.nextToken();
		   	num_1++;
		}

		if (num_0 >= num_1) System.out.println(num_1);
		else System.out.println(num_0);;
		
	}
}