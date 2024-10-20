import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[][] arr = new String[N][2];

        sc.nextLine(); // 개행 버림

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.next();
            arr[i][1] = sc.next();
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            public int compare(String[] s1, String[] s2) {

                int num1 = Integer.parseInt(s1[0]);
                int num2 = Integer.parseInt(s2[0]);

                if (num1 != num2) 
                    return Integer.compare(num1, num2);
                else
                    return 0;

            }
        });

        for (int i = 0; i < N; i++) 
            System.out.println(arr[i][0] + " " + arr[i][1]);
        
    }
}