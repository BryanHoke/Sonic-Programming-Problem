package com.exam;

import java.io.Serializable;

/**
 * Represents a part or service that can be sold.
 *
 * Care should be taken to ensure that this class is immutable since it
 * is sent to other systems for processing that should not be able to    
 * change it in any way.
 *
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Exams are us</p>
 * @author Joe Blow
 * @version 1.0
 */
public class Item implements Serializable {
	private static final long serialVersionUID = 6324280474534734945L;
	
	private Integer key;
	private String name;
	private float price;

	public Item(Integer key, String name, float price) 
	{
		this.key = key;
		this.name = name;
		this.price = price;
	}

	/**
	 * Returns the Item key.
	 */
	public Integer getKey()
	{
		return key;
	}

	/**
	 * Returns the name of the Item.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Returns the price of the Item.
	 */
	public float getPrice()
	{
		return price;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
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
		Item other = (Item) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}
}
