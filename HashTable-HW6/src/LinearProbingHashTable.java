import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class LinearProbingHashTable<K, V> implements GradableMap<K, V> {
	
	private HashTableEntry[] hashTable;
	private double maxLoad;
	private int size;
	
	/**
	 * size = 11, max load = 0.75
	 */
	public LinearProbingHashTable(){
		this(11);
	}
	
	/**
	 * the maximum load is set to 0.75
	 * @param size initial size of the hash table
	 */
	public LinearProbingHashTable(int size){
		this(size, .75);
	}

	/**
	 * constructor
	 * @param size initial size of the hash table
	 * @param loadFactor
	 */
	public LinearProbingHashTable(int size, double loadFactor){
		this.size = size;
		maxLoad = loadFactor;
		hashTable = new HashTableEntry[20];
	}
	
	@Override
	public void clear() {
		setArray(new HashTableEntry[0]);//size set to 0 in setArray method
	}

	@Override
	public boolean containsKey(Object arg0) {
		//TODO
		int index = arg0.hashCode();//not calling my hashCode() i think
		while(!hashTable[index % size].isAvailable())//this will go forever if the array is full and the key isn't there
		{
			if(hashTable[index % size].getKey().equals(arg0))
				return true;
			index++;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		for(int i = 0; i < size; i++)
		{
			if(!hashTable[i].isAvailable())
			{
				if(hashTable[i].getValue().equals(arg0))
					return true;
			}
		}
		return false;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> hashMap = Collections.emptySet();
		
		for(int i = 0; i < size; i++)
		{
			if(!hashTable[i].isAvailable())
			{
				hashMap.add(hashTable[i]);//if there are duplicates this won't work right, but there shouldn't be duplicates
			}
		}
		return hashMap;
	}

	@Override
	public V get(Object arg0) {
		if(arg0 == null)
			return null;
		for(int i = 0; i < size; i++)
		{
			if(!hashTable[i].isAvailable())
			{
				if(hashTable[i].getValue().equals(arg0))
					return (V)hashTable[i].getValue();
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> otherMap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashTableEntry<K, V>[] getArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setArray(HashTableEntry<K, V>[] array) {
		hashTable = array;//check the sizes?
		setSize(array.length);
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

}