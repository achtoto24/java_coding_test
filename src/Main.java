import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++)
            list.add(Integer.parseInt(st.nextToken()));
        
        Collections.sort(list);

        int M = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] cnt = new int[M];
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(stk.nextToken());
            int idx = list.indexOf(num);
            // System.out.println(idx);
            if (idx >= 0) {
                int count = 0;
                while (list.get(idx) == num) {
                    count++;
                    if (idx == N - 1)
                        break;
                    idx++;
                }
                cnt[i] = count;
            }
            else 
                cnt[i] = 0;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i : cnt)
            sb.append(i).append(" ");

        System.out.println(sb);

    }
}