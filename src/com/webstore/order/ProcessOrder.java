/**
 * 
 */
package com.webstore.order;

import java.util.List;
import java.util.Map;

/**
 * Process order class contains method
 * to calculate total basket cost.
 *
 */
public class ProcessOrder {

	/**
	 * Method to calculate total basket cost.
	 * 
	 * @param storeItems
	 * @param customerItems
	 * @return
	 */
	public Double calculateBasketCost(Map<String, Double> storeItems, List<FruitBasketItems> customerItems) {

		Double totalBasketCost = 0.0;
		if (!(null == storeItems) && !(null == customerItems)) {
			for (FruitBasketItems customerBasket : customerItems) {
				String itemName = customerBasket.getItemName();
				if (itemName != null && storeItems.containsKey(itemName)) {
					totalBasketCost = totalBasketCost
							+ (storeItems.get(itemName) * customerBasket.getItemCount());
				}
			}
		}
		return totalBasketCost;
	}
}
