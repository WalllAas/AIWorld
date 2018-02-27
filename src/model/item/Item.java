package model.item;

import model.item.crafting.Craft;
import model.item.crafting.CraftingMaterial;

public class Item {
	
	private String id;
	private String name;
	
	private Craft craft;
	
	public Item(String id, String name) {
		this.id = id;
		this.name = name;
		craft = new Craft();
	}
	
	public Item(String id, String name, Craft craft) {
		this(id, name);
		this.craft = craft;
	}
	
	public void addCraftingMaterials(Item item, int amount){
		craft.addCraftingMaterial(new CraftingMaterial(item, amount));
	}
	
	public void addaddCraftingMaterials(Item kItem){
		addCraftingMaterials(kItem, 1);
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
