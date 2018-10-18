/**
 * 
 */
package com.webstore.order.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.webstore.order.FruitBasketItems;
import com.webstore.order.ProcessOrder;

/**
 * Unit test to test scenarios to check calculated cost,
 * cost failure scenario, null check.
 *
 */
public class ProcessOrderUTest {

	private ProcessOrder orderProcessor;
	private Map<String, Double> storeItems;
	private List<FruitBasketItems> customerItems;

	/**
	 * Method to add the items in the store.
	 */
	@Before
	public void setUp() {
		orderProcessor = new ProcessOrder();
		storeItems = new HashMap<String, Double>();
		customerItems = new ArrayList<FruitBasketItems>();
		storeItems.put("banana", 20.00);
		storeItems.put("orange", 30.00);
		storeItems.put("apple", 40.00);
		storeItems.put("lemon", 10.50);
		storeItems.put("peach", 50.00);
	}

	/**
	 * Method to test total basket cost.
	 */
	@Test
	public void testCalculateBasketCostSuccess() {
		// user inputs
		FruitBasketItems item = new FruitBasketItems();
		item.setItemName("banana");
		item.setItemCount(5);
		customerItems.add(item);

		FruitBasketItems secondItem = new FruitBasketItems();
		secondItem.setItemName("orange");
		secondItem.setItemCount(10);
		customerItems.add(secondItem);

		assertEquals(400.00, orderProcessor.calculateBasketCost(storeItems, customerItems), 0.0);
	}

	/**
	 * Method to test total basket cost.
	 */
	@Test
	public void testCalculateBasketCostAllSuccess() {
		// user inputs
		FruitBasketItems item = new FruitBasketItems();
		item.setItemName("lemon");
		item.setItemCount(2);
		customerItems.add(item);

		FruitBasketItems secondItem = new FruitBasketItems();
		secondItem.setItemName("banana");
		secondItem.setItemCount(2);
		customerItems.add(secondItem);

		FruitBasketItems thirdItem = new FruitBasketItems();
		thirdItem.setItemName("orange");
		thirdItem.setItemCount(2);
		customerItems.add(thirdItem);

		FruitBasketItems fourthItem = new FruitBasketItems();
		fourthItem.setItemName("apple");
		fourthItem.setItemCount(2);
		customerItems.add(fourthItem);

		FruitBasketItems fifthItem = new FruitBasketItems();
		fifthItem.setItemName("peach");
		fifthItem.setItemCount(2);
		customerItems.add(fifthItem);

		assertEquals(301.00, orderProcessor.calculateBasketCost(storeItems, customerItems), 0.0);
	}

	@Test
	public void testCalculateBasketCostFailure() {
		// user inputs
		FruitBasketItems item = new FruitBasketItems();
		item.setItemName(null);
		item.setItemCount(5);
		customerItems.add(item);

		FruitBasketItems secondItem = new FruitBasketItems();
		secondItem.setItemName("orange");
		secondItem.setItemCount(10);
		customerItems.add(secondItem);

		assertNotEquals(500.00, orderProcessor.calculateBasketCost(storeItems, customerItems), 0.0);
	}

	@Test
	public void testCalculateBasketCostNullcheck() {
		assertNotEquals(500.00, orderProcessor.calculateBasketCost(null, null), 0.0);
	}

}
