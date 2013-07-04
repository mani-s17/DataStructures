package stack;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 7/4/13
 * Time: 12:21 PM
 */
public class StackUsingLinkedList<T> implements Iterable<T>
{
	private Node first;
	private int size;

	private class Node
	{
		T item;
		Node next;
	}

	public void push(T item)
	{
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		size++;
	}

	public T pop()
	{
		T item = first.item;
		first = first.next;
		size--;
		return item;
	}

	public boolean isempty()
	{
		return first == null;
	}

	public int size()
	{
		return size;
	}

	@Override
	public Iterator<T> iterator()
	{
		return new ReverseLinkedListIterator();
	}

	private class ReverseLinkedListIterator implements Iterator<T>
	{
		Node current = first;

		@Override
		public boolean hasNext()
		{
			return current!=null;
		}

		@Override
		public T next()
		{
			T item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}

	public static void main(String[] args)
	{
		StackUsingLinkedList obj = new StackUsingLinkedList();
		System.out.println(obj.isempty());
		System.out.println(obj.size());
		obj.push(10);
		obj.push("ast");
		obj.push("a1st");
		obj.push("a2st");

		for (Object o : obj)
		{
			System.out.println(o.toString());
		}

		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
	}
}
