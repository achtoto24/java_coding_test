import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdln = new Scanner(System.in);
        int A = stdln.nextInt();
        int B = stdln.nextInt();
        int V = stdln.nextInt();

        int day = (V - B) / (A - B);    // A - B를 한 세트로 생각하기, V까지 올라가기만 하면 되므로 B를 제외시키기
        
        if  (((V - B) % (A - B)) != 0)  // 총 길이가 세트로 나누어 떨어지지 않을 경우 하루를 더 추가해서 올라가야 함
            day++;

        System.out.println(day);

    }

}