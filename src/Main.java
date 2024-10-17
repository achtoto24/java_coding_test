import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner((System.in));
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) 
            list.add(sc.nextInt());

        Collections.sort(list);

        for (int i : list)
            sb.append(i).append('\n');

        System.out.println(sb);
        
    }

}