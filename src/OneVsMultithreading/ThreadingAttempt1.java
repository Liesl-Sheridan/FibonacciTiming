package OneVsMultithreading;

import java.util.Arrays;
import java.util.Random;

//this creates a new thread
class SingleThread extends Thread { 
	
	//run() must be included when creating threads
	public void run() {
		
		//create an array of 200,000,000 elements
		int[] jumboNumber = new int[200000000]; 
		
		//call for an instance of the Random class
		Random generateRandomNum = new Random();
		long total = 0;
		long startTime;
		long endTime;
		
		startTime = System.currentTimeMillis();
		
		//fill the array with random numbers using 
		//nextInt(bound of 10 elements that are 0-9) + 1 to make it 1-10
		for(int i = 0; i < jumboNumber.length; i++) {
			jumboNumber[i] = generateRandomNum.nextInt(10) + 1;
			total += jumboNumber[i];
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("The total of 200,000,000 random numbers between 1 and 10 is " + total);
		System.out.println("This took " + (endTime - startTime) + " milliseconds to calculate");
		
	}
	
}


class MultiThread1 extends Thread {
	

	private int[] jumboNumberMulti1 = new int[10]; 
	
	public void run() {
		//int[] jumboNumberMulti1 = new int[10]; 
		int total = 0;
		
		Random generateRandomNumMulti1 = new Random();
		
		for(int i = 0; i < jumboNumberMulti1.length; i++) {
			jumboNumberMulti1[i] = generateRandomNumMulti1.nextInt(10) + 1;
			total += jumboNumberMulti1[i];
		}
		System.out.println(total);
	}
	
	/*public int[] getMulti1Array() {
		return Arrays.copyOf(jumboNumberMulti1, jumboNumberMulti1.length);
	}*/
	
}

class MultiThread2 extends Thread {
	
	public void run() {
		int[] jumboNumberMulti2 = new int[10]; 
		Random generateRandomNum = new Random();
		
		for(int i = 0; i < jumboNumberMulti2.length; i++) {
			jumboNumberMulti2[i] = generateRandomNum.nextInt(10) + 1;
		}
		
		
	}
	
}


public class ThreadingAttempt1 {

	public static void main(String[] args) {
		
		SingleThread single = new SingleThread();
		MultiThread1 multi1 = new MultiThread1();
		//int total = 0;
		
		single.start();
		
		multi1.start();
		/*int[] firstArray = multi1.getMulti1Array();
		for (int element: firstArray) {
			total += firstArray[element];
            System.out.println(element);
        }*/
		
		/* is it possible to create the array here 
		 * and then use threads to add them together? */

	}

}
