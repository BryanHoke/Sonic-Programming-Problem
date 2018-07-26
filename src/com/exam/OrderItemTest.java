package com.exam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderItemTest {

	@Test
	void testGetCost()
	{
		Item item1 = new Item(new Integer(1), "item1", 0.99f);
		MaterialOrderItem materialItem1 = new MaterialOrderItem(item1, 3);
		assertTrue(materialItem1.getCost() == 2.97f);
		
		Item item2 = new Item(new Integer(3), "item2", 2);
		MaterialOrderItem materialItem2 = new MaterialOrderItem(item2, 2);
		assertTrue(materialItem2.getCost() == 4);
		
		Item item3 = new Item(new Integer(2), "item3", 0.00f);
		ServiceOrderItem serviceItem1 = new ServiceOrderItem(item3, 1);
		assertTrue(serviceItem1.getCost() == 0);
		
		Item item4 = new Item(new Integer(4), "item4", 0.01f);
		ServiceOrderItem serviceItem2 = new ServiceOrderItem(item4, 10);
		assertTrue(serviceItem2.getCost() == 0.099999994f);
	}
}
