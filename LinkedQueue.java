// @author Pruthvi Punwar
package supportClasses;
/**
 * 
 *
 */
public final class LinkedQueue<T> implements QueueInterface<T> {

	private Node firstNode;
	private Node lastNode;
	
	public LinkedQueue()
	{
		firstNode = lastNode = null;
	}
	
	public void enqueue(T newEntry) {
		Node newNode = new Node(newEntry, null);
		if(isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode = newNode;
	}//end enqueue

	public T dequeue() {
		if(isEmpty())
			throw new EmptyQueueException();
		else
		{
			T result = getFront();
			firstNode = firstNode.next;
			if(firstNode == null)
				lastNode = null;
			return result;
		}
	}//end dequeue

	public T getFront() {
		if(isEmpty())
			throw new EmptyQueueException();
		else
			return firstNode.data;
	}//end getFront

	public boolean isEmpty() {
		if(firstNode == null && lastNode == null)
			return true;
		return false;
	}//end isEmpty

	public void clear() {
		firstNode = lastNode = null;
	}//end clear

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
