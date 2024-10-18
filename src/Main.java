import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[] str = new String[N];
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            str[i] = bf.readLine();
        }

        Arrays.sort(str);

        for (String i : str)
            System.out.println(i);

    }
}
