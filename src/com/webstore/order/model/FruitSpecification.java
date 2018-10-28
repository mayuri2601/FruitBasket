/**
 * 
 */
package com.webstore.order.model;

import com.webstore.order.constants.OFFER;

/**
 * Fruit basket items class 
 * contains item name and item price pojo class
 * with setters and getters.
 */
public class FruitSpecification {
	
	private String itemName;

	private Double itemPrice;
	
	private Integer quantity;
	
	private OFFER offers;
	
	private boolean isOffer;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public OFFER getOffers() {
		return offers;
	}

	public void setOffers(OFFER offers) {
		this.offers = offers;
	}

	public boolean isOffer() {
		return isOffer;
	}

	public void setOffer(boolean isOffer) {
		this.isOffer = isOffer;
	}
}