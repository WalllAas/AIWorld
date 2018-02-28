package model.entity.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	private List<Slot> slots;
	
	public Inventory() {
		this.slots = new ArrayList<>();
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Inventory:\n");
		
		return sb.toString();
	}
}
