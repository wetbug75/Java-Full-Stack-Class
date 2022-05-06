public class HelloWorld {
	public static void main(String[] args) {
		HelloWorld hw = new HelloWorld();
		PerformOperation isOdd = hw.lambdaIsOdd();
		boolean answer = hw.checkFunction(isOdd, 1);//the number is the input
		System.out.println(answer);
	}
	
	//filter, not a map or 
	private static PerformOperation lambdaIsOdd()
	{
		return num -> (num % 2 == 0)? false:true;
	}
	
	private static PerformOperation isPalindrome()
	{
		return num -> num == Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString())? true: false;
	}
	
	public static boolean checkFunction(PerformOperation p, int num)
	{
		return p.check(num);
	}
}