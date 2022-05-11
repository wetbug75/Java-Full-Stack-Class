import java.util.Iterator;

public class LinkedListDriver {

	public static void main(String[] args) {
		LinkedList<Integer> theList = new LinkedList<Integer>();
		theList.add(1);
		theList.add(2);
		theList.add(3);
		theList.add(4);
		theList.add(5);
		theList.add(6);
		theList.add(7);
		theList.add(8);
		theList.add(9);
		
		int thing = theList.remove(6);
		System.out.println("Removed: " + thing);
		
		Iterator<Integer> theIterator = theList.iterator();
		System.out.println(theIterator.next() + ", " + theIterator.next() + ", " + theIterator.next() + ", " + theIterator.next() + ", " + theIterator.next() + ", " + theIterator.next() + ", " + theIterator.next() + ", " + theIterator.next());
		System.out.println("Last item: " + theList.getLast());
		System.out.println("First item: " + theList.getFirst());
		System.out.println("Index of 4: " + theList.indexOf(4));
		System.out.println("Contains 'word': " + theList.contains("word"));
		System.out.println("Contains 7: " + theList.contains(7));
		System.out.println("Contains 9: " + theList.contains(9));
		System.out.println("List size: " + theList.size());
		
		theList.clear();
		theList.addFirst(1);
		theList.addFirst(2);
		theList.addLast(10);
		theList.addFirst(3);
		theIterator = theList.iterator();
		System.out.println(theIterator.next() + ", " + theIterator.next() + ", " + theIterator.next() + ", " + theIterator.next());
		System.out.println("Iterator has next: " + theIterator.hasNext());
		
		theList.add(20, 2);
		theIterator = theList.iterator();
		System.out.println(theIterator.next() + ", " + theIterator.next() + ", " + theIterator.next() + ", " + theIterator.next());
		System.out.println("List size: " + theList.size());
	}

}
