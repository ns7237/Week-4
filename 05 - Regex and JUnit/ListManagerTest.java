package utils;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ListManagerTest {
	@Test
	public void testAddElement() {
		List<Integer> list = new ArrayList<>();
		ListManager.addElement(list, 10);
		assertTrue(list.contains(10));
		assertEquals(1,ListManager.getSize(list));
	}
	@Test
	public void testRemoveElement() {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		ListManager.removeElement(list, 5);
		assertFalse(list.contains(5));
		assertEquals(0,ListManager.getSize(list));
	}
	@Test
	public void testGetSize() {
		List<Integer> list = new ArrayList<>();
		assertEquals(0,ListManager.getSize(list));
		ListManager.addElement(list, 1);
		ListManager.addElement(list, 2);
		assertEquals(2,ListManager.getSize(list));
	}
}
