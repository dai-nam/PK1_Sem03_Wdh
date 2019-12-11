import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {

	Medienverwaltung mv;
	Scanner scn;

	public Menu(Medienverwaltung mv) {
		this.mv = mv;
	}

	public void show() {
		System.out.println("\nMedienverwaltung\n");
		System.out.println("1. Audio aufnehmen");
		System.out.println("2. Bild aufnehmen");
		System.out.println("3. Zeige alle Medien");
		System.out.println("4. Zeige neues Medium");
		System.out.println("5. Berechne durchschnittliches Erscheinungsjahr");
		System.out.println("6. Beenden\n");
		System.out.println("Bitte Menuepunkt waehlen:");
		System.out.println("-------------------------------------");
	}

	public int selectProgram() {
		scn = new Scanner(System.in);
		boolean gueltigeEingabe = false;
		int auswahl = -1;
		while (!gueltigeEingabe) {
			auswahl = scn.nextInt();
			if (auswahl > 0 && auswahl < 7)
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
			mv.zeigeMedien();
			break;
		case 4:
			System.out.println(mv.sucheNeuesMedium());
			break;
		case 5:
			System.out.println(mv.berechneErscheinungsjahr());
			break;
		case 6:
			System.out.println("Programm beendet");
			scn.close();
			System.exit(0);
			break;
		default:
			break;
		}
	}

	private void audioAufnehmen() {
		String titel = JOptionPane.showInputDialog(null, "Titel");
		int jahr = Integer.parseInt(JOptionPane.showInputDialog(null, "Erscheinungsjahr"));
		String interpret = JOptionPane.showInputDialog(null, "Interpret");
		int dauer = Integer.parseInt(JOptionPane.showInputDialog(null, "Dauer"));
		mv.getMedien().add(new Audio(titel, jahr, interpret, dauer));
	}

	private void bildAufnehmen() {
		String titel = JOptionPane.showInputDialog(null, "Titel");
		int jahr = Integer.parseInt(JOptionPane.showInputDialog(null, "Erscheinungsjahr"));
		String ort = JOptionPane.showInputDialog(null, "Ort");
		mv.getMedien().add(new Bild(titel, jahr, ort));
	}
}
