/**
 * 
 */
package com.webstore.order;

/**
 * Fruit basket items class 
 * contains item name and item count pojo class
 * with setters and getters.
 */
public class FruitBasketItems {

	private String itemName;

	private Integer itemCount;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getItemCount() {
		return itemCount;
	}

	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}
}