package model.entity.inventory;

import java.util.ArrayList;
import java.util.List;

import model.item.Item;

public class Inventory {

	private List<ItemStack> items;
	
	public Inventory() {
		items = new ArrayList<>();
	}
	
	public void addItemStack(ItemStack itemStack) {
		// FIXME
		boolean done = false;
		int count = 0;
		while(!done && count < items.size()) {
			if(items.get(count).getItem().equals(itemStack.getItem())) {
				items.get(count).addItems(itemStack);
				done = true;
			}
		}
		
		if(!done) {
			this.items.add(itemStack);
		}
	}
	
	public void addItemAmount(Item item, int amount) {
		this.addItemStack(new ItemStack(item, amount));
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Inventory:\n");
		for(ItemStack is : items) {
			sb.append(items.indexOf(is)+1);
			sb.append(") ");
			sb.append(is);
			sb.append("\n");
		}
		return sb.toString();
	}
}
