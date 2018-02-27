package model.entity.ai;

import java.util.Random;

import model.entity.Entity;
import model.refs.Dir;

public class BaseEntityAI extends EntityAI{

	public BaseEntityAI(Entity entity) {
		super(entity);
	}
	
	@Override
	public void run() {
		Random r = new Random();
		
		while(!cancelled){
			
			while(!paused) {
				if(objectiveTile !=null){
					System.out.println(String.format("Objective targeted! (%s,%s) Structure(%s)", objectiveTile.getX(), objectiveTile.getY(), objectiveTile.getStructure()));
					while(this.entity.getPos() != objectiveTile){
						this.entity.walkTo(objectiveTile);
						
						sleep(300);
					}
					this.entity.harvest();
					objectiveTile = null;
					System.out.println("Objective reached!");
				}else{
					System.out.println("No objectives!");
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
			}
			
			sleep(300);
		}
		
		
	}

	
	
}
