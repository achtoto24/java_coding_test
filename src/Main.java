import java.util.Scanner;

public class Main{
    public static void main(String[] args){
    
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String N_str = String.valueOf(N);
        int M = 0;
        
        for (int i = N - 9 * N_str.length(); i <= N - N_str.length(); i++) {
            String str = String.valueOf(i);
            
            int sum = i;
            for (int j = 0; j < str.length(); j++) 
                sum += Integer.valueOf(str.charAt(j) - '0');
            
            if (sum == N) {
                M = i;
                break;
            }
        }

        System.out.println(M);
    }
}