package launch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
				
				int i = r.nextInt(2);
				if(i == 1){
					tile.addElement(new Tree());
				}
				
				tilesList.add(tile);
//				System.out.println("(" + x + ":" + y + ")");
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
			switch(dir){
			case NORTH:
			case SOUTH:
				front = this.tiles.get(pos.getY()+dir.getDirValue()).get(pos.getX());
				break;
			case EAST:
			case WEST:
				front = this.tiles.get(pos.getY()).get(pos.getX()+dir.getDirValue());
				break;
			}
			resultTiles.add(front);
			return resultTiles;
		}
		
		else{
			return null;
		}
		
		
	}

}
