package model.entity.inventory;

import model.item.Item;

public class Inventory {

	private ItemStack[] items;
	
	public Inventory() {
		items = new ItemStack[10];
	}
	
	public void addItemStack(ItemStack itemStack) {
		System.out.println(">>>>>>> " + items.length);
		this.items[items.length] = itemStack;
	}
	
	public void addItemAmount(Item item, int amount) {
		this.addItemStack(new ItemStack(item, amount));
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Inventory:\n");
		for(ItemStack is : items) {
			sb.append(String.format("%n %s",is.getAmount(), is.getItem()));
		}
		return sb.toString();
	}
}
