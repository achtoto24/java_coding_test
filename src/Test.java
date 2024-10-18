import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr_x = new int[N];
        int[] arr_y = new int[N];

        for (int i = 0; i < N; i++) {
            String[] input = bf.readLine().split(" ");
            arr_x[i] = Integer.parseInt(input[0]);
            arr_y[i] = Integer.parseInt(input[1]);
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr_x[i] > arr_x[j]) {
                    int temp1 = arr_x[i];
                    arr_x[i] = arr_x[j];
                    arr_x[j] = temp1;
                    int temp2 = arr_y[i];
                    arr_y[i] = arr_y[j];
                    arr_y[j] = temp2;
                }
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr_x[i] == arr_x[j] && arr_y[i] > arr_y[j]) {
                    int temp = arr_y[i];
                    arr_y[i] = arr_y[j];
                    arr_y[j] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) 
            System.out.println(arr_x[i] + " " + arr_y[i]);
        

    }
}
