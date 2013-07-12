package coursera.week1;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 7/11/13
 * Time: 11:31 AM
 */
public class CountInversionDivideAndConquer
{
	Comparable[] temp;
	long count;

	public long countInversion(Comparable[] array)
	{
		mergeSort(array);
		return count;
	}

	public void mergeSort(Comparable[] array)
	{
		temp = new Comparable[array.length];
		split(array, 0, array.length - 1);
	}

	private void split(Comparable[] array, int low, int high)
	{
		// Base case
		if(high<=low)
			return;
		int mid = low + (high-low)/2;
		split(array, low, mid);
		split(array, mid+1, high);
		merge(array, low, mid, high);
	}

	private void merge(Comparable[] array, int low, int mid, int high)
	{
		int i=low;
		int j= mid+1;

		for (int k=low; k<=high; k++)
		{
			temp[k] = array[k];
		}

		if (less(temp[mid+1], temp[mid]))			// Performance Improvement
		{
			for (int k=low; k<=high; k++)
			{
				if (j>high)
					array[k] = temp[i++];			// If right side split array is exhausted then copy from left array
				else if(i>mid)
					array[k] = temp[j++];			// If left side split array is exhausted then copy from right array
				else if (less(temp[j], temp[i]))
				{
					// if j is less than any entry in left array then the entries followed in the left array will surely be greater than j
					// Counting split inversion - mid+1 will give right array start index and i will give current index,
					// by subtracting both will give remaining entry left in left array
					count = count + (mid+1 - i);
					array[k] = temp[j++];			// If right side split array is less then left array entry then copy from left array
				}
				else if (less(temp[i], temp[j]))
					array[k] = temp[i++];			// If left side split array is less then right array entry then copy from right array
			}
		}
	}

	private boolean less(Comparable a, Comparable b)
	{
		return a.compareTo(b) < 0;
	}

	private void printArray(Comparable[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

	public void sort(Comparable[] a)
	{ // Do lg N passes of pairwise merges.
		int N = a.length;
		for (int sz = 1; sz < N; sz = sz+sz)  // sz: subarray size
			for (int lo = 0; lo < N-sz; lo += sz+sz) // lo: subarray index
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
	}

	public static void main(String[] args)
	{
		Integer[] array = new Integer[]{6,5,4,3,2,1};
		CountInversionDivideAndConquer obj = new CountInversionDivideAndConquer();
		obj.printArray(array);
		obj.sort(array);
		obj.printArray(array);
	}
}
