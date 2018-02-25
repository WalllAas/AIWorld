package model.entity;

import model.entity.ai.EntityAI;
import model.refs.Dir;
import model.world.Map;
import model.world.Tile;

public abstract class Entity {
	/**
	 * Field of view of the entity
	 */
	protected int sight;
	
	/**
	 * ID of entity
	 */
	protected String id;
	/**
	 * Objectives of the entity (Its final goal)
	 */
	protected EntityNeed objectives;
	
	/**
	 * World in which the entity wanders
	 */
	protected Map map;
	/**
	 * The current Tile on which the entity is standing
	 */
	protected Tile pos;
	
	/**
	 * The last direction the entity went towards
	 */
	protected Dir lastDirection;
	
	/**
	 * The AI of the entity (Its behavior)
	 */
	protected EntityAI ai;
	
	public Entity(Map map, String id) {
		this.map = map;
		this.id = id;
		
		this.pos = map.getRandomTile();
		System.out.println(String.format("%s %s created", this.getClass().getSimpleName(), this.id));
		
	}
	
	public abstract void startAI();
	
	//--------------------------------------------------------------------------------------------------------
	
	/**
	 * Move the entity in a direction
	 * @param dir n, e, s, w
	 */
	public abstract void walk(Dir dir);
	
	/**
	 * Move the entity toward a specific Tile
	 * @param obj
	 */
	public abstract void walkTo(Tile obj);
	
	/**
	 * Scan area to find an objective to go to
	 * @return
	 */
	public abstract Tile scanArea();
	
	public abstract void harvest();
	
	public abstract void craft();
	
	public abstract void fight();
	
	
	//--------------------------------------------------------------------------------------------------------
	
	public void setObjectives(EntityNeed objectives){
		this.objectives = objectives;
	}
	
	public Tile getPos(){
		return this.pos;
	}
}
