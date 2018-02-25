package model.entity;

import model.item.Item;

public class EntityNeed {
	
	private Item need;
	
	
	public EntityNeed(Item need) {
		this.need = need;
	}
	
	
	
	public Item getNeed(){
		return need;
	}

}
