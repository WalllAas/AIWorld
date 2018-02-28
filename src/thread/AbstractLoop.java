package thread;

import java.util.Random;

public abstract class AbstractLoop implements Runnable{

	public static final Random R = new Random();
	
	protected boolean cancelled;
	protected boolean paused;
	
	public AbstractLoop() {
		this.cancelled = false;
		this.paused = false;
		
		// Register this loop
		LoopsRegister.registerAbstractLoop(this);
	}
	
	@Override
	public void run() {
		while(!cancelled) {
			while(!paused && !cancelled) {
				loop();
			}
		}
		
	}
	
	protected abstract void loop();
	
	public void cancel() {
		this.cancelled = true;
	}
	
	public void pause() {
		this.paused = true;
	}
	
	public void resume() {
		paused = false;

	}
	
	protected void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
