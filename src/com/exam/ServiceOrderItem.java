package com.exam;

/**
 * Represents a service item in an order.
 * 
 * Service items are not taxable.
 * 
 * @author bryanhoke
 *
 */
public class ServiceOrderItem extends OrderItem {
	private static final long serialVersionUID = -5682267935590395951L;

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
