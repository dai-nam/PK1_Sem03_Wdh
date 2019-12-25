package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Datenhaltung.Medienliste;
import fachlogik.Audio;
import fachlogik.Bild;
import fachlogik.EmptyFilenameException;
import fachlogik.Medienverwaltung;
import fachlogik.Medium;

public class MenuView {

	Medienverwaltung mv;
	Scanner scn;

	public MenuView(Medienverwaltung mv) {
		this.mv = mv;
	}

	public void show() {
		System.out.println("\nMedienverwaltung\n");
		System.out.println("1. Audio aufnehmen");
		System.out.println("2. Bild aufnehmen");
		System.out.println("3. Zeige alle Medien");
		System.out.println("4. Zeige neues Medium");
		System.out.println("5. Berechne durchschnittliches Erscheinungsjahr");
		System.out.println("6. Medienliste in Datei schreiben");
		System.out.println("7. Laden");
		System.out.println("8. Speichern");
		System.out.println("9. Beenden\n");
		System.out.println("Bitte Menuepunkt waehlen:");
		System.out.println("-------------------------------------");
	}

	public int selectProgram() {
		scn = new Scanner(System.in);
		boolean gueltigeEingabe = false;
		int auswahl = -1;
		while (!gueltigeEingabe) {
			auswahl = scn.nextInt();
			if (auswahl > 0 && auswahl < 10)
				gueltigeEingabe = true;
			else
				System.out.println("Ungültige Eingabe!");
		}
//		scn.close();
		return auswahl;
	}

	public void runProgram(int auswahl) {

		switch (auswahl) {
		case 1:
			audioAufnehmen();
			break;
		case 2:
			bildAufnehmen();
			break;
		case 3:
			Collections.sort(mv.getMedien());
			mv.zeigeMedien();
			break;
		case 4:
			System.out.println(mv.sucheNeuesMedium());
			break;
		case 5:
			System.out.println(mv.berechneErscheinungsjahr());
			break;
		case 6:
			Collections.sort(mv.getMedien());
			boolean validName = false;
			while (!validName) {
				try {
					String name = dateiPfadEingabe();
					medienListeInDatei(name);
					validName = true;
				} catch (EmptyFilenameException e) {
					if (e.getSelected() == 0)
						continue;
					else if (e.getSelected() == 2)
						break;
				}
			}
			break;
		case 7:
			serialisiertLaden();
			break;
		case 8:
			serialisiertSpeichern();
			break;
		case 9:
			System.out.println("Programm beendet");
			scn.close();
			System.exit(0);
			break;
		default:
			break;
		}
	}

	private void audioAufnehmen() {
		String titel = null;
		String interpret = null;
		Integer jahr = null;
		Integer dauer = null;

		boolean titelGesetzt = false;
		while (!titelGesetzt) {
			titel = JOptionPane.showInputDialog(null, "Titel");
			if (titel == null)
				return;
			if (titel.equals(""))
				JOptionPane.showMessageDialog(null, "Bitte gültigen Titel eingeben.");
			else
				titelGesetzt = true;
		}

		boolean jahrGesetzt = false;
		while (!jahrGesetzt) {
			String x = JOptionPane.showInputDialog(null, "Erscheinungsjahr");
			if (x == null)
				return;
			else {
				try {
					jahr = Integer.parseInt(x);
					jahrGesetzt = true;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Bitte gültiges Jahr eingeben.");
				}
			}
		}

		boolean interpretGesetzt = false;
		while (!interpretGesetzt) {
			interpret = JOptionPane.showInputDialog(null, "Interpret");
			if (interpret == null)
				return;
			if (interpret.equals(""))
				JOptionPane.showMessageDialog(null, "Bitte gültigen Interpreten eingeben.");
			else
				interpretGesetzt = true;
		}

		boolean dauerGesetzt = false;
		while (!dauerGesetzt) {
			String y = (JOptionPane.showInputDialog(null, "Dauer"));
			if (y == null)
				return;
			else {
				try {
					dauer = Integer.parseInt(y);
					dauerGesetzt = true;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Bitte gültige Dauer eingeben.");
				}
			}
		}
		mv.getMedien().add(new Audio(titel, jahr, interpret, dauer));

	}

	private void bildAufnehmen() {
		String titel = JOptionPane.showInputDialog(null, "Titel");
		int jahr = Integer.parseInt(JOptionPane.showInputDialog(null, "Erscheinungsjahr"));
		String ort = JOptionPane.showInputDialog(null, "Ort");
		mv.getMedien().add(new Bild(titel, jahr, ort));
	}

	private String dateiPfadEingabe() throws EmptyFilenameException {
		String pfad = "C:\\Users\\Michael\\Desktop";
		String name = "";
		name = JOptionPane.showInputDialog(null, "Dateiname");
		if (name == null)
			return null;
		else if (name.equals(""))
			throw new EmptyFilenameException();

		return pfad + "\\" + name + ".txt";
	}

	private void medienListeInDatei(String name) {
		if (name == null)
			return;

		File file = new File(name);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			for (Medium m : mv.getMedien())
				m.druckeDaten(fos);
		} catch (FileNotFoundException e) {
		}

	}

	private void serialisiertLaden() {
		File file = new File("C:\\Users\\Michael\\Desktop\\Medienliste.ser");
		Medienliste ml = null;

		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
			ml = (Medienliste) ois.readObject();
			mv.setMedienliste(ml);
			Medium.setNumMedium(ml.getList().size());
			System.out.println("Medienliste geladen");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Fehler bei Deserialisierung");
		}
	}

	private void serialisiertSpeichern() {
		File file = new File("C:\\Users\\Michael\\Desktop\\Medienliste.ser");
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(mv.getMedienliste());
			System.out.println("Medienliste gespeichert.");
		} catch (IOException e) {
			System.out.println("Fehler bei Serialisierung");
		}
	}

}
