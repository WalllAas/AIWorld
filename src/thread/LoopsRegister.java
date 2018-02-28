package thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LoopsRegister {

	
	private static List<AbstractLoop> allLoops = new ArrayList<>();
	
	private LoopsRegister() {}
	
	public static List<AbstractLoop> getAllLoops(){
		return Collections.unmodifiableList(allLoops);
	}
	
	public static void registerAbstractLoop(AbstractLoop al) {
		allLoops.add(al);
	}
	
	public static void registerAbstractLoops(AbstractLoop...abstractLoops) {
		for (AbstractLoop abstractLoop : abstractLoops) {
			registerAbstractLoop(abstractLoop);
		}
	}
}
