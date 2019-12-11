import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Medienverwaltung {

	List<Medium> medien;

	public Medienverwaltung() {
		this.medien = new LinkedList<>();
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
		Collections.sort(medien);
		for (Medium m : medien)
			m.druckeDaten();
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
}
//	public int berechneErscheinungsjahr() {
//		if (medien.size() <= 0)
//			return 0;
//		int summe = 0;
//		for (Medium m : medien)
//			summe += m.getJahr();
//
//		return summe / medien.size();
//
//	}
//}
