package fachlogik;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.time.LocalDate;

public abstract class Medium implements Comparable, Serializable {

	private static final long serialVersionUID = -6716628616023135458L;
	private static int numMedium;
	private int id;
	private String titel;
	private int jahr;

	public Medium(String titel, int jahr) {
		this.titel = titel;
		this.jahr = jahr;
		this.id = numMedium++;
	}

	public int alter() {
		return LocalDate.now().getYear() - jahr;
	}

	public void druckeAlter() {
		System.out.println("\"" + titel + "\"" + " ist " + alter() + " Jahre alt.");
	}

	public abstract void druckeDaten();

	public void druckeDaten(OutputStream stream) {
		PrintStream pw = new PrintStream(stream);
		pw.print(toString() + "\n");
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Medium) {
			if (this.titel.equals(((Medium) other).getTitel()) && this.jahr == ((Medium) other).getJahr())
				return true;
		}
		return false;
	}

	public void compareMedia(Medium other) {
		if (this.equals(other)) {
			System.out.println("Medium " + id + " und Medium " + other.id + " sind fachlich gleich");
			System.out.println("Beide Medien haben den Hashcode: " + this.hashCode());
		} else {
			System.out.println("Medium " + id + " und Medium " + other.id + " sind unterschiedlich");
			System.out.println("Medium 1 Hashcode: " + this.hashCode() + ",   Medium 2 Hashcode: " + other.hashCode());
		}
	}

	@Override
	public int compareTo(Object other) {
		return this.jahr - ((Medium) other).jahr;
	}

	@Override
	public abstract String toString();

	@Override
	public int hashCode() {
		return toString().hashCode();
	};

	// Getter und Setter
	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public int getJahr() {
		return jahr;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static void setNumMedium(int i) {
		numMedium = i;
	}

}
