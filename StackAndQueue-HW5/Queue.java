public class Queue<V> {

    /**
    * Constructor to initialize the queue with a maximum capacity of maxSize.
    */
    @SuppressWarnings("unchecked")
    public Queue(int maxSize) {
    }

    /**
        Returns the maximum size this queue can support.
    */
    public int getMaxSize() {
    	return 0;
    }

     /**
        Returns the current number of items enqueued.
    */
    public int getCurrentSize() {
    	return 0;
    }

    /**
        Returns true if there are no elements in the queue.
    */
    public boolean isEmpty() {
    	return true;
    }

    /**
        Returns true if the queue is size is at max size.
    */
    public boolean isFull() {
    	return true;
    }

    /**
        Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
    */
    public V peek() {
    	return null;
    }
    
   /**
        Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
    */
    public void add(V value) {
    	
    }

    /**
        Retrieves and removes the head of this queue, or returns null if this queue is empty.
    */
    public V poll() {
    	return null;
    }
    
    /**
        Retrieves and removes the head of this queue.
    */
     public V remove() {
    	 return null;
    }
    
}