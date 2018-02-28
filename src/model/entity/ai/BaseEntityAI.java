package model.entity.ai;

import model.entity.Entity;
import model.refs.Dir;

public class BaseEntityAI extends EntityAI{

	public BaseEntityAI(Entity entity) {
		super(entity);
	}
	
	@Override
	public void loop() {
			
		
		if(objectiveTile !=null){
			System.out.println(String.format("Objective targeted! (%s,%s) Structure(%s)", objectiveTile.getX(), objectiveTile.getY(), objectiveTile.getStructure()));
			while(this.entity.getPos() != objectiveTile){
				this.entity.walkTo(objectiveTile);
				
				sleep(300);
			}
			System.out.println(String.format("Harvesting %s...", objectiveTile.getStructure().getDrop()));
			this.entity.harvest();
			objectiveTile = null;
			System.out.println("Objective reached!");
		}else{
			System.out.println("No objectives!");
			int i = R.nextInt(4);
			
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
	
		
		sleep(300);
	}
	
	
}
