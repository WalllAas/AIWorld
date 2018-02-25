package model.world;

import launch.Launcher;
import model.item.Item;

public class Tree {
	
	private Item drop;
	
	public Tree() {
		this.drop = Launcher.WOOD;
	}
	
	
	public Item getDrop(){
		return this.drop;
	}

}
