import java.util.Map.Entry;

/**
 * 
 * @param key
 * @param value
 */
public class HashTableEntry<K,V> implements Entry<K, V> {

	private K key;
	private V value;
	private boolean isAvailable;
	
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public HashTableEntry(K key, V value){
		this.key = key;
		this.value = value;
		isAvailable = false;
	}
	
	public HashTableEntry() {
		this.key = null;
		this.value = null;
		isAvailable = true;
	}
	
	public boolean isAvailable(){
		return isAvailable;
	}
	
	public void setAvailable(boolean isAvailable){
		this.isAvailable = isAvailable;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;//same as below?
	}

	@Override
	public V setValue(V value) {
		this.value = value;//needs to return undefined sometimes!
		return value;
	}
	
	@Override
	public int hashCode(){
		if(key == null | value == null)
			return 0;
		
		//TODO
		
		return 0;
		//should key = hashCode()?
	}
	
	@Override
	public boolean equals(Object o){
		//return (value==null ? o==null : value.equals(o));//might need null check
		return value.equals(o);
	}
}