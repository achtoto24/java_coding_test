import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }

        int M = Integer.parseInt(br.readLine());

        int min = 0;
        int max = arr[0];
        for (int i = 1; i < N; i++) {
            max = (arr[i] > max) ? arr[i] : max;
        }

        while (min <= max) {
            int mid = (min + max) / 2;
            
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] >= mid) sum += mid;
                else sum += arr[i];
            }
            
            if (sum > M) max = mid - 1;
            else min = mid + 1;
        }

        System.out.println(max);
    }
}



// 해냈다!!!!!!!!!!!!!!!!!!!!!!!