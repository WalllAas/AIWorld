package launch;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.entity.BaseEntity;
import model.world.Map;
import model.world.thread.WorldThread;

public class Launcher extends Application{
	
	public static void main(String[] args) {
		Map map = new Map();
		WorldThread wt = new WorldThread(map);
		new Thread(wt).start();
		
		BaseEntity e = new BaseEntity(map, "1");
//		BaseEntity e2 = new BaseEntity(map, "2");
		e.startAI();
//		e2.startAI();
		
//		Application.launch(Launcher.class, args);
		
	}
	
	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AIWorld Control Panel");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250, Color.LIGHTGREEN);
        Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(80);
        btn.setText("Pause/Resume");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Hello World");
            }
        });
        root.getChildren().add(btn);        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	

}
