package modeloArma;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.Conector;

public class ArmaModelo {

	private Conector conector;

	public Conector getConector() {
		return conector;
	}

	public void setConector(Conector conector) {
		this.conector = conector;
	}
	
	public ArrayList<Arma> getArmas(){
		ArrayList<Arma> armas = new ArrayList<Arma>();
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement("SELECT * FROM ARMAS");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Arma arma = new Arma();
				
				arma.setId(rs.getInt(1));
				arma.setNombre(rs.getString(2));
				arma.setCapacidad_danio(rs.getInt(3));
				arma.setFoto(rs.getString(4));
				
				armas.add(arma);
			}
			
		} catch (Exception e) {
			
		}
		return armas;
	}
}
