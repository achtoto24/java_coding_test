import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int M = Integer.parseInt(br.readLine());
            int[] arr2 = new int[M];

            st = new StringTokenizer(br.readLine());

            a : 
            for (int j = 0; j < M; j++) {
                arr2[j] = Integer.parseInt(st.nextToken());

                int left = 0;
                int right = N - 1;
                
                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (arr2[j] > arr[mid]) left = mid + 1;
                    else if (arr2[j] < arr[mid]) right = mid - 1;
                    else {
                        System.out.println(1);
                        continue a;
                    }
                }
                
                System.out.println(0);
                
            }

        }
        
    }
}