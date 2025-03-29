import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long min = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            min = Math.max(min, arr[i]);    // min이 될 수 있는 가장 작은 값은 배열 원소 중 가장 큰 값 
            max += arr[i];
        }
        
        while (min <= max) {
            long mid = (min + max) / 2;

            long sum = 0;
            long num = 1;
            for (int i = 0; i < N; i++) {
                sum += arr[i];
                if (sum <= mid) continue;      
                else {
                    sum = 0;
                    sum += arr[i];
                    num++;
                }
            }

            if (num <= M) max = mid - 1;
            else min = mid + 1;
        }

        System.out.println(min);
        
    }
}
