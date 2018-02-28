package model.entity.inventory;

import java.util.ArrayList;
import java.util.List;

import model.item.Item;

public class Slot {

	private List<Item> items;
	
	public Slot() {
		this.items = new ArrayList<>();
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}
}
