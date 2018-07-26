package com.exam;

/**
 * Represents a material item in an order.
 * 
 * @author bryanhoke
 *
 */
public class MaterialOrderItem extends OrderItem {
	
	public MaterialOrderItem(Item item, int quantity)
	{
		super(item, quantity);
	}

	@Override
	public boolean isTaxable()
	{
		return true;
	}
}
