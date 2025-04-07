import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(arr);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());

                int left = 0;
                int right = N-1;
                boolean flag = false;
                
                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (val == arr[mid]) {
                        flag = true;
                        break;
                    } else if (val > arr[mid]) left = mid + 1;
                    else right = mid - 1;
                }
                
                if (flag) sb.append(1).append("\n");
                else sb.append(0).append("\n");
                
            }
        }
        
        System.out.print(sb);
        
    }
    
}