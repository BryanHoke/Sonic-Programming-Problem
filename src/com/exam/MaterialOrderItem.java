package com.exam;

/**
 * Represents a material item in an order.
 * 
 * Material items are taxable.
 * 
 * @author bryanhoke
 *
 */
public class MaterialOrderItem extends OrderItem {
	private static final long serialVersionUID = 3421569431372008495L;

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
