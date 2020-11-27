package org.kpu.mall;

public class Item {
	private String itemName;
	private int itemPrice;
	private int itemQuantity = 0;
	
	public Item(String itemName, int itemPrice) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		itemQuantity = 0;
	}

	public String getItemName() {
		return itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity += itemQuantity;
	}
	
	
}
