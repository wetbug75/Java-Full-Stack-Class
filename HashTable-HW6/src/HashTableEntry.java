import java.util.Map.Entry;

/**
 * 
 * @param key
 * @param value
 */
public class HashTableEntry<K,V> implements Entry<K, V> {

	private K key;
	private V value;
	private boolean isAvailable; //is true when an entry used to be there, but was deleted
	
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
		isAvailable = false;
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
		V tempV = this.value;
		this.value = value;
		return tempV;
	}
	
	@Override
	public int hashCode(){
		if(key == null | value == null)
			return 0;
		return getKey().hashCode() ^ getValue().hashCode(); //^ is XOR
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof HashTableEntry))
			return false;
		HashTableEntry<K,V> object = (HashTableEntry<K,V>) o;
		return (getKey()==null ? object.getKey()==null : getKey().equals(object.getKey()))  &&
			   (getValue()==null ? object.getValue()==null : getValue().equals(object.getValue()));
	}
}