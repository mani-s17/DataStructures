package sort;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 7/12/13
 * Time: 8:58 PM
 */
public class MergeSort
{
	Comparable[] temp;

	public void topDownsort(Comparable[] array)
	{
		temp = new Comparable[array.length];
		printArray(array);
		split(array, 0, array.length-1);
		printArray(array);
	}

	public void bottomUpSort(Comparable[] array)
	{
		int length = array.length;
		temp = new Comparable[array.length];

		for(int sz=1; sz<array.length; sz=sz+sz)
			for(int low=0; low<length-sz; low += sz )
				merge(array, low, low+sz-1, Math.min(low+sz+sz-1, length-1));
	}

	private void split(Comparable[] array, int low, int high)
	{
		// Base Case
		if(high<=low)
			return;
		int mid = low + (high-low)/2;
		split(array, low, mid);
		split(array, mid+1, high);
		merge(array, low, mid, high);
	}

	private void merge(Comparable[] array, int low, int mid, int high)
	{
		int i = low;
		int j = mid+1;

		for (int k=low; k<=high; k++)
			temp[k] = array[k];

		for (int k=low; k<=high; k++)
		{
			if(j>high)
				array[k] = temp[i++];
			else if (i>mid)
				array[k] = temp[j++];
			else if (less(temp[j], temp[i]))
				array[k] = temp[j++];
			else if (less(temp[i], temp[j]))
				array[k] = temp[i++];
		}
	}

	private boolean less(Comparable a, Comparable b)
	{
		return a.compareTo(b)<0;
	}

	private void printArray(Comparable[] array)
	{
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println("");
	}

	public static void main(String[] args)
	{
		MergeSort obj = new MergeSort();
		Integer[] array = new Integer[]{6,4,5,2,3,1};
		obj.topDownsort(array);
	}
}
