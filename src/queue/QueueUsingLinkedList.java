package queue;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 7/4/13
 * Time: 1:07 PM
 */
public class QueueUsingLinkedList<T>
{
	private Node first, last;
	private int size;

	private class Node
	{
		T item;
		Node next;
	}

	public void enQueue(T item)
	{
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty())
			first = last;
		else
			oldLast.next = last;
		size++;
	}

	public T deQueue()
	{
		T item = first.item;
		first = first.next;
		if (isEmpty())
			last = null;
		size--;
		return item;
	}

	public boolean isEmpty()
	{
		return first == null;
	}

	public int size()
	{
		return size;
	}
}
