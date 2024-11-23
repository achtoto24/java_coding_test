import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 요세푸스 문제 
 * 순환 문제일 경우 queue를 이용하여 뺴고 다시 넣는 과정을 반복하는 아이디어를 고려
 */
public class Main {

    public static boolean[] prime;
    public static void main(String[] args) throws IOException {

        Queue<Integer> que = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        
        for (int i = 1; i <= N; i++)
            que.offer(i);

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        while (que.size() != 1) {
            for (int i = 0; i < K - 1; i++) 
                que.offer(que.poll());
            
            sb.append(que.poll()).append(", ");
        }

        sb.append(que.poll()).append('>');

        System.out.println(sb);
        
    }
}