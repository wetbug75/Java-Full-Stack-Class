public class ArrayList<T> implements List<T> {

	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	
	private T[] data; //stores the items added to the list
	private int size; //keeps track of how many items have been added to the list

	/**
	 * Constructs an ArrayList using the default capacity
	 */
	public ArrayList() {
		this(DEFAULT_INITIAL_CAPACITY);
	}

	/**
	 * Constructs an ArrayList with an 'initialCapacity'
	 * 
	 * If 'initalCapacity' is non-positive use the default capacity
	 * 
	 * @param initialCapacity
	 */
	public ArrayList(int initialCapacity) {
		T data[] = (T[]) new Object[initialCapacity];
		size = 0;
	}

	@Override
	public void add(T item, int index) {
		if(data.length <= size)//if the array is full
		{
			//TODO need to increase array capacity here
		}
		//TODO
		
		size++;
	}

	@Override
	public void clear() {
		T data[] = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
		size = 0;
	}

	@Override
	public boolean contains(Object item) {
		for(int i = 0; i < size; i++)
		{
			if(data[i].equals(item))
				return true;
		}
		return false;
	}

	@Override
	public T get(int index) {
		if(index >= size)
			return null;
		return data[index];
	}

	@Override
	public int indexOf(Object item) {
		for(int i = 0; i < size; i++)
		{
			if(data[i].equals(item))
				return i;
		}
		return -1;//unsure what would be proper to return if there's no 'item' in the ArrayList
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}
}