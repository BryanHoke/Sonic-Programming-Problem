package com.exam;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.Test;

class OrderTest {
	
	@Test
	void test()
	{
		Item item1 = new Item(new Integer(1), "Bacon Breakfast Toaster", 2.99f);
		Item item2 = new Item(new Integer(2), "Medium Tots", 1.89f);
		Item item3 = new Item(new Integer(3), "tip", 1);
		OrderItem[] orderItems = {
				new MaterialOrderItem(item1, 1),
				new MaterialOrderItem(item2, 2),
				new ServiceOrderItem(item3, 1)
		};
		Order order = new Order(orderItems);
		
		// Test serialization
		try {
			byte[] bytes = serialize(order);
			Order restoredOrder = deserialize(bytes, Order.class);
			assertEquals(restoredOrder, order);
		} catch (IOException e) {
			fail("Order serialization failed: " + e.toString());
		} catch (ClassNotFoundException e) {
			fail("Order deserialization cast failed: " + e.toString());
		}
	}

	private static byte[] serialize(Order order) 
			throws IOException
	{
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
		objectOutputStream.writeObject(order);
		objectOutputStream.close();
		return byteOutputStream.toByteArray();
	}
	
	private static Order deserialize(byte[] bytes, Class<Order> cls) 
			throws IOException, ClassNotFoundException
	{
		ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
		ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
		Object obj = objectInputStream.readObject();
		return cls.cast(obj);
	}

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
	
	@Test 
	void testGetItems()
	{
		Item item1 = new Item(new Integer(1), "Pickle Juice Snow Cone Slush", 1.69f);
		Item item2 = new Item(new Integer(2), "Tots", 1.89f);
		Item item3 = new Item(new Integer(3), "Crispy Tender Dinner", 3.99f);
		OrderItem[] orderItems = {
				new MaterialOrderItem(item1, 1),
				new MaterialOrderItem(item2, 1),
				new MaterialOrderItem(item3, 1)
		};
		Order order = new Order(orderItems);
		OrderItem[] sortedOrderItems = new OrderItem[3];
		order.getItems().toArray(sortedOrderItems);
		assertEquals(sortedOrderItems[0].getItem().getName(), "Crispy Tender Dinner");
		assertEquals(sortedOrderItems[1].getItem().getName(), "Pickle Juice Snow Cone Slush");
		assertEquals(sortedOrderItems[2].getItem().getName(), "Tots");
	}
}
