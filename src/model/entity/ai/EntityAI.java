package model.entity.ai;

import model.entity.Entity;
import model.world.tile.Tile;

public abstract class EntityAI implements Runnable{
	
	protected Entity entity;
	
	protected Tile objectiveTile;
	
	protected boolean cancelled = false;
	protected boolean paused = false;
	
	public EntityAI(Entity entity) {
		this.entity = entity;
	}
	
	public void pause() {
		paused=true;
	}
	public void resume() {
		paused = false;

	}
	
	public void cancel(){
		cancelled = true;
	}
	
	protected void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
