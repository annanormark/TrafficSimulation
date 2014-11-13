package TS;

import static org.junit.Assert.*;

import org.junit.Test;

public class LightTest {

	@Test
	public void test1() {
		Light testlight = new Light(2, 1);
		assertTrue(testlight.isGreen());
	}
	public void test2(){
		Light testlight = new Light(2, 1);
		testlight.step();
		assertTrue(testlight.isGreen() == false);
	}

}
