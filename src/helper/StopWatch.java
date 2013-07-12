package helper;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 7/12/13
 * Time: 10:53 AM
 */
public class StopWatch
{
	private final long start;

	public StopWatch()
	{
		this.start = System.currentTimeMillis();
	}

	public double elapsedTime()
	{
		long now = System.currentTimeMillis();
		return (now-start)/1000.00;
	}
}
