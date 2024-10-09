import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
		Scanner stdln = new Scanner(System.in);
        int cnt = stdln.nextInt();
        int[] xp = new int[cnt];
        int[] yp = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            int x = stdln.nextInt();
            xp[i] = x;
            int y = stdln.nextInt();
            yp[i] = y;
        }

        
        if (cnt == 1) {
            System.out.println(0);
            return;
        }
        
        int max1 = xp[0];
        int min1 = xp[0];
        
        for (int i = 1; i < cnt; i++) {
            if (xp[i] > max1)
            max1 = xp[i];
            if (xp[i] < min1)
            min1 = xp[i];
        }
        
        int max2 = yp[0];
        int min2 = yp[0];

        for (int i = 1; i < cnt; i++) {
            if (yp[i] > max2)
                max2 = yp[i];
            if (yp[i] < min2)
                min2 = yp[i];
        }

        if (max1 == min1 || max2 == min2)
            System.out.println(0);
        else
            System.out.println((max1 - min1) * (max2 - min2));
    }
}