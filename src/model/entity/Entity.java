package model.entity;

import java.util.List;

import model.entity.ai.EntityAI;
import model.refs.Dir;
import model.world.Map;
import model.world.Tile;

public class Entity {
	
	public static final int SIGHT = 5;
	
	private String id;
	private EntityNeed objectives;
	
	private Map map;
	private Tile pos;
	
	private Dir lastDirection;
	
	private EntityAI ai;
	
	public Entity(Map map, String id) {
		this.map = map;
		this.id = id;
		
		this.pos = map.getRandomTile();
		System.out.println(String.format("Entity %s created", this.id));
//		startAI();
		
	}
	
	public void setObjectives(EntityNeed objectives){
		this.objectives = objectives;
	}
	
	public void startAI(){
		ai = new EntityAI(this);
		Thread t = new Thread(ai);
		t.start();
	}
	
	//-------------- behavior ------------------
	// default behavior
	/**
	 * Move the entity in a direction
	 * @param dir n, e, s, w
	 */
	public void walk(Dir dir){
		// move entity in map
		Tile adjTile = this.map.getAdjacentTile(this.pos, dir);
		if(adjTile != null){
			lastDirection = dir;
			this.pos = adjTile;
			System.out.println(String.format("Entity %s moving toward %s	|	Tree present? %s", this.id, dir, this.pos.containsTree()));
		}
		else{
			System.out.println(String.format("Cannot move toward %s", dir));
		}	
		
	}
	
	/**
	 * Move the entity toward a specific Tile
	 * @param obj
	 */
	public void walkTo(Tile obj){
		// pathfinding
		if(this.pos.getX() != obj.getX()){
			this.walk(this.pos.getX() - obj.getX() > 0 ? Dir.WEST : Dir.EAST);
		}
		else if(this.pos.getY() != obj.getY()){
			this.walk(this.pos.getY() - obj.getY() > 0 ? Dir.NORTH : Dir.SOUTH);
		}
	}
	
	/**
	 * Scan area to find an objective to go to
	 * @return
	 */
	public Tile scanArea(){
		List<Tile> sight = this.map.getPolygonTilesFromPos(this.pos, lastDirection, SIGHT);
		Tile objTile = null;
		
		if(sight != null && !sight.isEmpty()){
			boolean done = false;
			int count = 0;
			while(!done && count < sight.size()){
				if(sight.get(count).containsTree()){
					objTile = sight.get(count);
					done = true;
				}
				count++;
			}
			return objTile;
		}else{
			return null;
		}
		
	}
	
	public void harvest(){
		
	}
	
	public void craft(){
		
	}
	
	public void fight(){
		
	}
	
	public Tile getPos(){
		return this.pos;
	}
	
	
	
	

}
