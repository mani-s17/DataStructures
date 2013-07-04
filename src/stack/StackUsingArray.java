package stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 4/3/13
 * Time: 4:55 PM
 */
public class StackUsingArray<T> implements Iterable<T>
{
	private T[] stack;
	private int top = 0;

	public StackUsingArray()
	{
		stack = (T[]) new Object[2];
	}

	public StackUsingArray(int size)
	{
		stack = (T[]) new Object[size];
	}

	public void push(T value)
	{
		if(top == stack.length)
			resizeStack(stack.length * 2);
		stack[top++] = value;
	}

	public T pop()
	{
		T value = stack[--top];
		stack[top] = null;
		if(top > 0 && top < (stack.length/4))
			resizeStack(stack.length/2);
		return value;
	}

	private void resizeStack(int size)
	{
		T[] tempStack = (T[]) new Object[size];
		for(int i=0; i<stack.length; i++)
			tempStack[i] = stack[i];
		stack = tempStack;
	}

	public T[] getStack()
	{
		return stack;
	}

	@Override
	public Iterator<T> iterator()
	{
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<T>
	{

		@Override
		public boolean hasNext()
		{
			return top > 0;
		}
		@Override
		public T next()
		{
			return stack[--top];
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}

	}

	public static void main(String[] args)
	{
		StackUsingArray<Integer> obj = new StackUsingArray<Integer>();
		obj.push(10);
		obj.push(50);
		obj.push(45);

		//for(Integer i : obj)
		{
			//System.out.println(i);
		}

		Iterator ite = obj.iterator();
		while (ite.hasNext())
		{
			System.out.println(ite.next());
		}
	}
}
