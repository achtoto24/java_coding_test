import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdln = new Scanner(System.in);
        int subject = stdln.nextInt();
        int[] arr = new int[subject];

        for (int i = 0; i < subject; i++) {
            int score = stdln.nextInt();
            arr[i] = score;
        }

        int max = arr[0];
        for (int i = 1; i < subject; i++) {
            if (max < arr[i])
                max = arr[i];
        }

        float sum = 0f;
        for (float i : arr) {
            i = (i / max) * 100;
            sum += i;
        }
        
        System.out.println(sum / subject);
    }
}