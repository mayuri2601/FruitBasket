/**
 * 
 */
package com.webstore.order.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.webstore.order.constants.OFFER;
import com.webstore.order.exception.FruitStoreException;
import com.webstore.order.service.ProcessOrder;
import com.webstore.order.service.ProcessOrderImpl;

/**
 * Unit test to test scenarios to check calculated cost, cost failure scenario,
 * null check.
 *
 */
public class ProcessOrderUTest {

	ProcessOrder order = new ProcessOrderImpl();

	/**
	 * Method to add the items in the store.
	 */
	@Before
	public void setUp() {
		try {
			ProcessOrder.storeItems.clear();
			ProcessOrder.customerBasket.clear();
			order.loadStore("banana", 20.0, OFFER.NONE, 100, false);
			order.loadStore("orange", 30.0, OFFER.DISCOUNT_IN_PERCENT, 100, true);
			order.loadStore("apple", 40.0, OFFER.NONE, 100, false);
			order.loadStore("lemon", 10.0, OFFER.NONE, 100, false);
			order.loadStore("peach", 50.0, OFFER.PROMOTIONAL_OFFER, 100, true);
		} catch (FruitStoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Load customer basket and check the cost of the basket.
	 */
	@Test
	public void testCalculateBasketCost() {
		// user inputs
		try {
			order.loadCustomerBasket("banana", 5);
			order.loadCustomerBasket("orange", 10);
			order.loadCustomerBasket("lemon", 10);
			Double cost = order.processCustomerOrder(ProcessOrder.customerBasket);
			assertEquals(540.0, cost, 0.0);
		} catch (FruitStoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Validate null check for fruit list and quantity.
	 */
	@Test
	public void testCalculteBasketForNull() {
		try {
			order.loadCustomerBasket(null, null);
			order.processCustomerOrder(ProcessOrder.customerBasket);
		} catch (FruitStoreException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * quantity not available in the store check.
	 */
	@Test
	public void testINsufficientQuantityCheck() {
		try {
			order.loadCustomerBasket("banana", 200);
			order.processCustomerOrder(ProcessOrder.customerBasket);
		} catch (FruitStoreException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Validate null check for quantity.
	 */
	@Test
	public void testCalculteBasketForNullQuantity() {
		try {
			order.loadCustomerBasket("Banana", null);
			order.processCustomerOrder(ProcessOrder.customerBasket);
		} catch (FruitStoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to test total basket cost for all the items.
	 */
	@Test
	public void testCalculateBasketCostAllSuccess() {
		// user inputs
		try {
			order.loadCustomerBasket("banana", 10);
			order.loadCustomerBasket("orange", 10);
			order.loadCustomerBasket("lemon", 10);
			order.loadCustomerBasket("peach", 10);
			order.loadCustomerBasket("apple", 10);
			Double cost = order.processCustomerOrder(ProcessOrder.customerBasket);
			assertEquals (1570.0, cost,0.0);
		} catch (FruitStoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test for minus input values
	 */
	@Test
	public void testCalculateBasketCostNegativeValueCheck() {
		// user inputs
		try {
			order.loadCustomerBasket("banana", -5);
			order.processCustomerOrder(ProcessOrder.customerBasket);
		} catch (FruitStoreException e) {
			e.printStackTrace();
		}
	}
}
