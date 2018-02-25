package launch;

import model.entity.Entity;
import model.item.Item;
import model.world.Map;

public class Launcher {
	
	public static final Item WOOD = new Item("wood");
	
	public static void main(String[] args) {		
		Map map = new Map();
		Entity e = new Entity(map, "1");
		Entity e2 = new Entity(map, "2");
		e.startAI();
		e2.startAI();
	}

}
