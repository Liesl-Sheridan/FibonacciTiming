package FibonacciAssignment;

public class FibonacciTiming {

	public static int recursionCalc(int n) {
		if (n <= 1) {
			return n;
		} else
			return recursionCalc(n - 1) + recursionCalc(n - 2);
	}

	public static int iterativeCalc(int n) {
		int secondNum = 1;
		int firstNum = 1;
		
		
		if (n <= 1) {
			return n;
		}

		for (int i = 2; i < n; i++) {
			int tempNum = secondNum;
			secondNum += firstNum;
			firstNum = tempNum;
		}
		return secondNum;

	}

	public static void main(String[] args) {

		long startTime = System.nanoTime();
		long endTime = System.nanoTime();
		
		System.out.println("For recursion: ");
		
		for(int i = 0; i < 20; i++) {
            startTime = System.nanoTime();
            int result = FibonacciTiming.recursionCalc(i);
            endTime = System.nanoTime();
            System.out.println(result + " took " + (endTime - startTime) + " nanoseconds");
            //System.out.format("%d\t\tused\t%d\tns\n", result, (endTime - startTime));
        }
		
		System.out.println();
		System.out.println("For iterative: ");
		
		for(int i = 0; i < 20; i++) {
            startTime = System.nanoTime();
            int result = FibonacciTiming.iterativeCalc(i);
            endTime = System.nanoTime();
            System.out.println(result + " took " + (endTime - startTime) + " nanoseconds");
            //System.out.format("%d\t\tused\t%d\tns\n", result, (endTime - startTime));
        }
		
	}

}
