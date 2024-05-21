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
				escudo.setId(rs.getInt(1));
				escudo.setNombre(rs.getString(2));
				escudo.setCapacidad_defensa(rs.getInt(3));
				
				escudos.add(escudo);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return escudos;
	}
}
