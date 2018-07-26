package com.exam;

/**
 * Represents a service item in an order.
 * 
 * @author bryanhoke
 *
 */
public class ServiceOrderItem extends OrderItem {

	public ServiceOrderItem(Item item, int quantity) 
	{
		super(item, quantity);
	}

	@Override
	public boolean isTaxable()
	{
		return false;
	}
}
