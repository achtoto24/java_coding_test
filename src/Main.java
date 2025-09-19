import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[] arr;
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new char[N];
        
        arr = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                int idx = Math.max(i - K, 0);
                boolean check = false;

                // 'P' 왼쪽 탐색
                for (int j = idx; j < i; j++) {
                    if (burgerCheck(j)) {
                        check = true;
                        // System.out.println(j);
                        break;
                    }
                }
                
                // 'P' 오른쪽 탐색
                if (!check) {
                    idx = i+K >= N ? N-1 : i+K;
                    for (int j = i + 1; j <= idx; j++) {
                        if (burgerCheck(j))  {
                            // System.out.println(j);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    static boolean burgerCheck(int idx) {
        if (arr[idx] == 'H') {
            arr[idx] = 'X';
            cnt++;
            return true;
        }
        return false;
    }

}