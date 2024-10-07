import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner stdln = new Scanner(System.in);
        int x = stdln.nextInt();
        int y = stdln.nextInt();
        int w = stdln.nextInt();
        int h = stdln.nextInt();
        int[] arr = new int[4];

        arr[0] = x;
        arr[1] = w - x;
        arr[2] = y;
        arr[3] = h - y;

        int min = arr[0];
        for (int i = 1; i < 4; i++) {
            if (arr[i] < min)
                min = arr[i];
        }

        System.out.println(min);
    }
}