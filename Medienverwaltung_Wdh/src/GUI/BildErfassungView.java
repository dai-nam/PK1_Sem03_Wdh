package GUI;

import fachlogik.Bild;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BildErfassungView extends Stage {

	Bild bild;

	public BildErfassungView(Stage primaryStage, Bild bild) {
		this.bild = bild;
		this.initOwner(primaryStage);
		this.initModality(Modality.WINDOW_MODAL);
	}

	public void showView() {
		GridPane gp = new GridPane();
		gp.setPadding(new Insets(10));
		gp.setHgap(10);
		gp.setVgap(10);

		Label l1 = new Label("Titel: ");
		GridPane.setHgrow(l1, Priority.NEVER);
		GridPane.setHalignment(l1, HPos.RIGHT);
		TextField tf1 = new TextField();
		tf1.setPrefWidth(400);
		GridPane.setHgrow(tf1, Priority.ALWAYS);
		gp.addRow(0, l1, tf1);

		Label l2 = new Label("Ort: ");
		GridPane.setHgrow(l2, Priority.NEVER);
		GridPane.setHalignment(l2, HPos.RIGHT);
		TextField tf2 = new TextField();
		GridPane.setHgrow(tf2, Priority.ALWAYS);
		gp.addRow(1, l2, tf2);

		Label l3 = new Label("Aufnahmejahr: ");
		GridPane.setHgrow(l3, Priority.NEVER);
		GridPane.setHalignment(l3, HPos.RIGHT);
		TextField tf3 = new TextField();
		GridPane.setHgrow(tf3, Priority.ALWAYS);
		gp.addRow(2, l3, tf3);

		Button b1 = new Button("Neu");
		Button b2 = new Button("Abbrechen");
		HBox hb1 = new HBox(b1, b2);
		hb1.setPadding(new Insets(20, 0, 10, 60));
		hb1.setSpacing(20);
		gp.add(hb1, 1, 3);

		if (bild != null) {
			tf1.setText(bild.getTitel());
			tf2.setText(bild.getOrt());
			tf3.setText(Integer.toString(bild.getJahr()));
		}

		Scene scene = new Scene(gp);
		this.setScene(scene);
		this.show();

		this.setMinWidth(this.getWidth());
		this.setMinHeight(this.getHeight());
		this.setMinHeight(this.getHeight());
		this.setMaxHeight(this.getHeight());

		// Event Handling
		b1.setOnAction(e -> {
			bild.setTitel(tf1.getText());
			bild.setOrt(tf2.getText());
			bild.setJahr(Integer.parseInt(tf3.getText()));
		});

	}

}
