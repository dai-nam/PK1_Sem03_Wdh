package old;

import java.util.LinkedList;
import java.util.List;

import Medium;

public class Medienverwaltung_unsicher {

	List medien;

	public Medienverwaltung_unsicher() {
		medien = new LinkedList();
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
		for (Object o : medien)
			if (o instanceof Medium)
				((Medium) o).druckeDaten();
	}

	public Medium sucheNeuesMedium() {
		if (medien.size() <= 0)
			return null;
		Medium m = (Medium) medien.get(0);
		for (Object o : medien) {
			Medium medium = (Medium) o;
			if (medium.getJahr() > m.getJahr())
				m = medium;
		}
		return m;
	}

	public int berechneErscheinungsjahr() {
		if (medien.size() <= 0)
			return 0;
		int summe = 0;
		for (Object o : medien) {
			Medium medium = (Medium) o;
			summe += medium.getJahr();
		}

		return summe / medien.size();

	}
}
