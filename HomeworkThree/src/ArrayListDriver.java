
public class ArrayListDriver {

	public static void main(String[] args) {
		
		ArrayList<Integer> arl = new ArrayList<Integer>();
		
		arl.add(5, 0);
		arl.add(10, 1);
		arl.add(15, 2);
		arl.add(1, 0);
		System.out.println(arl.toString());
		
		arl.clear();
		
		for(int i = 0; i < 30; i++)
			arl.add(i+1, i);
		System.out.println(arl.toString());
		
		if(arl.contains(15))
			System.out.println("Contains 15");
		else
			System.out.println("Does not contain 15");
		if(arl.contains(100))
			System.out.println("Contains 100");
		else
			System.out.println("Does not contain 100");
		
		System.out.println("Element at index 10: " + arl.get(10).toString());
		System.out.println("index of 20: " + arl.indexOf(20));
		System.out.println("index of 100: " + arl.indexOf(100));
	}

}
