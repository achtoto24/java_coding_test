import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int order = sc.nextInt();
        int num = 666;
        int cnt = 0;

        while (true) {
            String num_str = String.valueOf(num);
            if (num_str.contains("666")) {
                if (++cnt == order) {
                    System.out.println(num);
                    break;
                }
            }
            num++;
        }


    }
}