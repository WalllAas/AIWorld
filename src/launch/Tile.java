package launch;

public class Tile {
	
	private int x;
	private int y;
	
	private Tree tree;
	
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
	
	public void addElement(Tree t){
		this.tree = t;
	}
	
	public boolean containsTree(){
		return this.tree != null;
	}

}
