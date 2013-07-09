package sort;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 7/9/13
 * Time: 11:51 AM
 */
public class InsertionSort
{
	public void sort(Comparable[] array)
	{
		int count = 0;
		int length = array.length;
		for (int i=1; i<length; i++)
		{
			for(int j=i; j>0 && less(array[j], array[j-1]); j--)
			{
				exchange(array, j, length-1);
				exchange(array, j , j-1);
				display(array);
				count++;
			}
		}
		System.out.println("Passes - " + count);
	}

	public boolean less(Comparable a, Comparable b)
	{
		return a.compareTo(b) < 0;
	}

	public void exchange(Comparable[] array, int i, int j)
	{
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void display(Comparable[] array)
	{
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println("");
	}

	public static void main(String[] args)
	{
		InsertionSort obj = new InsertionSort();
		Integer[] array = new Integer[]{6,3,2,7,8,5,9,1};
		obj.sort(array);
	}
}
