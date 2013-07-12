package coursera.week1;

import java.io.InputStream;
import helper.InputReader;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 7/10/13
 * Time: 7:01 PM
 */
public class CountInversionBruteForce
{
	public long countInversion(Comparable[] array)
	{
		long count = 0;
		for (int i=0; i<array.length; i++)
			for (int j=i+1; j<array.length; j++)
				if (array[j].compareTo(array[i])<0)
					count++;
		return count;
	}

	public static void main(String[] args)
	{
		InputStream inputStream = CountInversionBruteForce.class.getResourceAsStream("IntegerArray.txt");
		InputReader in = new InputReader(inputStream);

		//int[] array = new int[]{6,5,4,3,2,1};
		int[] array = new int[100000];
		for (int i=0; i<100000; i++)
		{
			array[i] = in.nextInt();
		}

		//System.out.println(countInversion(array));
	}
}