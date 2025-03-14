import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());        
        int M = Integer.parseInt(st.nextToken());        
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int result = binary_Search(M);
        
        System.out.println(result);
    }

    static int binary_Search(int key) {

        int li = 0;
        int ri = arr.length;
        int len_total = 0;
        int result = 0;

        while (li < ri) {
            System.out.printf("li : %d, ri : %d\n", li, ri);
            int mid = (li + ri) / 2;
            // System.out.println("mid : " + mid);
            
            len_total = 0;
            for (int i = mid; i < arr.length; i++) {
                len_total += arr[i] - arr[mid];
            }
            System.out.println(len_total);

            if (len_total <= key) ri = mid;
            else li = mid + 1;
        }
        
        if (len_total == key) {
            result = arr[li];
            return result;
        } else {
            for (int i = arr[li - 1] + 1; i < arr[ri]; i++) {
                len_total = 0;
                for (int j = li; j < arr.length; j++) {
                    len_total += arr[j] - i;
                }
                // System.out.println(len_total);
                if (len_total == key) {
                    result = i;
                    break;
                }
            }

            return result;
        }
    }


    
    
}