package JUnitTest;
import model.Product;

//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import org.junit.*;
public class ControllerTest {
	
	
	
	@Test
	public void Test1() {
		Product test1 = new Product("Jeppe", null, null, null, null, null, null);
		String output_f = test1.getName();
		
		assertEquals("Jeppe",output_f);
	}
	
	public void Test2() {
		
		
	}
	

//	\*
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}
//
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//	*\
}
