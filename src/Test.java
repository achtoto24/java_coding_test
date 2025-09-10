public class Test {

	public static void main(String[] args) {

		int i = 0;
		long sum = 0;
		while (i<=100) {
			sum += i;
			i++;
		}	

		System.out.println("sum(1~100) : " + sum);
	}
	
}