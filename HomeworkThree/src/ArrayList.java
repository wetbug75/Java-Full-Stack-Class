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
		data = (T[]) new Object[initialCapacity];
		size = 0;
	}

	@Override
	public void add(T item, int index) {
		if(index >= 0 && index <= size)
		{
			if(data.length <= size)//if the array is full
				increaseCapacity();
			for(int i = size; i > index; i--)
				data[i] = data[i-1];
			data[index] = item;
			size++;
		}
		else
			System.out.println("invalid index");
	}
	
	/**
	 * Doubles the capacity of the 'data' array
	 */
	private void increaseCapacity() {
		T newData[] = (T[]) new Object[data.length * 2];
		for(int i = 0; i < size; i++)
			newData[i] = data[i];
		data = newData;
	}

	@Override
	public void clear() {
		data = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
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
	
	public String toString() {
		if(isEmpty())
			return "";
		String answer = data[0].toString();
		//if(size > 1)
		//{
			for(int i = 1; i < size; i++)
			answer = answer + ", " + data[i].toString();
		//}
		return answer;
	}
}