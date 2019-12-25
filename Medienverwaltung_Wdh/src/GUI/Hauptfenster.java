package GUI;


import Datenhaltung.IDao;
import Datenhaltung.ImplementierungDAO1;
import Datenhaltung.ImplementierungDAO2;

import fachlogik.Medienverwaltung;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Hauptfenster extends Application {

	Controller controller;
	Medienverwaltung mv;
	ListView<String> lv;

	public void init() {
		IDao dao = new ImplementierungDAO1();
		mv = new Medienverwaltung(dao);
		lv = new ListView<>();
	}

	public void start(Stage stage) {

		ObservableList<String> obs = lv.getItems();
		Controller controller = new Controller(mv, stage, obs);
		BorderPane bp = new BorderPane();
		MenuBar menubar = new MenuBar();
		Menu datei = new Menu("Datei");
		MenuItem mi1 = new MenuItem("Laden");
		mi1.setOnAction(e -> controller.laden());
		MenuItem mi2 = new MenuItem("Speichern");
		mi2.setOnAction(e -> controller.speichern());
		MenuItem mi4 = new MenuItem("Beenden");
		mi4.setOnAction(e -> System.exit(0));
		datei.getItems().addAll(mi1, mi2, new SeparatorMenuItem(), new SeparatorMenuItem(), mi4);

		Menu medium = new Menu("Medium");
		MenuItem mi5 = new MenuItem("Audio neu");
		mi5.setOnAction(e -> controller.audioAufnehmen());
		MenuItem mi6 = new MenuItem("Bild neu");
		mi6.setOnAction(e -> controller.bildAufnehmen());
		medium.getItems().addAll(mi5, mi6);

		Menu anzeige = new Menu("Anzeige");
		MenuItem mi7 = new MenuItem("Erscheinungsjahr");
		mi7.setOnAction(e -> controller.erscheinungsJahr());
		MenuItem mi8 = new MenuItem("Neuestes Medium");
		mi8.setOnAction(e -> controller.neuesMedium());
		MenuItem mi9 = new MenuItem("Zeige alle Medien");
		mi9.setOnAction(e -> controller.zeigeMedien());
		anzeige.getItems().addAll(mi7, mi8, mi9);

		menubar.getMenus().addAll(datei, medium, anzeige);

		bp.setTop(menubar);
		bp.setCenter(lv);

		Scene scene = new Scene(bp);
		stage.setScene(scene);
		stage.show();

		stage.setMinWidth(600);
		stage.setMinHeight(300);

//		Audio a1 = new Audio("Schön sein", 1999, "Die Toten Hosen", 180);
//		Bild b1 = new Bild("Mona Lisa", 1600, "Paris");
//		AudioErfassungView aev = new AudioErfassungView(stage, null);
//		BildErfassungView bev = new BildErfassungView(stage, b1);
		// aev.showView();
//		bev.showView();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
