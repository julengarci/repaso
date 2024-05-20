package modeloCaballero;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.Conector;

public class CaballeroModelo {

	private Conector conector;

	public Conector getConector() {
		return conector;
	}

	public void setConector(Conector conector) {
		this.conector = conector;
	}

	public ArrayList<Caballero> getCaballeros(){
		
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement("SELECT * FROM CABALLEROS");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Caballero caballero = new Caballero();
				caballero.setId(rs.getInt(1));
				caballero.setNombre(rs.getString(2));
				caballero.setFuerza(rs.getInt(3));
				caballero.setExperiencia(rs.getInt(4));
				caballero.setFoto(rs.getString(5));
				
				caballeros.add(caballero);
			}
		} catch (Exception e) {
			System.out.println("error");
		}
		return caballeros;
	}
	
}
