package com.exam;

import java.math.*;

/**
 * Provides utility functions for performing common operations on monetary values.
 * 
 * @author bryanhoke
 *
 */
class PriceUtility {
	
	/**
	 * Returns the input cost rounded to the nearest penny (two decimal places).
	 * 
	 * "Nearest neighbor" rounding is used.
	 * 
	 * @param price The un-rounded monetary cost.
	 * @return The cost rounded to the nearest penny.
	 */
	static float roundToNearestPenny(float cost)
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
}
