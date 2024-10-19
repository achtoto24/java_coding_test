import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] str = new String[N];
        
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < N; i++) {
            str[i] = sc.next();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (str[i].length() > str[j].length()) {
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }

        

        for (String i : str)
            System.out.println(i);

        

    }
}