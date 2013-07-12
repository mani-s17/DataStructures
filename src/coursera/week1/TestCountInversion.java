package coursera.week1;

import java.io.InputStream;

import helper.InputReader;
import helper.StopWatch;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 7/12/13
 * Time: 10:52 AM
 */
public class TestCountInversion
{
	public static void main(String[] args)
	{
		Integer[] array = readInput();

		// BruteForce
		CountInversionBruteForce obj1 = new CountInversionBruteForce();
		StopWatch sw = new StopWatch();
		System.out.println(" Count - " + obj1.countInversion(array) + " Time taken - " + sw.elapsedTime());

		// Merge Sort - TopDown Approach
		CountInversionDivideAndConquer obj2 = new CountInversionDivideAndConquer();
		sw = new StopWatch();
		System.out.println(" Count - " + obj2.countInversion(array) + " Time taken - " + sw.elapsedTime());
	}

	private static Integer[] readInput()
	{
		InputStream inputStream = CountInversionBruteForce.class.getResourceAsStream("IntegerArray.txt");
		InputReader in = new InputReader(inputStream);
		Integer[] array = new Integer[100000];
		for (int i=0; i<100000; i++)
		{
			array[i] = in.nextInt();
		}
		return array;
	}

	private static Integer[] readInput(long capacity)
	{
		Integer[] array = new Integer[(int) capacity];
		for(int i=0; i<capacity; i++)
		{
			array[i] = (int)capacity-i;
		}
		System.out.println("Actual Inversion - " + (capacity*(capacity-1))/2);
		return array;
	}
}
