package launch;

import java.util.HashMap;

public class Item {
	
	private String id;
	private HashMap<Item, Integer> craftingMaterials = new HashMap<>();
	
	public Item(String id) {
		this.id = id;
	}
	
	public void addCraftingMaterials(Item kItem, int vAmount){
		craftingMaterials.put(kItem, vAmount);
	}
	
	public void addaddCraftingMaterials(Item kItem){
		addCraftingMaterials(kItem, 1);
	}

}
