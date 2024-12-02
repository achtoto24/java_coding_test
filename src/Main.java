import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
 * 59를 예로 들어보자. -> 59! = 59 * 58 * 57 * ... * 1;
 * 59!의 0의 개수는 2 * 5의 조합의 개수 이므로 2와 5의 소인수의 개수를 구해 구하면 된다.
 * 소인수 개수에서 2의 개수는 5의 개수보다 항상 많다. 
 * 따라서 5의 개수를 구하면 된다.
 * -> 59 / 5 = 11, 11 / 5 = 2 (두번 나눠주는 이유는 5*5나 5*5*2와 같이 5가 두 번 이상 곱해진 수가 있기 때문)
 */
public class Main {
        
    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            int count = 0;
            while (N >= 5) {
                count += N / 5;
                N /= 5;
            }    
            
            System.out.println(count);
    }

}