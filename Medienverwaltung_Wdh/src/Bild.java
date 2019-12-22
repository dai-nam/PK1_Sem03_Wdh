
public class Bild extends Medium {

	private static final long serialVersionUID = 8376577082474588340L;
	private String ort;

	public Bild(String titel, int jahr, String ort) {
		super(titel, jahr);
		this.ort = ort;
	}

	@Override
	public void druckeDaten() {
		System.out.println(this);
	}

	@Override
	public boolean equals(Object other) {
		if (super.equals(other) && this.ort.equals(((Bild) other).getOrt()))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "ID= " + this.getId() + " " + "\"" + this.getTitel() + "\" aufgenommen im Jahr " + this.getJahr()
				+ " in " + this.getOrt();
	}

	// Getter und Setter
	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

}
