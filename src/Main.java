import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 스택을 이용한 풀이
/*
 * 왼쪽 스택과 오른쪽 스택을 준비하고 두 스택 가운데를 커서라고 가정함
 * 만약 커서가 왼쪽으로 움직이면 왼쪽 스택 top 요소는 오른쪽 스택으로 옮겨짐
 * 이런식으로 에디터 조건을 구현
 * 결론적으로 오른쪽 스택에 전부 요소를 넣어 pop을 하면 원하는 문자열이 출력됨! 
 * 솔직히 처음 이 아이디어를 떠올리기 어려웠음...
 */
public class Main {
    
    static Stack<Character> leftStr;
    static Stack<Character> rightStr;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        leftStr = new Stack<>();
        rightStr = new Stack<>();
        for (int i = 0; i < str.length(); i++)
            leftStr.push(str.charAt(i));

        int N = Integer.parseInt(br.readLine());

        while (N > 0) {
            String op = br.readLine();

            switch (op.charAt(0)) {
                case 'L':
                    if (!leftStr.isEmpty())
                        rightStr.push(leftStr.pop());

                    break;
            
                case 'D':
                    if (!rightStr.isEmpty())
                        leftStr.push(rightStr.pop());

                    break;

                case 'B':
                    if (!leftStr.isEmpty())
                        leftStr.pop();

                    break;

                case 'P':
                    char c = op.charAt(2);
                    leftStr.push(c);
                    break;
            }
            N--;
        }

        while (!leftStr.isEmpty()) 
            rightStr.push(leftStr.pop());
        
        StringBuilder sb = new StringBuilder();
        while (!rightStr.isEmpty()) 
            sb.append(rightStr.pop());
        

        System.out.println(sb);

    }
}