import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class HelloWorldTest {

	@Test
	void test() {
		Random random = new Random();
		int randomNumber = random.nextInt();
		
		//assertTrue(HelloWorld.numberPlusOne(randomNumber) == randomNumber + 1); 
	}

}
