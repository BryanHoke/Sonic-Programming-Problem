package com.exam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {

	@Test
	void testGetOrderTotal() 
	{
		// Make sure we agree with real-world values
		float okTaxRate = 0.08625f;
		Item item1 = new Item(new Integer(1), "Bacon Breakfast Toaster", 2.99f);
		Item item2 = new Item(new Integer(2), "Medium Tots", 1.89f);
		Item item3 = new Item(new Integer(3), "tip", 1);
		OrderItem[] orderItems1 = {
				new MaterialOrderItem(item1, 1),
				new MaterialOrderItem(item2, 2),
				new ServiceOrderItem(item3, 1)
		};
		Order order1 = new Order(orderItems1);
		assertTrue(order1.getOrderTotal(okTaxRate) == 8.35f);
		
		// Make sure penny-rounding works as expected
		Item item4 = new Item(new Integer(4), "One-Dollar Hot Dog", 1);
		OrderItem[] orderItems2 = {
				new MaterialOrderItem(item4, 1)
		};
		Order order2 = new Order(orderItems2);
		assertTrue(order2.getOrderTotal(0.005f) == 1.01f);
		assertTrue(order2.getOrderTotal(0.115f) == 1.12f);
		assertTrue(order2.getOrderTotal(0.225f) == 1.23f);
		assertTrue(order2.getOrderTotal(0.0049f) == 1.00f);
	}
}
