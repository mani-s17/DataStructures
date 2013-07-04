package linkedlist;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 7/4/13
 * Time: 3:31 PM
 */
public class LinkedList<T> implements Iterable<T>
{
	private Node first, last;
	private int size;

	private class Node
	{

		T item;
		Node next;
	}

	public void addAtEnd(T item)
	{
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty())
			first = last;
		else
			oldLast.next = last;
		size++;
	}

	public void addAtBegining(T item)
	{
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		size++;
	}

	public T removeLastNode()
	{
		T item = last.item;
		Node current = first;
		while(current.next != last)
		{
			current = current.next;
		}
		current.next = null;
		size--;
		return item;
	}

	public T removeFirstNode()
	{
		T item = first.item;
		first = first.next;
		size--;
		return item;
	}

	public void reverse(LinkedList list)
	{
		Node first = list.first;
		Node reverse = null;
		while (first!=null)
		{
			Node second = first.next;
			first.next = reverse;
			reverse = first;
			first = second;
		}

		Node current = reverse;
		System.out.println();
		while (current != null)
		{
			System.out.print(current.item + " -> ");
			current = current.next;
		}
	}

	public boolean isEmpty()
	{
		return first == null;
	}

	@Override
	public Iterator<T> iterator()
	{
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<T>
	{
		Node current = first;

		@Override
		public boolean hasNext()
		{
			return current != null;
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
		LinkedList<Integer> obj = new LinkedList<Integer>();
		obj.addAtEnd(1);
		obj.addAtEnd(2);
		obj.addAtBegining(11);
		obj.addAtEnd(3);
		obj.addAtEnd(4);
		obj.removeLastNode();
		obj.removeFirstNode();

		for (Integer i : obj)
		{
			System.out.print(i + " -> ");
		}

		obj.reverse(obj);
	}
}
