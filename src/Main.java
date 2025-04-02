import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
       
        long Z = Y * 100 / X ;

        if (Z >= 99) {
            System.out.println(-1);
            return;
        }
        int min = 0;
        int max = 1000000000;
        int result = 0;

        while (min <= max) {
            int mid = (min + max) / 2;

            long temp = (Y + mid) * 100 / (X + mid);

            if (Z >= temp) {
                min = mid + 1;
                result = mid + 1;
            }
            else max = mid - 1;

        }

        System.out.println(result);
        
    }
}
