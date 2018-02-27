package model.item.crafting;

import java.util.ArrayList;
import java.util.List;

public class Craft {

	private List<CraftingMaterial> craftingMaterials = new ArrayList<>();
	
	public Craft() {
		//
	}
	
	public Craft(CraftingMaterial...craftingMaterials) {
		for (CraftingMaterial cm : craftingMaterials) {
			this.craftingMaterials.add(cm);
		}
	}
	
	public void addCraftingMaterial(CraftingMaterial cm) {
		this.craftingMaterials.add(cm);
	}
}
