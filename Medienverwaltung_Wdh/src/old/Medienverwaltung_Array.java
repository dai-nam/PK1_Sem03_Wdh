package old;
import Medium;

public class Medienverwaltung_Array {

	Medium[] medien;
	int anzahl = 0;

	public Medienverwaltung_Array() {
		medien = new Medium[3];
	}

	public boolean aufnehmen(Medium m) {
		for (int i = 0; i < anzahl; i++)
			if (medien[i].equals(m)) {
				System.out.println("Medium schon vorhanden");
				return false;
			}

		if (anzahl >= medien.length) {
			System.out.println("Kein Platz mehr!");
			return false;
		}

		medien[anzahl++] = m;
		System.out.println("Medium " + m.getTitel() + " aufgenommen.");
		return true;
	}

	public void zeigeMedien() {
		for (int i = 0; i < anzahl; i++)
			medien[i].druckeDaten();
	}

	public Medium sucheNeuesMedium() {
		if (anzahl <= 0)
			return null;
		Medium m = medien[0];
		for (int i = 0; i < anzahl; i++)
			if (medien[i].getJahr() > m.getJahr())
				m = medien[i];
		return m;
	}

	public int berechneErscheinungsjahr() {
		if (anzahl <= 0)
			return 0;
		int summe = 0;
		for (int i = 0; i < anzahl; i++)
			summe += medien[i].getJahr();

		return summe / anzahl;

	}
}
