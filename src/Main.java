import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 스택의 기본 설명
 */
public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(s);

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        int cursor = s.length();

        while (M > 0) {
            String str = br.readLine();
            
            switch (str) {
                case "L":
                    if (cursor == 0)
                        break;
                    else {
                        cursor--;
                        break;
                    }

                case "D":
                    if (cursor == sb.length())
                        break;
                    else {
                        cursor++;
                        break;
                    }

                case "B":
                    if (cursor != 0) {
                        for (int i = 0; )
                    }
                    break;

                default :

                    break;
            }
            M--;
        }

    }

}