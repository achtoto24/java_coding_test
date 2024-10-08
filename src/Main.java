import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner stdln = new Scanner(System.in);
        int len = stdln.nextInt();

        System.out.println(len + len * 3);
    }
}