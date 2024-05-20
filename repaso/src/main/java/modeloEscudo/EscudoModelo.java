package modeloEscudo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.Conector;

public class EscudoModelo {

	private Conector conector;

	public Conector getConector() {
		return conector;
	}

	public void setConector(Conector conector) {
		this.conector = conector;
	}
	
	public ArrayList<Escudo> getEscudos(){
		ArrayList<Escudo> escudos = new ArrayList<Escudo>();
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement("SELECT * FROM ESCUDOS");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Escudo escudo = new Escudo();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return escudos;
	}
}
