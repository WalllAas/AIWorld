package model.item;

import model.item.crafting.Crafts;

public class Items {
	public static final Item WOOD = new Item("wood", "Wood");
	public static final Item STONE = new Item("stone", "Stone");
	public static final Item WOODEN_PICKAXE = new Item("wooden_pickaxe", "Wooden Pickaxe", Crafts.WOODEN_PICKAXE_CRAFT);
	public static final Item STONE_PICKAXE = new Item("stone_pickaxe", "Stone Pickaxe", Crafts.STONE_PICKAXE_CRAFT);
}
