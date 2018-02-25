package model.entity.ai;

import model.entity.Entity;
import model.world.Tile;

public abstract class EntityAI implements Runnable{
	
	protected Entity entity;
	
	protected Tile objectiveTile;
	
	protected boolean cancelled = false;
	
	public EntityAI(Entity entity) {
		this.entity = entity;
	}
	
	public void cancel(){
		cancelled = true;
	}

}
