import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HashTableTest {
	
	@Test
	void containsKeyTest() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(20);
		hashTable.put(1,1);
		hashTable.put(2,2);
		hashTable.put(4,12);
		hashTable.put(7,6);
		hashTable.put(13,5);

		assertTrue(hashTable.containsKey(7));
	}
	
	void containsKeyFalseTest() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(20);
		hashTable.put(1,1);
		hashTable.put(2,2);
		hashTable.put(4,12);
		hashTable.put(7,6);
		hashTable.put(13,5);

		assertTrue(!hashTable.containsKey(3));
		assertTrue(!hashTable.containsKey(22));
	}
		
	@Test
	void containsValueTest() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(20);
		hashTable.put(1,1);
		hashTable.put(2,2);
		hashTable.put(4,12);
		hashTable.put(7,6);
		hashTable.put(13,5);

		assertTrue(hashTable.containsValue(12));
	}
	
	@Test
	void containsValueFalseTest() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(20);
		hashTable.put(1,1);
		hashTable.put(2,2);
		hashTable.put(4,12);
		hashTable.put(7,6);
		hashTable.put(13,5);

		assertTrue(!hashTable.containsValue(3));
	}
	
	@Test
	void removeElementTest() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(20);
		hashTable.put(1,1);
		hashTable.put(2,2);
		hashTable.put(4,12);
		hashTable.put(7,6);
		hashTable.put(13,5);

		hashTable.remove(2);
		
		assertTrue(!hashTable.containsKey(2));
	}
	
	@Test
	void hashModTest() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(20);
		hashTable.put(1,1);
		hashTable.put(2,2);
		hashTable.put(13,12);
		hashTable.put(33,6);
		hashTable.put(53,5);

		HashTableEntry<Integer, Integer>[] hashArray = hashTable.getArray();
		
		assertTrue(hashArray[13].getValue() == 12);
		assertTrue(hashArray[14].getValue() == 6);
		assertTrue(hashArray[15].getValue() == 5);
	}
	
	@Test
	void sizeTest() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(20);
		hashTable.put(1,1);
		hashTable.put(2,2);
		hashTable.put(4,12);
		hashTable.put(7,6);
		hashTable.put(13,5);

		assertTrue(hashTable.size() == 5);
		
		hashTable.remove(4);
		
		assertTrue(hashTable.size() == 4);
	}
	
	@Test
	void hashCollisionTest() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(20);
		hashTable.put(1,1);
		hashTable.put(2,2);
		hashTable.put(13,12);
		hashTable.put(13,6);
		hashTable.put(13,5);

		assertTrue(!hashTable.containsValue(12));
		assertTrue(!hashTable.containsValue(6));
		assertTrue(hashTable.containsValue(5));
		
		assertTrue(hashTable.size() == 3);
	}
	
	@Test
	void loadChangeTest() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(10);
		hashTable.put(1,1);
		hashTable.put(2,2);
		hashTable.put(3,12);
		hashTable.put(7,6);
		hashTable.put(13,5);
		hashTable.put(14,5);
		hashTable.put(15,5);
		hashTable.put(16,5);

		assertTrue(hashTable.getArray().length == 20);
	}
	
	@Test
	void valuesTest() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(20);
		hashTable.put(1,1);
		hashTable.put(2,2);
		hashTable.put(3,12);
		hashTable.put(7,6);
		hashTable.put(13,5);
		
		assertTrue((int)hashTable.values().toArray()[0] == 1);
		assertTrue((int)hashTable.values().toArray()[1] == 2);
		assertTrue((int)hashTable.values().toArray()[2] == 12);
		assertTrue((int)hashTable.values().toArray()[3] == 6);
		assertTrue((int)hashTable.values().toArray()[4] == 5);
	}
	
	@Test
	void homeworkExampleTest() {
		LinearProbingHashTable<Integer,String> hashTable = new LinearProbingHashTable<>(5);
		hashTable.put(6,"World");
		hashTable.put(3,"Hello");
		hashTable.put(8,"foo");
		
		hashTable.remove(6);
		hashTable.remove(3);
		hashTable.remove(8);
		
		hashTable.put(13,"bar");
		
		assertTrue(hashTable.getArray()[3].getValue() == "bar");
		assertTrue(hashTable.size() == 1);
	}
}
