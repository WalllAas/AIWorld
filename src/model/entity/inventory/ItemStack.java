package model.entity.inventory;

import model.item.Item;

public class ItemStack {
	
	private Item item;
	private int amount;
	
	public ItemStack(Item item, int amount) {
		this.item = item;
		this.amount = amount;
	}
	
	public void addItems(ItemStack itemStack) {
		if(item.equals(itemStack.getItem())) {
			amount += itemStack.getAmount();
		}
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public int getAmount() {
		return this.amount;
	}

	@Override
	public String toString() {
		
		return String.format("%s - %s", this.item, this.amount);
	}
}
