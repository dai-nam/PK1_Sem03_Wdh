package Datenhaltung;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import fachlogik.Audio;
import fachlogik.Bild;
import fachlogik.Medium;

public class ImplementierungDAO2 implements IDao {

	String name;

	public ImplementierungDAO2() {
		this.name = "C:\\Users\\Michael\\Desktop\\Medien.txt";
	}

	@Override
	public void speichern(List<Medium> liste) throws PersistenzException {
		if (name == null)
			return;

		File file = new File(name);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			for (Medium m : liste)
				m.druckeDaten(fos);
			System.out.println("Medien gespeichert.");
		} catch (FileNotFoundException e) {
			throw new PersistenzException("Fehler beim Speichern");
		}
	}

	@Override
	public List<Medium> laden() throws PersistenzException {
		List<Medium> liste = new LinkedList<Medium>();

		File file = new File(name);
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains("Spieldauer")) {
					int a = line.indexOf("\"");
					int b = line.indexOf("\" von ");
					String titel = line.substring(a + 1, b);
					int c = line.indexOf(" von ");
					int d = line.indexOf(" aus ");
					String interpret = line.substring(c + 5, d);
					int e = line.indexOf(" aus ");
					int f = line.indexOf(" Spieldauer");
					String jahr = line.substring(e + 5, f);
					int g = line.indexOf(" Spieldauer: ");
					int h = line.indexOf(" sek.");
					String dauer = line.substring(g + 13, h);

					Audio audio = new Audio(titel, Integer.parseInt(jahr), interpret, Integer.parseInt(dauer));
					liste.add(audio);
				} else {
					int a = line.indexOf("\"");
					int b = line.indexOf("\" aufgenommen ");
					String titel = line.substring(a + 1, b);
					int c = line.indexOf(" im Jahr ");
					int d = line.indexOf(" in ");
					String jahr = line.substring(c + 9, d);
					int e = line.indexOf(" in ");
					int f = line.length();
					String ort = line.substring(e + 4, f);

					Bild bild = new Bild(titel, Integer.parseInt(jahr), ort);
					liste.add(bild);
				}
			}
			Medium.setNumMedium(liste.size());
			System.out.println("Medien geladen");
		} catch (IOException e) {
			throw new PersistenzException("Fehler bein Laden");
		}
		return liste;
	}

}
