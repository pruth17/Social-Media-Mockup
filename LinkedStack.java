// @author Pruthvi Punwar
package supportClasses;
import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> {
private Node topNode;
	
	public LinkedStack()
	{
		topNode = null;
	}
	//adds new node to beginning of stack
	public void push(T item)
	{
		Node newNode = new Node(item, topNode);
		topNode = newNode;
	}//end of push
	
	//if stack is not empty return the data of the top item in the stack. otherwise throw an exception
	public T peek()
	{
		if(!isEmpty())
			return topNode.data;
		else
			throw new EmptyStackException();
	}//end of peek
	
	//if stack is not empty return the data of the top item in the stack and then remove it from the stack. otherwise throw and exception
	public T pop()
	{
		if(!isEmpty())
		{
			T result = topNode.data;
			topNode = topNode.next;
			return result;
		}
		else
			throw new EmptyStackException();
	}//end of pop
	
	public boolean isEmpty()
	{
		return topNode == null;
	}//end of isEmpty
	
	public void clear()
	{
		topNode = null;
	}//end of clear
	private class Node
	{
		private T data;
		private Node next;
		
		private Node(T data)
		{
			this(data, null);
		}
		
		private Node(T data, Node next)
		{
			this.data = data;
			this.next = next;
		}
		
		private T data()//get
		{
			return data;
		}
		
		private Node next()//get
		{
			return next;
		}
		
		private void setData(T data)//set
		{
			this.data = data;
		}
		
		private void setNextNode(Node next)//set
		{
			this.next = next;
		}
	}
}
