import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            if (binarySearch(Integer.parseInt(st.nextToken())) != -1) System.out.println(1);
            else System.out.println(0);
        }
        
    }

    public static int binarySearch(int key) {
        int li = 0;
        int ri = arr.length - 1;

        while (li <= ri) {
            int mid = (li + ri) / 2;

            if (key < arr[mid]) ri = mid - 1;
            else if (key > arr[mid]) li = mid + 1;
            else return mid;
        }

        return -1;

    }
    

}