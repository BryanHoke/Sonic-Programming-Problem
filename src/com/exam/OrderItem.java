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
	 * Returns the (pre-tax) cost of ordering the specified quantity of the item.
	 */
	public float getCost()
	{
		return quantity * item.getPrice();
	}
	
	/**
	 * Returns whether the Item being ordered is taxable.
	 * 
	 * @return True if the Item is taxable, false otherwise.
	 */
	public abstract boolean isTaxable();

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + quantity;
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
		OrderItem other = (OrderItem) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
}
