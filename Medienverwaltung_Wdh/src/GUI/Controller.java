package GUI;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import fachlogik.Audio;
import fachlogik.Bild;
import fachlogik.Medienverwaltung;
import fachlogik.Medium;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class Controller {

	Medienverwaltung mv;
	Stage stage;
	List<String> observableList;

	public Controller(Medienverwaltung mv, Stage stage, ObservableList<String> obs) {
		this.mv = mv;
		this.stage = stage;
		observableList = obs;
	}

	public boolean audioAufnehmen() {
		Audio audio = new Audio(null, 0, null, 0);
		AudioErfassungView aev = new AudioErfassungView(stage, audio);
		aev.showView();
		if (aev.isValid()) {
			mv.aufnehmen(audio);
			System.out.println("Audio aufgenommen");
			updateList();
			return true;
		}
		System.out.println("Audio nicht aufgenommen");
		return false;
	}

	public boolean bildAufnehmen() {
		Bild bild = new Bild(null, 0, null);
		BildErfassungView bev = new BildErfassungView(stage, bild);
		bev.showView();
		if (bev.isValid()) {
			mv.aufnehmen(bild);
			System.out.println("Bild aufgenommen");
			updateList();
			return true;
		}
		System.out.println("Bild nicht aufgenommen");
		return false;
	}

	public void neuesMedium() {
//		System.out.println(mv.sucheNeuesMedium());
		JOptionPane.showMessageDialog(null, mv.sucheNeuesMedium().toString());
	}

	public void erscheinungsJahr() {
//		System.out.println(mv.berechneErscheinungsjahr());
		JOptionPane.showMessageDialog(null, mv.berechneErscheinungsjahr());

	}

	public void speichern() {
		mv.speichern();
	}

	public List<Medium> laden() {
		List<Medium> list = mv.laden();
		updateList();
		return list;
	}

	public void zeigeMedien() {
		Collections.sort(mv.getMedien());
		String string = "";
		for (Medium m : mv.getMedien()) {
			string += m.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, string);

	}

	private void updateList() {
		observableList.clear();
		 for(Medium m : mv.getMedien()) {
			 observableList.add(m.toString());
		 }

	}


}
