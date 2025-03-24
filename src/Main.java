import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long max = arr[0];
        long min = 0;
        for (int i = 1; i < K; i++) {
            max = max < arr[i] ? arr[i] : max;
        }

        max++;
        
        while (min < max) {
            long mid = (min + max) / 2;

            long num = 0;
            for (int i : arr) {
                num += i / mid;
            }

            // Upper Bound 형식 : 같은 num값과 연계된 mid들 중 최대값을 구하므로
            // 나열된 mid들 중 가장 오른쪽 값을 구하기 위해 num값이 달라지는 시점의
            // mid를 구하는 mid+1(num값이 달라졌을 때 가장 작은 mid)을 하면 됨
            if (num < N) max = mid; 
            else min = mid + 1;                       
        }
        
        System.out.println(min - 1);
        
    }
}