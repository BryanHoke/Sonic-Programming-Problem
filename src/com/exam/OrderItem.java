/**
 * 
 */
package com.exam;

/**
 * Represents an item in an Order by associating an order quantity and 
 * taxability with an Item to be ordered.
 * 
 * @author bryanhoke
 *
 */
public abstract class OrderItem {
	private Item item;
	private int quantity;
	
	public OrderItem(Item item, int quantity)
	{
		this.item = item;
		this.quantity = quantity;
	}
	
	/**
	 * Returns the Item being ordered.
	 */
	public Item getItem()
	{
		return item;
	}
	
	/**
	 * Returns the quantity of the Item to be ordered.
	 */
	public int getQuantity()
	{
		return quantity;
	}
	
	/**
	 * Returns whether the Item being ordered is taxable.
	 * 
	 * @return True if the Item is taxable, false otherwise.
	 */
	public abstract boolean isTaxable();
}
