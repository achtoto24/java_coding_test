import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int[] deq = new int[10001];
    static int first = 0;
    static int last = 0;
    static int size = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            
            switch(S) {
                case "push_front" :
                    push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    sb.append(pop_front()).append('\n');
                    break;
                case "pop_back" :
                    sb.append(pop_back()).append('\n');
                    break;
                case "size" : 
                    sb.append(size()).append('\n');
                    break;
                case "empty" :
                    sb.append(empty()).append('\n');
                    break;
                case "front" :
                    sb.append(front()).append('\n');
                    break;
                case "back" :
                    sb.append(back()).append('\n');
                    break;              
            }
        }

        System.out.println(sb);

    }

    public static void push_front(int X) {
        deq[first] = X;
        first = ((first - 1) + 10001) % 10001;  // first가 앞으로 당겨지므로 -1, 순환을 위해서 +10001을 하고 %10001을 함
        size++;
    }

    public static void push_back(int X) {
        last = (last + 1) % 10001;  // last가 뒤로 밀려나므로 +1, 순환을 위해서 %10001을 함
        deq[last] = X;
        size++;
    }

    public static int pop_front() {
        if (size == 0) return -1;
        else {
            first = (first + 1) % 10001;
            int PF = deq[first];
            size--;
            return PF;
        }
    }

    public static int pop_back() {
        if (size == 0) return -1;
        else {
            int PB = deq[last];
            last = ((last - 1) + 10001) % 10001;
            size--;
            return PB;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) return 1;
        else return 0;
    }

    public static int front() {
        if (size == 0) return -1;
        else {
            int F = deq[(first + 1) % 10001];   // first 값이 덱의 앞을 가리키고 있지만, 이 값은 실제로 덱의 첫 번째 요소보다 한 칸 뒤에 위치하고 있음
            return F;
        }
    }

    public static int back() {
        if (size == 0) return -1;
        else {
            int B = deq[last];
            return B;
        }
    }

}

 
