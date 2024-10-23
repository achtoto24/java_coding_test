import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer bf = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" "); 
        
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++)
            set.add(Integer.parseInt(input1[i]));
  
        int M = Integer.parseInt(br.readLine());

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(input2[i]);
            if (set.contains(temp))
                bf.append(1).append(" ");
            else
                bf.append(0).append(" ");
        }
        
        System.out.println(bf);

    }
}