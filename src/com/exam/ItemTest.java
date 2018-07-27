package com.exam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Hashtable;

class ItemTest {

	@Test
	void test() 
	{
		Item item1a = new Item(new Integer(1), "item1", 1.0f);
		Item item1b = new Item(new Integer(1), "item1", 1.0f);
		Item item2  = new Item(new Integer(2), "item2", 2.0f);
		
		// Test equality
		assertEquals(item1a, item1b);
		assertNotEquals(item1a, item2);
		
		// Test hashing
		Hashtable<Item, String> table = new Hashtable<Item, String>();
		table.put(item1a, "item1a");
		assertEquals(table.get(item1a), "item1a");
		table.put(item2, "item2");
		assertEquals(table.get(item2), "item2");
		assertEquals(table.get(item1b), "item1a");
		table.put(item1b, "item1b");
		assertEquals(table.get(item1a), "item1b");
	}
}
