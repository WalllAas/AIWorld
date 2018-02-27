package model.item.crafting;

import model.item.Item;

public class CraftingMaterial {
	
	private Item item;
	private int amount;
	
	public CraftingMaterial(Item item, int amount) {
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
