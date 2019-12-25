package Datenhaltung;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import fachlogik.Medium;

public class Medienliste implements Serializable{

	private static final long serialVersionUID = 9072727940676826777L;
	List<Medium> medien;

	public Medienliste() {
		medien = new LinkedList<Medium>();
	}

	public List<Medium> getList() {
		return this.medien;
	}
	
	public void setList(List <Medium> liste) {
		this.medien = liste;
	}

}
