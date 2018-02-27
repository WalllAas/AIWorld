package model.world.structure;

import model.item.Item;

public class Structure {

	protected Item drop;
	
	public Structure() {
	}
	
	
	public Item getDrop(){
		return this.drop;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
