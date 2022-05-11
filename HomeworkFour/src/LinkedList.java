import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A doubly linked list, with both a head and tail pointer
 * @author Andrew Krause
 * @version 1.0
 * @param <T>
 */
public class LinkedList<T> implements List<T> {

	private Node head, tail; // these are always the first and last nodes
	private int size; // this is the number of items in the list
	
	public LinkedList () {
		size = 0;
	}
	
	@Override
	public void add(T item) {
		if(isEmpty())
			addFirst(item);
		else
			addLast(item);
	}

	@Override
	public void add(T item, int index) {
		if ( index < 0 || index >= size ) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0)
			addFirst(item);
		else
		{
			Node tempNode = head;
			for(int i = 0; i < index - 1; i++)
			{
				tempNode = tempNode.getNext();
			}
			Node newNode = new Node(item, tempNode.getNext(), tempNode);
			tempNode.getNext().setPrev(newNode);
			tempNode.setNext(newNode);
			size++;
		}
	}

	/**
	 * Adds 'item' to front of this linked list
	 * 
	 * @param item
	 */
	public void addFirst(T item) {
		if(isEmpty())
		{
			head = new Node();
			head.setData(item);
			head.setNext(tail);
		}
		else if(size == 1)
		{
			tail = new Node();
			tail.setData(head.getData());
			tail.setPrev(head);
			head.setNext(tail);
			head.setData(item);
		}
		else
		{
			Node newNode = new Node(head.getData(), head.getNext(), head);
			head.setData(item);
			head.setNext(newNode);
			newNode.getNext().setPrev(newNode);
		}
		size++;
	}
	
	/**
	 * Adds 'item' to the end of this linked list
	 * 
	 * @param item
	 */
	public void addLast(T item) {
		if(size == 1)
		{
			tail = new Node();
			tail.setData(item);
			tail.setPrev(head);
			head.setNext(tail);
		}
		else
		{
			Node newNode = new Node(tail.getData(), tail, tail.getPrev());
			tail.getPrev().setNext(newNode);
			tail.setPrev(newNode);
			tail.setData(item);
		}
		size++;
	}
	
	@Override
	public void clear() {
		size = 0;
		head = null;
		tail = null;
	}

	@Override
	public boolean contains(Object item) {
		Iterator<T> theIterator = iterator();
		for(int i = 0; i < size; i++)
		{
			if(theIterator.next().equals(item))
				return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public T remove(Object item) {
		Iterator<T> theIterator = iterator();
		T itemCheck;
		for(int i = 0; i < size; i++)
		{
			itemCheck = theIterator.next();
			if(itemCheck.equals(item))
			{
				theIterator.remove();
				return itemCheck;
			}
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> theIterator = new Iterator<T>() {

			private Node currentNode = head;
			
			@Override
			public boolean hasNext() {
				return currentNode != null;
			}

			@Override
			public T next() {
				if (!hasNext())
					throw new IndexOutOfBoundsException();
				T answer = currentNode.getData();
				currentNode = currentNode.getNext();
				return answer;
			}
			
			@Override
			public void remove() {
				currentNode.getPrev().getPrev().setNext(currentNode);
				currentNode.setPrev(currentNode.getPrev().getPrev());
				size--;
			}
			
		};
		return theIterator;
	}

	@Override
	public T get(int index) {
		if ( index < 0 || index >= size ) {
			throw new IndexOutOfBoundsException();
		}
		Iterator<T> theIterator = iterator();
		for(int i = 0; i < index; i++)
		{
			theIterator.next();
		}
		return theIterator.next();
	}

	@Override
	public int indexOf(Object item) {
		Iterator<T> theIterator = iterator();
		for(int i = 0; i < size; i++)
		{
			if(theIterator.next().equals(item))
				return i;
		}
		return -1;
	}

	@Override
	public T remove(int index) {
		if ( index < 0 || index >= size ) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0)
			return removeFirst();
		if(index == size - 1)
			return removeLast();
		
		Iterator<T> theIterator = iterator();
		for(int i = 0; i < index; i++)
		{
			theIterator.next();
		}
		T answer = theIterator.next();
		theIterator.remove();
		return answer;
	}

	/**
	 * @return the first item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getFirst() {
		if(isEmpty())
			throw new NoSuchElementException();
		return head.getData();
	}

	/**
	 * @return the last item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getLast() {
		if(isEmpty())
			throw new NoSuchElementException();
		if(size == 1)
			return head.getData();
		return tail.getData();
	}

	/**
	 * Removes and returns the first item from this linked list
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeFirst() {
		if(isEmpty())
			throw new NoSuchElementException();
		T answer = head.getData();
		if(size == 1)
			head = null;
		else if(size == 2)
		{
			head.setData(tail.getData());
			tail = null;
		}
		else 
		{
			head = head.getNext();
			head.setPrev(null);
		}
		size--;
		return answer;
	}

	/**
	 * Removes and returns the last item from this linked list
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeLast() {
		if(isEmpty())
			throw new NoSuchElementException();
		if(size == 1)
			return removeFirst();
		T answer = tail.getData();
		if(size == 2)
		{
			tail = null;
		}
		else
		{
			tail = tail.getPrev();
			tail.setNext(null);
		}
		size--;
		return answer;
	}
	
	/**
	 * Represents one element in a linked list, which can store 2 other 'Node' elements being the next and previous elements in the linked list 
	 */
	private class Node {
		private Node next;
		private Node prev;
		private T data;
		
		/**
		 * empty Node constructor
		 */
		public Node() {}
		
		/**
		 * Node constructor
		 * @param data
		 * @param next
		 * @param prev
		 */
		public Node(T data, Node next, Node prev) {
			this.setNext(next);
			this.setPrev(prev);
			this.setData(data);
		}
		
		/**
		 * getter for next Node
		 * @return the next Node
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * setter for next Node
		 * @param next
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/**
		 * getter for previous Node
		 * @return the previous Node
		 */
		public Node getPrev() {
			return prev;
		}

		/**
		 * setter for previous Node
		 * @param prev
		 */
		public void setPrev(Node prev) {
			this.prev = prev;
		}

		/**
		 * getter for the data of the current Node
		 * @return stored data
		 */
		public T getData() {
			return data;
		}

		/**
		 * setter for the data of the current Node
		 * @param data
		 */
		public void setData(T data) {
			this.data = data;
		}
	}
}