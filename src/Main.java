import java.util.Scanner;
 
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int side1 = sc.nextInt();
            int side2 = sc.nextInt();
            int side3 = sc.nextInt();
            
            // 입력이 0 0 0인 경우 종료
            if (side1 == 0 && side2 == 0 && side3 == 0) {
                break;
            }
            
            // 가장 긴 변의 길이 구하기
            int maxSide = Math.max(Math.max(side1, side2), side3);
            
            // 삼각형 조건을 만족하는지 확인
            if (maxSide < side1 + side2 + side3 - maxSide) {
                if (side1 == side2 && side2 == side3) {
                    System.out.println("Equilateral");
                } else if (side1 == side2 || side2 == side3 || side1 == side3) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }
            } else {
                System.out.println("Invalid");
            }
        }
    }
    
}


