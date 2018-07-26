package com.exam;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;



/**
 * Represents and Order that contains a collection of items.
 *
 * Care should be taken to ensure that this class is immutable since it
 * is sent to other systems for processing that should not be able 
 * to change it in any way.
 *
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Exams are us</p>
 * @author Joe Blow
 * @version 1.0
 */
public class Order {
	private OrderItem[] orderItems;

	public Order(OrderItem[] orderItems)
	{
		this.orderItems = orderItems;
	}

	/**
	 * Returns the total order cost after the tax has been applied,
	 * rounded to the nearest penny.
	 */
	public float getOrderTotal(float taxRate)
	{
		float total = 0;
		for (OrderItem item : orderItems) {
			float cost = item.getCost();
			if (item.isTaxable()) {
				cost += cost * taxRate;
			}
			total += cost;
		}
		
		return roundToNearestPenny(total);
	}
	
	// Returns the input rounded to the nearest penny (two decimal places).
	// Rounding follows RoundingMode.HALF_UP.
	private static float roundToNearestPenny(float cost)
	{
		// Uses BigDecimal for correctness, but allocation is relatively expensive
		// Can be optimized by instead using a custom algorithm, if needed
		
		// The String constructor is used to avoid floating-point precision issues
		// (E.g., using the float constructor, 1.005 is incorrectly rounded to 1.00)
		// See https://bugs.java.com/bugdatabase/view_bug.do?bug_id=4508009
		BigDecimal decimal = new BigDecimal(String.valueOf(cost));
		decimal = decimal.setScale(2, RoundingMode.HALF_UP);
		return decimal.floatValue();
	}

	/**
	 * Returns a Collection of all items sorted by item name
	 * (case-insensitive).
	 *
	 * @return Collection
	 */
	public Collection<OrderItem> getItems()
	{
		ArrayList<OrderItem> items = new ArrayList<OrderItem>();
		for (OrderItem item : orderItems) {
			items.add(item);
		}
		Comparator<OrderItem> byName = (OrderItem o1, OrderItem o2)
				-> o1.getItem().getName().compareTo(o2.getItem().getName());
		items.sort(byName);
		return items;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(orderItems);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (!Arrays.equals(orderItems, other.orderItems))
			return false;
		return true;
	}
}
