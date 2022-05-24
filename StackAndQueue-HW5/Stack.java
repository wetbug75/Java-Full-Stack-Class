/**
 * Class imitating the "stack" data structure (first in last out)
 * @author Andrew Krause
 * @version 1.1
 * 
 */
public class Stack<V>
{
	private V[] stack; //stores the items added to the stack
	private int stackTopIndex; //keeps track of the top of the stack
	
    /**
        Constructor to initialize the stack with a maximum capacity of maxSize.
    */
    @SuppressWarnings("unchecked")
    public Stack(int maxSize)
    {
    	stack = (V[]) new Object[maxSize];
    	stackTopIndex = 0;
    }
 
    /**
         Pushes an item onto the top of this stack.
    */
    public void push(V element)
    {
    	if(stackTopIndex >= maxCapacity())
    		throw new IndexOutOfBoundsException();
    	else
    	{
    		stack[stackTopIndex] = element;
        	stackTopIndex++;
    	}
    }
 
    /**
        Removes the object at the top of this stack and returns that object as the value of this function.
    */
    public V pop()
    {
    	if(stackTopIndex <= 0)
    		throw new IndexOutOfBoundsException();
    	stackTopIndex--;    	
    	return stack[stackTopIndex];
    }
 
    /**
        Looks at the object at the top of this stack without removing it from the stack.
    */
    public V peek()
    {
    	if(stackTopIndex <= 0)
    		throw new IndexOutOfBoundsException();
    	return stack[stackTopIndex - 1];
    }
 
    /**
        Returns the number of items currently in the stack
    */
    public int currentSize()
    {
    	return stackTopIndex;
    }
 
    /**
        Tests if this stack is empty.
    */
    public boolean isEmpty()
    {
    	return stackTopIndex == 0;
    }
 
    /**
        Tests if this stack is full
    */
    public boolean isFull()
    {
    	return stackTopIndex == maxCapacity();
    }
    
    
    public int maxCapacity()
    {
    	return stack.length;
    }
    
}