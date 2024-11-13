import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test {
    
    // 연산자 우선순위 반환
    public static int getPriority(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>(); // 연산자 스택
        StringBuilder sb = new StringBuilder(); // 결과 문자열
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            switch (currentChar) {
                case '+':
                case '-':
                    // +, - 연산자 처리
                    while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(currentChar)) {
                        sb.append(stack.pop());
                    }
                    stack.push(currentChar);
                    break;
                
                case '*':
                case '/':
                    // *, / 연산자 처리
                    while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(currentChar)) {
                        sb.append(stack.pop());
                    }
                    stack.push(currentChar);
                    break;

                case '(':
                    // 여는 괄호는 스택에 넣음
                    stack.push(currentChar);
                    break;

                case ')':
                    // 닫는 괄호가 나오면 여는 괄호까지 스택에서 꺼내어 출력
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop(); // '(' 제거
                    break;

                default:
                    // 피연산자일 경우 그대로 결과에 추가
                    sb.append(currentChar);
                    break;
            }
        }

        // 남아있는 연산자 처리
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}

 
