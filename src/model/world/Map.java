package model.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.entity.Entity;
import model.refs.Dir;

public class Map {
	public static final int TREE_RARITY = 10;
	
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	
	private List<List<Tile>> tiles = new ArrayList<>();
	private List<Entity> entities = new ArrayList<>();
	
	public Map() {
		Random r = new Random();
		int trees = 0;
		for(int y = 0; y < HEIGHT; y++){
			List<Tile> tilesList = new ArrayList<>();
			
			for(int x = 0; x < WIDTH; x++){
				Tile tile = new Tile(x, y);
				
				int i = r.nextInt(TREE_RARITY);
				if(i == 1){
					tile.addElement(new Tree());
					trees++;
				}
				
				tilesList.add(tile);
			}
			tiles.add(tilesList);
		}
		System.out.println(String.format("Number of trees : %s", trees));
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
	
	private Tile getTileFromCoords(int x, int y) {
		Tile t = null;
		try {
			this.tiles.get(y).get(x);
		}catch(IndexOutOfBoundsException e) {
//			System.out.println(String.format("Tile at (%s,%s) is not in bounds, sorry!", x, y));
		}
		return t;
	}
	
	public List<Tile> getPolygonTilesFromPos(Tile pos, Dir dir, int length){
		List<Tile> resultTiles = new ArrayList<>();
		if(dir != null){
			Tile front = null;
			switch(dir.getAxis()){
			case "Y":
				front = getTileFromCoords(pos.getY()+dir.getDirValue(), pos.getX());
				break;
			case "X":
				front = getTileFromCoords(pos.getY(), pos.getX()+dir.getDirValue());
				break;
			}
			resultTiles.add(front);
			
			Tile t1 = null;
			Tile t2 = null;
			Tile t3 = null;
			for(int i = 1; i < length-1; i++) {
				
				switch(dir.getAxis()){
				case "Y":
					t1 = getTileFromCoords(pos.getY()+(dir.getDirValue()*i), pos.getX()+1);
					t2 = getTileFromCoords(pos.getY()+(dir.getDirValue()*i), pos.getX()-1);
					t3 = getTileFromCoords(pos.getY()+(dir.getDirValue()*(i+1)), pos.getX());
					break;
				case "X":
					t1 = getTileFromCoords(pos.getY()+1, pos.getX()+(dir.getDirValue()*i));
					t2 = getTileFromCoords(pos.getY()-1, pos.getX()+(dir.getDirValue()*i));
					t3 = getTileFromCoords(pos.getY(), pos.getX()+(dir.getDirValue()*(i+1)));
					break;
				}
				resultTiles.add(t1);
				resultTiles.add(t2);
				resultTiles.add(t3);
			}
			resultTiles.removeIf(t -> t == null);
			
			return resultTiles;
		}
		
		else{
			return null;
		}
		
		
	}

}
