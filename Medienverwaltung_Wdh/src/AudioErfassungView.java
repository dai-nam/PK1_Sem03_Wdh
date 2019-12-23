
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

public class AudioErfassungView extends Stage {

	Audio audio;

	public AudioErfassungView(Stage primaryStage, Audio audio) {
		this.audio = audio;
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

		Label l2 = new Label("Interpret: ");
		GridPane.setHgrow(l2, Priority.NEVER);
		GridPane.setHalignment(l2, HPos.RIGHT);
		TextField tf2 = new TextField();
		GridPane.setHgrow(tf2, Priority.ALWAYS);
		gp.addRow(1, l2, tf2);

		Label l3 = new Label("Jahr: ");
		GridPane.setHgrow(l3, Priority.NEVER);
		GridPane.setHalignment(l3, HPos.RIGHT);
		TextField tf3 = new TextField();
		GridPane.setHgrow(tf3, Priority.ALWAYS);
		gp.addRow(2, l3, tf3);
		
		Label l4 = new Label("Dauer: ");
		GridPane.setHgrow(l4, Priority.NEVER);
		GridPane.setHalignment(l4, HPos.RIGHT);
		TextField tf4 = new TextField();
		GridPane.setHgrow(tf4, Priority.ALWAYS);
		gp.addRow(3, l4, tf4);

		Button b1 = new Button("Neu");
		Button b2 = new Button("Abbrechen");
		HBox hb1 = new HBox(b1, b2);
		hb1.setPadding(new Insets(20, 0, 10, 60));
		hb1.setSpacing(20);
		gp.add(hb1, 1, 4);

		Scene scene = new Scene(gp);
		this.setScene(scene);
		this.show();

		this.setMinWidth(this.getWidth());
		this.setMinHeight(this.getHeight());
		this.setMinHeight(this.getHeight());
		this.setMaxHeight(this.getHeight());

	}

}
