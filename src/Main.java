import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

// HashMap을 이용하여 요소와 rank값 매칭하기
// Arrays.sort() 이용하여 요소 정렬 후 차례대로 rank 매기기

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];
        int[] arr_sort = new int[N];
        HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < N; i++) 
            arr[i] = arr_sort[i] = sc.nextInt();        

        Arrays.sort(arr_sort);

        int rank = 0;

        for (int i : arr_sort) {
            if (!rankMap.containsKey(i)) {
                rankMap.put(i, rank);
                rank++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i : arr) 
            sb.append(rankMap.get(i)).append(' ');
        
        System.out.println(sb);

    }
}