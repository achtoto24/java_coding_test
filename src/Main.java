import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdln = new Scanner(System.in);
        
        while (true) {
            int num = stdln.nextInt();

            if (num == -1) 
                break;

            int[] arr = new int[num];
            int cnt = 1;
            int sum = 0;
            int temp = 0;

            while (cnt < num) {
                if (num % cnt == 0) {
                    sum += cnt;
                    arr[temp++] = cnt;
                }
                cnt++;
            }
    
            if (sum == num) {
                System.out.printf("%d = ", num);
                for (int i = 0; i < temp - 1; i++)
                    System.out.printf("%d + ", arr[i]);
                System.out.printf("%d\n", arr[temp - 1]);
            }
            else 
                System.out.printf("%d is NOT perfect.\n", num);
       }

       stdln.close();
    }
}