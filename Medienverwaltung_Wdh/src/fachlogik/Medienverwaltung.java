package fachlogik;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Datenhaltung.IDao;
import Datenhaltung.PersistenzException;

public class Medienverwaltung {

	List<Medium> medien;
	IDao dao;

	public Medienverwaltung(IDao dao) {
		medien = new LinkedList<Medium>();
		this.dao = dao;
	}

	public List<Medium> laden() {
		try {
			return medien = dao.laden();
		} catch (PersistenzException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void speichern() {
		try {
			dao.speichern(medien);
		} catch (PersistenzException e) {
			e.printStackTrace();
		}
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

	public void setMedien(List<Medium> medien) {
		this.medien = medien;
	}

	public Iterator<Medium> iterator() {
		return medien.iterator();
	}

}
