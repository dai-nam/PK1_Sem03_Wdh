import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Hauptfenster extends Application {

	public void start(Stage stage) {

		Pane pane = new Pane();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();

//		Audio a1 = new Audio("Schön sein", 1999, "Die Toten Hosen", 180);
//		Bild b1 = new Bild("Mona Lisa", 1600, "Paris");
		AudioErfassungView aev = new AudioErfassungView(stage, null);
		BildErfassungView bev = new BildErfassungView(stage, null);
		aev.showView();
//		bev.showView();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
