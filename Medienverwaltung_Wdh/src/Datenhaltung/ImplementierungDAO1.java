package Datenhaltung;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import fachlogik.Medium;

public class ImplementierungDAO1 implements IDao {


	@Override
	public void speichern(List<Medium> liste) throws PersistenzException {
		File file = new File("C:\\Users\\Michael\\Desktop\\Medien.ser");
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(liste);
			System.out.println("Medien gespeichert.");
		} catch (IOException e) {
			throw new PersistenzException("Fehler bei Serialisierung");
		}
	}

	@Override
	public List<Medium> laden() throws PersistenzException {
		File file = new File("C:\\Users\\Michael\\Desktop\\Medien.ser");
		List<Medium> liste = null;

		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
			liste = (List<Medium>) ois.readObject();
			Medium.setNumMedium(liste.size());
			System.out.println("Medien geladen");
			return liste;
		} catch (IOException | ClassNotFoundException e) {
			throw new PersistenzException("Fehler bei Deserialisierung");
		}
	}

}
