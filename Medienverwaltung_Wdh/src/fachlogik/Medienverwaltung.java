package fachlogik;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Medienverwaltung {

	List<Medium> medien;
	Medienliste ml;

	public Medienverwaltung(Medienliste ml) {
		setMedienliste(ml);
	}

	public boolean aufnehmen(Medium m) {
		if (medien.contains(m)) {
			System.out.println("Medium schon vorhanden");
			return false;
		}
		medien.add(m);
		System.out.println("Medium " + m.getTitel() + " aufgenommen.");
		return true;
	}

	public void zeigeMedien() {
		if (medien.size() == 0)
			System.out.println("Medienliste leer!");
		for (Medium m : medien)
//			m.druckeDaten();
			m.druckeDaten(System.out);
	}

	public Medium sucheNeuesMedium() {
		if (medien.size() <= 0)
			return null;

		Medium medium = medien.get(0);
		for (Medium m : medien) {
			if (m.getJahr() > medium.getJahr())
				medium = m;
		}
		return medium;
	}

	public int berechneErscheinungsjahr() {
		if (medien.size() <= 0)
			return 0;
		int summe = 0;
		Iterator<Medium> it = medien.iterator();
		while (it.hasNext()) {
			summe += it.next().getJahr();
		}

		return summe / medien.size();

	}

	public List<Medium> getMedien() {
		return this.medien;
	}

	public Medienliste getMedienliste() {
		return this.ml;
	}

	public void setMedienliste(Medienliste liste) {
		this.ml = liste;
		this.medien = ml.getList();
	}
	
	public Iterator<Medium> iterator(){
		return ml.getList().iterator();
	}
}

