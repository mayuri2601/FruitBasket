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
				if (storeItems.containsKey(customerBasket.getItemName())) {
					totalBasketCost = totalBasketCost
							+ (storeItems.get(customerBasket.getItemName()) * customerBasket.getItemCount());
				}
			}
		}
		return totalBasketCost;
	}
}
