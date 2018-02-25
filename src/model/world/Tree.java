package model.world;

import model.item.Item;
import model.item.Items;

public class Tree {
	
	private Item drop;
	
	public Tree() {
		this.drop = Items.WOOD;
	}
	
	
	public Item getDrop(){
		return this.drop;
	}

}
