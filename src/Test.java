public class Test {

	public static void main(String[] args) {

		int n = (int)(11 * Math.random());
		System.out.println("random number : " + n);

		if (n <= 5) {
			System.out.println("n : " + n);
			System.out.println("n*n : " + n*n);
		}

		System.out.println();
		System.out.println("end");
		
	}
}