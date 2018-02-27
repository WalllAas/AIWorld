package model.entity;

import java.util.List;

import model.entity.ai.BaseEntityAI;
import model.entity.inventory.Inventory;
import model.refs.Dir;
import model.world.Map;
import model.world.tile.Tile;

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
			System.out.println(String.format("Entity %s moving toward %s | Pos %s", this.id, dir, this.pos));
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
		System.out.println("Scanning area !");
		List<Tile> tilesInSight = this.map.getPolygonTilesFromPos(this.pos, lastDirection, this.sight);
		Tile objTile = null;
		
		if(tilesInSight != null && !tilesInSight.isEmpty()){
			boolean done = false;
			int count = 0;
			while(!done && count < tilesInSight.size()){
				if(tilesInSight.get(count).containsTree() || tilesInSight.get(count).containsRock()){
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
		//TODO problem while harvesting new item (ex: you have wood in inventory and try to harvest stone)
		if(this.pos.containsTree() || this.pos.containsRock()) {
			
			this.inventory.addItemAmount(this.pos.getStructure().getDrop(), 1);
			this.pos.breakStructure();
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
