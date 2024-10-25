import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

// 이분 탐색(Binary Search)
public class Main {

    public static int[] arr;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (binarySearch(Integer.parseInt(stk.nextToken())) >= 0)
                sb.append(1).append('\n');
            else
                sb.append(0).append('\n');
        }

        System.out.println(sb);

    }

    public static int binarySearch(int key) {

        int first_index = 0;                 // 탐색 범위의 왼쪽 끝 인덱스
        int last_index = arr.length - 1;    // 탐색 범위의 오른쪽 끝 인덱스

        while (first_index <= last_index) {
            int middle_index = (first_index + last_index) / 2;
            
            if (key < arr[middle_index])
                last_index = middle_index - 1;
            
            else if (key > arr[middle_index])
                first_index = middle_index + 1;
            
            else
                return middle_index;
        }

        return -1;
    }
}