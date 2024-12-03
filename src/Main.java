import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
        
    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < t; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int[] arr = new int[n];

                for (int j = 0; j < n; j++)
                    arr[j] = Integer.parseInt(st.nextToken());
                    
                long sum = 0;
                for (int k = 0; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) 
                        sum += gcd(arr[k], arr[l]);
                }
                
                System.out.println(sum);
            }
                     
    }

    public static int gcd(int a, int b) {

        if (b == 0) return a;

        return gcd(b, a % b);

    }

}

