package model.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.entity.Entity;
import model.refs.Dir;

public class Map {
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	
	private List<List<Tile>> tiles = new ArrayList<>();
	private List<Entity> entities = new ArrayList<>();
	
	public Map() {
		Random r = new Random();
		for(int y = 0; y < HEIGHT; y++){
			List<Tile> tilesList = new ArrayList<>(); 
			for(int x = 0; x < WIDTH; x++){
				Tile tile = new Tile(x, y);
				
				int i = r.nextInt(15);
				if(i == 1){
					tile.addElement(new Tree());
				}
				
				tilesList.add(tile);
			}
			tiles.add(tilesList);
		}
	}
	
	public void addEntities(Entity e){
		entities.add(e);
	}
	
	public Tile getAdjacentTile(Tile tile, Dir dir){
		switch(dir){
		case NORTH:
			if(tile.getY()==0){
				return null;
			}
			else{
				return tiles.get(tile.getY()-1).get(tile.getX());
			}
		case EAST:
			if(tile.getX()==WIDTH-1){
				return null;
			}
			else{
				return tiles.get(tile.getY()).get(tile.getX()+1);
			}
		case SOUTH:
			if(tile.getY()==HEIGHT-1){
				return null;
			}
			else{
				return tiles.get(tile.getY()+1).get(tile.getX());
			}
		case WEST:
			if(tile.getX()==0){
				return null;
			}
			else{
				return tiles.get(tile.getY()).get(tile.getX()-1);
			}
		default:
			return null;
		}
	}
	
	public Tile getRandomTile(){
		Random r = new Random();
		int i = r.nextInt(WIDTH);
		int j = r.nextInt(HEIGHT);
		return tiles.get(j).get(i);
	}
	
	public List<Tile> getPolygonTilesFromPos(Tile pos, Dir dir, int length){
		List<Tile> resultTiles = new ArrayList<>();
		if(dir != null){
			Tile front = null;
			switch(dir.getAxis()){
			case "Y":
				front = this.tiles.get(pos.getY()+dir.getDirValue()).get(pos.getX());
				break;
			case "X":
				front = this.tiles.get(pos.getY()).get(pos.getX()+dir.getDirValue());
				break;
			}
			resultTiles.add(front);
			
			Tile t1 = null;
			Tile t2 = null;
			Tile t3 = null;
			for(int i = 1; i < length-1; i++) {
				//FIXME try catch
				switch(dir.getAxis()){
				case "Y":
					t1 = this.tiles.get(pos.getY()+(dir.getDirValue()*i)).get(pos.getX()+1);
					t2 = this.tiles.get(pos.getY()+(dir.getDirValue()*i)).get(pos.getX()-1);
					t3 = this.tiles.get(pos.getY()+(dir.getDirValue()*(i+1))).get(pos.getX());
					break;
				case "X":
					t1 = this.tiles.get(pos.getY()+1).get(pos.getX()+(dir.getDirValue()*i));
					t2 = this.tiles.get(pos.getY()-1).get(pos.getX()+(dir.getDirValue()*i));
					t3 = this.tiles.get(pos.getY()).get(pos.getX()+(dir.getDirValue()*(i+1)));
					break;
				}
				resultTiles.add(t1);
				resultTiles.add(t2);
				resultTiles.add(t3);
			}
			
			
			return resultTiles;
		}
		
		else{
			return null;
		}
		
		
	}

}
