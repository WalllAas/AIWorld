package model.entity;

import model.entity.ai.WildEntityAI;
import model.refs.Dir;
import model.world.Map;
import model.world.tile.Tile;

public class WildEntity extends Entity{

	public WildEntity(Map map, String id) {
		super(map, id);
		
	}

	@Override
	public void startAI() {
		this.ai = new WildEntityAI(this);
		
		new Thread(this.ai).start();
		
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
