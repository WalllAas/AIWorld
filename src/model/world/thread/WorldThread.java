package model.world.thread;

import model.world.Map;
import thread.AbstractLoop;
import thread.LoopsRegister;

public class WorldThread extends AbstractLoop{
	
	private Map map;
	
	private int tick;
	private long time;
	
//	private List<AbstractLoop> allLoops;
	
	public WorldThread(Map map) {
		this.tick = 0;
		this.time = System.currentTimeMillis();
//		allLoops = new ArrayList<>();
		this.map = map;
	}

	@Override
	protected void loop() {
		
		this.tick+=System.currentTimeMillis()-this.time;
		this.time = System.currentTimeMillis();
		
		sleep(1000);
	}
	
	@Override
	public void pause() {
		for(AbstractLoop al : LoopsRegister.getAllLoops()) {
			al.pause();
		}
	}
	
	@Override
	public void resume() {
		for(AbstractLoop al : LoopsRegister.getAllLoops()) {
			al.resume();
		}
	}


}
