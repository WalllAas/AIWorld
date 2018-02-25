package model.refs;

public enum Dir {
	
	NORTH("Y", -1), EAST("X", 1), SOUTH("Y", 1), WEST("X", -1);
	
	private String axis;
	private int value;
	
	private Dir(String axis, int value) {
		this.axis = axis;
		this.value = value;
	}

	public String getAxis() {
		return this.axis;
	}
	
	public int getDirValue(){
		return value;
	}
}
