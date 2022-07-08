import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
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
		this.size = 0;
		maxLoad = loadFactor;
		hashTable = new HashTableEntry[size];
	}
	
	@Override
	public void clear() {
		hashTable = new HashTableEntry[hashTable.length];
	}

	@Override
	public boolean containsKey(Object arg0) {
		int index = arg0.hashCode() % hashTable.length;
		
		//if the table is all the way full, the for loop will make sure we don't look forever
		for(int i = 0; i < hashTable.length; i++) {
			if(hashTable[index] == null)
				return false;
			if(hashTable[index].getKey() == arg0 && !hashTable[index].isAvailable())
				return true;
			index++;
			if(index == hashTable.length)
				index = 0;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		for(int i = 0; i < hashTable.length; i++)
		{
			//if(!hashTable[i].isAvailable())
			if(hashTable[i] != null)
			{
				if(hashTable[i].getValue().equals(arg0))
					return true;
			}
		}
		return false;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> hashMap = new HashSet<>();
		
		for(int i = 0; i < hashTable.length; i++)
		{
			if(hashTable[i] != null && hashTable[i].getValue() != null && hashTable[i].getKey() != null && !hashTable[i].isAvailable())
			{
				hashMap.add(hashTable[i]);
			}
		}
		return hashMap;
	}

	@Override
	public V get(Object arg0) {
		if(arg0 == null)
			throw new NullPointerException();
		int index = arg0.hashCode() % hashTable.length;
		
		//if the table is all the way full, the for loop will make sure we don't look forever
		for(int i = 0; i < hashTable.length; i++) {
			if(hashTable[index] == null)
				return null;
			if(hashTable[index].getKey().hashCode() == arg0.hashCode() && !hashTable[index].isAvailable())
				return (V) hashTable[index].getValue();//I shouldn't have to cast this??
			index++;
			if(index == hashTable.length)
				index = 0;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Set<K> keySet() {
		Set<K> keySet = Collections.emptySet();
		
		for(int i = 0; i < hashTable.length; i++)
		{
			if(hashTable[i].getValue() != null && hashTable[i].getKey() != null)
			{
				keySet.add((K) hashTable[i].getKey());//I shouldn't have to cast this??
			}
		}
		return keySet;
	}

	@Override
	public V put(K key, V value) {
		if(key == null)
			throw new NullPointerException();
		int index = key.hashCode() % hashTable.length;
		
		//if the table is all the way full, the for loop will make sure we don't look forever
		for(int i = 0; i < hashTable.length; i++) {
			if(hashTable[index] == null || hashTable[index].isAvailable())
			{
				hashTable[index] = new HashTableEntry(key, value);
				size++;
				if((double)size / (double)hashTable.length > maxLoad)//resize hashtable if over max load
				{
					HashTableEntry<K,V>[] newHashTable = new HashTableEntry[2 * hashTable.length];
					for(int j = 0; j < hashTable.length; j++)
						newHashTable[j] = hashTable[j];
					hashTable = newHashTable;
				}
				return null;
			}
			if(hashTable[index].getKey() == key)
			{
				V tempValue = (V) hashTable[index].getValue();//I shouldn't have to cast this??
				hashTable[index].setValue(value);
				return tempValue;
			}
			index++;
			if(index == hashTable.length)
				index = 0;
		}
		return null;//table was full if it gets here, which shouldn't ever happen
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> otherMap) {
		for (Entry<? extends K, ? extends V> entry : otherMap.entrySet())
			put(entry.getKey(), entry.getValue());
	}

	@Override
	public V remove(Object key) {
		if(key == null)
			throw new NullPointerException();
		int index = key.hashCode() % hashTable.length;
		
		//if the table is all the way full, the for loop will make sure we don't look forever
		for(int i = 0; i < hashTable.length; i++) {
			if(hashTable[index].getKey() == key) {
				V tempValue = (V) hashTable[index].getValue();//I shouldn't have to cast this??
				hashTable[index].setAvailable(true);
				size--;
				return tempValue;
			}
			if(hashTable[index].getKey() == null && !hashTable[index].isAvailable())
				return null;
			index++;
			if(index == hashTable.length)
				index = 0;
		}
		return null;
	}

	/*
	 * returns number of elements in the hash table, NOT the container size
	 */
	@Override
	public int size() {
		return size;
	}

	@Override
	public Collection<V> values() {
		ArrayList<V> values = new ArrayList<>();
		for(int i = 0; i < hashTable.length; i++) {
			if(hashTable[i] != null && hashTable[i].getValue() != null)
				values.add((V) hashTable[i].getValue());//I shouldn't have to cast this??
		}
		return values;
	}

	@Override
	public HashTableEntry<K, V>[] getArray() {
		return hashTable;
	}

	@Override
	public void setArray(HashTableEntry<K, V>[] array) {
		hashTable = array;
	}

	/*
	 * if this is ever called, things could get messed up
	 */
	@Override
	public void setSize(int size) {
		this.size = size;
	}

}