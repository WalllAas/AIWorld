package model.entity.inventory;

import model.item.Item;

public class ItemStack {
	
	private Item item;
	private int amount;
	
	public ItemStack(Item item, int amount) {
		this.item = item;
		this.amount = amount;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public int getAmount() {
		return this.amount;
	}

}
