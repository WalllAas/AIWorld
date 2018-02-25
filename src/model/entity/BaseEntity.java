package model.entity;

import java.util.List;

import model.entity.ai.BaseEntityAI;
import model.entity.inventory.Inventory;
import model.refs.Dir;
import model.world.Map;
import model.world.Tile;

public class BaseEntity extends Entity{
	
	private Inventory inventory;
	
	public BaseEntity(Map map, String id) {
		super(map, id);
		sight = 5;
		inventory = new Inventory();
	}
	
	
	//-------------- behavior ------------------
	
	@Override
	public void startAI() {
		ai = new BaseEntityAI(this);
		Thread t = new Thread(ai);
		t.start();
		
	}
	
	@Override
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
	
	@Override
	public void walkTo(Tile obj){
		// pathfinding
		if(this.pos.getX() != obj.getX()){
			this.walk(this.pos.getX() - obj.getX() > 0 ? Dir.WEST : Dir.EAST);
		}
		else if(this.pos.getY() != obj.getY()){
			this.walk(this.pos.getY() - obj.getY() > 0 ? Dir.NORTH : Dir.SOUTH);
		}
	}
	
	@Override
	public Tile scanArea(){
		List<Tile> tilesInSight = this.map.getPolygonTilesFromPos(this.pos, lastDirection, this.sight);
		Tile objTile = null;
		
		if(tilesInSight != null && !tilesInSight.isEmpty()){
			boolean done = false;
			int count = 0;
			while(!done && count < tilesInSight.size()){
				if(tilesInSight.get(count).containsTree()){
					objTile = tilesInSight.get(count);
					done = true;
				}
				count++;
			}
			return objTile;
		}else{
			return null;
		}
		
	}
	
	@Override
	public void harvest(){
		if(this.pos.containsTree()) {
			
			this.inventory.addItemAmount(this.pos.getTree().getDrop(), 1);
			this.pos.breakTree();
		}
		System.out.println(this.inventory);
	}
	
	@Override
	public void craft(){
		
	}
	
	@Override
	public void fight(){
		
	}
	
	

}
