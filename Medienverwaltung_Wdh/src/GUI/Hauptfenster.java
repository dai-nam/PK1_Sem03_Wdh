package GUI;

import fachlogik.Audio;
import fachlogik.Bild;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Hauptfenster extends Application {

	public void start(Stage stage) {

		BorderPane bp = new BorderPane();
		MenuBar menubar = new MenuBar();
		Menu datei = new Menu("Datei");
		MenuItem mi1 = new MenuItem("Laden");
		MenuItem mi2 = new MenuItem("Speichern");
		MenuItem mi3 = new MenuItem("Medienliste in Datei");
		MenuItem mi4 = new MenuItem("Beenden");
		datei.getItems().addAll(mi1, mi2, new SeparatorMenuItem(), mi3, new SeparatorMenuItem(), mi4);

		Menu medium = new Menu("Medium");
		MenuItem mi5 = new MenuItem("Audio neu");
		MenuItem mi6 = new MenuItem("Bild neu");
		medium.getItems().addAll(mi5, mi6);
		
		Menu anzeige = new Menu("Anzeige");
		MenuItem mi7 = new MenuItem("Erscheinungsjahr");
		MenuItem mi8 = new MenuItem("Neuestes Medium");
		anzeige.getItems().addAll(mi7, mi8);
		
		menubar.getMenus().addAll(datei, medium, anzeige);

		bp.setTop(menubar);

		Scene scene = new Scene(bp);
		stage.setScene(scene);
		stage.show();

		stage.setMinWidth(600);
		stage.setMinHeight(300);

//		Audio a1 = new Audio("Schön sein", 1999, "Die Toten Hosen", 180);
		Bild b1 = new Bild("Mona Lisa", 1600, "Paris");
		AudioErfassungView aev = new AudioErfassungView(stage, null);
		BildErfassungView bev = new BildErfassungView(stage, b1);
		// aev.showView();
		bev.showView();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
