/**
 * Class imitating the "queue" data structure (first in first out)
 * @author Andrew Krause
 * @version 1.0
 *
 */
public class Queue<V> {

	private V[] queue;
	private int head, tail;
	private boolean empty;
	
    /**
    * Constructor to initialize the queue with a maximum capacity of maxSize.
    */
    @SuppressWarnings("unchecked")
    public Queue(int maxSize) {
    	queue = (V[]) new Object[maxSize];
    	empty = true;
    	head = 0;
    	tail = 0;
    }

    /**
        Returns the maximum size this queue can support.
    */
    public int getMaxSize() {
    	return queue.length;
    }

     /**
        Returns the current number of items enqueued.
    */
    public int getCurrentSize() {
    	if(isEmpty())
    		return 0;
    	int temp = tail - head;
    	if(temp < 0)
    		temp += getMaxSize() - 1;
    	return (temp % getMaxSize()) + 1;
    }

    /**
        Returns true if there are no elements in the queue.
    */
    public boolean isEmpty() {
    	return empty;
    }

    /**
        Returns true if the queue is size is at max size.
    */
    public boolean isFull() {
    	return getCurrentSize() == getMaxSize();
    }

    /**
        Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
    */
    public V peek() {
    	if(isEmpty())
    		return null;
    	return queue[head];
    }
    
   /**
        Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
    */
    public void add(V value) {
    	if(isFull())
    		throw new IndexOutOfBoundsException();
    	if(isEmpty())
    	{
    		empty = false;
    		tail--;
    	}
    	tail++;
    	if(tail == getMaxSize())
    		tail = 0;
    	queue[tail] = value;
    }

    /**
        Retrieves and removes the head of this queue, or returns null if this queue is empty.
    */
    public V pull() {
    	if (isEmpty())
    		return null;
    	return remove();
    }
    
    /**
        Retrieves and removes the head of this queue.
    */
     public V remove() {
    	 if(isEmpty())
    		 throw new IndexOutOfBoundsException();
    	 V answer = queue[head];
    	 if(head == tail)
    	 {
    		 empty = true;
    		 head--;
    	 }
    	 head++;
    	 if(head == getMaxSize())
    		 head = 0;
    	 return answer;
     }
    
}