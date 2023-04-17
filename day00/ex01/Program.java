import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		if (number < 2) {
			System.err.println("IllegalArgument");
			System.exit(-1);
		}
		int div = 0;
		int i = 1;
		for (; i <= number; i++) {
			if (number % i == 0)
				div++;
			if (div > 2) {
				System.out.println("false " + (i - 1));
				System.exit(0);
			}
		}
		System.out.println("true " + (i - 1));
		System.exit(0);
	}
}
