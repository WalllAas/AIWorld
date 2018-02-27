package model.item.crafting;

import model.item.Items;

public class Crafts {
	
	public static final Craft WOODEN_PICKAXE_CRAFT = new Craft(new CraftingMaterial(Items.WOOD, 3));
	public static final Craft STONE_PICKAXE_CRAFT = new Craft(new CraftingMaterial(Items.WOOD, 1), new CraftingMaterial(Items.STONE, 2));

}
