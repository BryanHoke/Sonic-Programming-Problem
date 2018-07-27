package com.exam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriceUtilityTest {

	@Test
	void testRountToNearestPenny() {
		assertTrue(PriceUtility.roundToNearestPenny(1.005f) == 1.01f);
		assertTrue(PriceUtility.roundToNearestPenny(1.115f) == 1.12f);
		assertTrue(PriceUtility.roundToNearestPenny(1.225f) == 1.23f);
		assertTrue(PriceUtility.roundToNearestPenny(1.0049f) == 1.00f);
		assertTrue(PriceUtility.roundToNearestPenny(1.00f) == 1.00f);
		assertTrue(PriceUtility.roundToNearestPenny(5.555f) == 5.56f);
		assertTrue(PriceUtility.roundToNearestPenny(5.55f) == 5.55f);
	}
}
