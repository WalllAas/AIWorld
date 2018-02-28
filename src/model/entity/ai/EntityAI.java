package model.entity.ai;

import model.entity.Entity;
import model.world.tile.Tile;
import thread.AbstractLoop;

public abstract class EntityAI extends AbstractLoop{
	
	protected Entity entity;
	
	protected Tile objectiveTile;
	
	
	public EntityAI(Entity entity) {
		this.entity = entity;
	}

}
