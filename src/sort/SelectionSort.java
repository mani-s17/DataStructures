package sort;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 7/9/13
 * Time: 10:46 AM
 */
public class SelectionSort
{
	public Comparable[] sort(Comparable[]  array)
	{
		int length = array.length;
		for(int i=0; i<length; i++)
		{
			int min = i;
			for (int j=i+1; j<length; j++)
			{
				if (less(array[j], array[min]))
					min = j;
			}
			exchange(array, i, min);
			display((array));
		}

		return  array;
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

	public boolean isSortedAscending(Comparable[] array)
	{
		for (int i=1; i<array.length; i++)
			if (less(array[i], array[i-1]))
				return false;
		return true;
	}

	public void display(Comparable[] array)
	{
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println("");
	}

	public static void main(String[] args)
	{
		SelectionSort obj = new SelectionSort();
		Integer[] array = new Integer[]{6,3,2,7,8,5,9,1};
		array = (Integer[]) obj.sort(array);
		//obj.display(array);
	}
}
