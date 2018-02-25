package model.entity.ai;

import java.util.Random;

import model.entity.Entity;
import model.refs.Dir;
import model.world.Tile;

public class EntityAI implements Runnable{
	
	private Entity entity;
	
	private Tile objectiveTile;
	
	private boolean cancelled = false;
	
	public EntityAI(Entity entity) {
		this.entity = entity;
	}

	@Override
	public void run() {
		Random r = new Random();
		while(!cancelled){
			
			if(objectiveTile !=null){
				while(this.entity.getPos() != objectiveTile){
					this.entity.walkTo(objectiveTile);
				}
				System.out.println("Objective reached!");
			}else{
				int i = r.nextInt(4);
				
				if(i==0){
					entity.walk(Dir.NORTH);
				}else if(i==1){
					entity.walk(Dir.EAST);
				}else if(i==2){
					entity.walk(Dir.SOUTH);
				}else{
					entity.walk(Dir.WEST);
				}
				
				objectiveTile = entity.scanArea();
			}
			
			
			
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void cancel(){
		cancelled = true;
	}

}
