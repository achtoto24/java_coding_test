import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdln = new Scanner(System.in);
        int A = stdln.nextInt();
        int B = stdln.nextInt();
        int V = stdln.nextInt();
        int day = 1;
        int len = 0;

        while (len < V) {
            len += A;
            
            if (len >= V) 
                break;
            
            len -= B;
            day++;
        }

        System.out.println(day);

    }

}