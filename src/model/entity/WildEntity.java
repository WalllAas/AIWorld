package model.entity;

import model.refs.Dir;
import model.world.Map;
import model.world.Tile;

public class WildEntity extends Entity{

	public WildEntity(Map map, String id) {
		super(map, id);
		
	}

	@Override
	public void startAI() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void walk(Dir dir) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void walkTo(Tile obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tile scanArea() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void harvest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void craft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fight() {
		// TODO Auto-generated method stub
		
	}

}
