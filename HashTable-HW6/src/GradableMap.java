import java.util.Map;

public interface GradableMap<K, V> extends Map<K, V> {
	
	/********************************************************
	 * 				These methods are for grading
	 * 	Just implement them as one line getters and setters
	 ********************************************************/
	
	public HashTableEntry<K,V>[] getArray();
	
	public void setArray(HashTableEntry<K,V>[] array);
	
	public void setSize(int size);
	
}