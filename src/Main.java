
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr, arr2;
    static boolean[] check;

    static int size;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        while (!str.equals("0")) {
            st = new StringTokenizer(str);
            size = Integer.parseInt(st.nextToken());
            arr = new int[size];
            arr2 = new int[6];
            check = new boolean[size];

            
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            dfs(0);
            
            System.out.println(sb);

            sb = new StringBuilder();
            str = br.readLine();
        }
        
    }

    static void dfs(int depth) {

        if (depth == 6) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                if (arr2[i] >= arr2[i+1]) return;
                    sb2.append(arr2[i] + " ");
            }
            sb2.append(arr2[5]);
            sb.append(sb2 + "\n");
            return;
        }

        for (int i = 0; i < size; i++) {
            if (!check[i]) {
                check[i] = true;
                arr2[depth] = arr[i];
                dfs(depth + 1);
                check[i] = false;
            }
        }
        
    }
    
}