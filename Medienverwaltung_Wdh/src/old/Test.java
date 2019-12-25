package fachlogik;
import Datenhaltung.Medienliste;
import GUI.MenuView;

public class Test {

	public static void main(String[] args) {
//		Medium m1 = new Audio("It means nothing", 2007, "Stereophonics", 229);
//		Medium m2 = new Bild("Gebaeude FB Informatik", 2018, "Dortmund");
//		Medium m3 = new Bild("Gebaeude FB Design", 2016, "Dortmund");
//		Medium m4 = new Bild("Gebaeude FB Maschinenbau", 2000, "Dortmund");
//		Medium m5 = new Audio("It means nothing", 2007, "Stereophonics", 229);
//
//		Medienverwaltung mv = new Medienverwaltung();
//		mv.aufnehmen(m1);
//		mv.aufnehmen(m2);
//		mv.aufnehmen(m3);
//		mv.aufnehmen(m4);
//		mv.aufnehmen(m5);
//
//		mv.zeigeMedien();
//		System.out.println(mv.berechneErscheinungsjahr());
//		System.out.println(mv.sucheNeuesMedium());

		Medienliste medienliste = new Medienliste();
		Medienverwaltung mv = new Medienverwaltung(medienliste);
		MenuView menu = new MenuView(mv);
		menu.show();
		int auswahl = -1;
		while (true) {
			auswahl = menu.selectProgram();
			menu.runProgram(auswahl);
			menu.show();

		}

	}
}
