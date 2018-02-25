package launch;

import model.entity.BaseEntity;
import model.item.Item;
import model.world.Map;

public class Launcher {
	
	public static void main(String[] args) {		
		Map map = new Map();
		BaseEntity e = new BaseEntity(map, "1");
//		BaseEntity e2 = new BaseEntity(map, "2");
		e.startAI();
//		e2.startAI();
	}

}
