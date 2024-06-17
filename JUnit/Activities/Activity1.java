package activities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class Activity1 {
	//test fixture
	static ArrayList<String> list;
	@BeforeAll
	   public static void setUp() throws Exception {
		// Initialize a new ArrayList
		list = new ArrayList<String>();
		// Add values to the list
		list.add("alpha"); // at index 0
		list.add("beta"); // at index 1
    }
	
@Test
@Order(1)
	public void insertTest() {
	// Assert size of list
	assertEquals(2, list.size(), "Wrong size");
	// Add new element
    list.add(2, "gamma");
    //Assert with new element
    assertEquals(3, list.size(), "Wrong size");
 // Assert individual elements
    assertEquals("alpha", list.get(0), "Wrong element");
    assertEquals("beta", list.get(1), "Wrong element");
    assertEquals("gamma", list.get(2), "Wrong element");
}

@Test
@Order(2)
public void replaceTest() {
    // Replace new element
    list.set(1, "charlie");

    // Assert size of list
    assertEquals(3, list.size(), "Wrong size");
    // Assert individual elements
    assertEquals("alpha", list.get(0), "Wrong element");
    assertEquals("charlie", list.get(1), "Wrong element");
}

}