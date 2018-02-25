package launch;

public class Test {
	
	public static final Item WOOD = new Item("wood");
	
	public static void main(String[] args) {		
		Map map = new Map();
		Entity e = new Entity(map, "1");
		Entity e2 = new Entity(map, "2");
		e.startAI();
		e2.startAI();
	}

}
