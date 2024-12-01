import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    
    public static boolean[] prime = new boolean[1000001];
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
        prime_func();

        while (true) {
            int N = Integer.parseInt(br.readLine());       
            if (N == 0) break;

            boolean flag = true;
            
            for (int i = 2; i < N / 2; i++) {   // -> i는 N - i와 짝을 이루므로 N / 2까지 하면 됨
                if (!prime[i] && !prime[N - i]) {
                    System.out.printf("%d = %d + %d\n", N, i, N - i);
                    flag = false;
                    break;
                } 
            }

            if (flag) System.out.println("Goldbach's conjecture is wrong.");
            
        }
        
    }

    public static void prime_func() {
        prime[0] = prime[1] = true;

		for (int i = 2; i <= (int) Math.sqrt(1000000); i++) { 
			for (int j = i * i; j < 1000001; j += i) 
				prime[j] = true;
		}

    }
}