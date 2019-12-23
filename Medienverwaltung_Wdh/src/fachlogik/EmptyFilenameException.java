package fachlogik;
import javax.swing.JOptionPane;

public class EmptyFilenameException extends Exception {

	private int selected;

	public EmptyFilenameException() {
		super();
		selected = JOptionPane.showConfirmDialog(null, "Leerer Dateiname. Erneut eingeben?", "Hinweis",
				JOptionPane.OK_CANCEL_OPTION);
	}

	public int getSelected() {
		return this.selected;
	}

}
