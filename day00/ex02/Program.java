import java.util.Scanner;

public class Program {
	static int sumNumber(int value) {
		int tmp = 0;
		while (value != 0) {
			tmp += value % 10;
			value = value / 10;
		}
		return tmp;
	}

	static boolean isPrime(int value) {
		if (value < 2)
			return false;
		int div = 0;
		int i = 1;
		for (; i <= value; i++) {
			if (value % i == 0)
				div++;
			if (div > 2)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int coffeRequests = 0;
		while (true) {
			int number = Integer.parseInt(scanner.nextLine());
			if (number < 2) {
				System.err.println("IllegalArgument");
				System.exit(-1);
			}
			if (number == 42)
				break;
			if (isPrime(sumNumber(number)))
				coffeRequests++;
		}
		System.out.println("Count of coffee - request - " + coffeRequests);
		System.exit(0);
	}
}
