package TS;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrafficSystemTest {
	TrafficSystem t = new TrafficSystem(1, 1, 2, 2, 2);	
	@Test
	public void test1() {
		assertTrue(t.getMax() == 0);
	}
	
	public void test2(){
		assertTrue(t.getcarsin() == 0);
	}

	public void test3(){
		assertTrue(t.getcarsout() == 0);
	}
	
	public void test4(){
		assertTrue(t.getforward() == 0);
	}
	
	public void test5(){
		assertTrue(t.getleft() == 0);
	}
	
	public void test6(){
		assertTrue(t.getTotal() == 0);
	}
}
