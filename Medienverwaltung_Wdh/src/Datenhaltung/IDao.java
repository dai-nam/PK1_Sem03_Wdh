package Datenhaltung;

import java.util.List;
import fachlogik.Medium;

public interface IDao {

	public void speichern(List<Medium> liste) throws PersistenzException;

	public List<Medium> laden() throws PersistenzException;
	
}
