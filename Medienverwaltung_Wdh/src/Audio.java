import java.io.OutputStream;
import java.io.PrintWriter;

public class Audio extends Medium {

	private static final long serialVersionUID = -3700656455650414332L;
	private String interpret;
	private int dauer;

	public Audio(String titel, int jahr, String interpret, int dauer) {
		super(titel, jahr);
		this.interpret = interpret;
		this.dauer = dauer;
	}

	@Override
	public void druckeDaten() {
		System.out.println(this);
	}



	@Override
	public boolean equals(Object other) {
		if (super.equals(other) && this.interpret.equals(((Audio) other).getInterpret())
				&& this.dauer == ((Audio) other).getDauer())
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "ID= " + this.getId() + " " + "\"" + this.getTitel() + "\" von " + this.getInterpret() + " aus "
				+ this.getJahr() + " Spieldauer: " + this.getDauer() + " sek.";
	}

	// Getter und Setter
	public String getInterpret() {
		return interpret;
	}

	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}

	public int getDauer() {
		return dauer;
	}

	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

}
