package model.world.tile;

import model.world.structure.Rock;
import model.world.structure.Structure;
import model.world.structure.Tree;

public class Tile {
	
	private int x;
	private int y;
	
	private Structure structure;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void addElement(Structure s){
		this.structure = s;
	}
	
	public boolean containsTree(){
		return this.structure != null && this.structure instanceof Tree;
	}
	
	public boolean containsRock() {
		return this.structure != null && this.structure instanceof Rock;
	}
	
	public void breakStructure() {
		this.structure = null;
	}
	
	public Structure getStructure() {
		return this.structure;
	}
	
	@Override
	public String toString() {
		
		return String.format("Tile(%s,%s)", this.x, this.y);
	}

}
