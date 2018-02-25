package model.refs;

public enum Dir {
	
	NORTH(-1), EAST(1), SOUTH(1), WEST(-1);
	
	private int value;
	
	private Dir(int value) {
		this.value = value;
	}

	
	public int getDirValue(){
		return value;
	}
}
