import java.util.Scanner;
 
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int side1 = sc.nextInt();
        int side2 = sc.nextInt();
        int side3 = sc.nextInt();
        
        // 가장 긴 변의 길이 구하기
        int maxSide = Math.max(Math.max(side1, side2), side3);
        
        // 삼각형 조건을 만족하는지 확인
        if (maxSide < side1 + side2 + side3 - maxSide) {
            System.out.println(side1 + side2 + side3);
            }
        else {
            int sum = side1 + side2 + side3 - maxSide;
            System.out.println(2 * sum - 1);
        }
        
    }
    
}


