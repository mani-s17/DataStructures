package search;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 7/8/13
 * Time: 12:10 PM
 */
public class BinarySearch
{
	public int search(int[] sortedArray, int item)
	{
		int low = 0;
		int high = sortedArray.length-1;
		while(low<=high)
		{
			int mid = low + (high-low)/2;
			if(item<sortedArray[mid])
				high = mid-1;
			else if (item>sortedArray[mid])
				low = mid+1;
			else
				return mid;
		}
		return -1;
	}

	public static void main(String[] args)
	{
		BinarySearch obj = new BinarySearch();
		System.out.println(obj.search(new int[] {1,2,5,7,8,9}, 9));
	}
}
