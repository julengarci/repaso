package modeloCaballero;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import com.mysql.cj.jdbc.BlobFromLocator;

import connection.Conector;
import modeloArma.Arma;
import modeloEscudo.Escudo;

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
				
				Arma arma = getArma(rs.getInt(6));
				caballero.setArma(arma);
				
				Escudo escudo = getEscudo(rs.getInt(7));
				caballero.setEscudo(escudo);
				
				caballeros.add(caballero);
			}
		} catch (Exception e) {
			System.out.println("error");
		}
		return caballeros;
	}
	
	private Escudo getEscudo(int id) {
		Escudo escudo = new Escudo();
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement("SELECT * FROM ESCUDOS WHERE ID = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				escudo.setId(rs.getInt(1));
				escudo.setNombre(rs.getString(2));
				escudo.setCapacidad_defensa(rs.getInt(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return escudo;
	}

	public Arma getArma(int id) {
		Arma arma = new Arma();
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement("SELECT * FROM ARMAS WHERE id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				arma.setId(rs.getInt(1));
				arma.setNombre(rs.getString(2));
				arma.setCapacidad_danio(rs.getInt(3));
				arma.setFoto(rs.getString(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arma;
	}

	public void insertCaballero(Caballero caballero) {
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement("INSERT INTO caballeros(nombre,fuerza,experiencia,foto,arma_id,escudo_id) VALUES (?,?,?,?,?,?)");
			pst.setString(1, caballero.getNombre());
			pst.setInt(2, caballero.getFuerza());
			pst.setInt(3,caballero.getExperiencia());
			pst.setString(4, caballero.getFoto());
			pst.setInt(5, caballero.getArma().getId());
			pst.setInt(6, caballero.getEscudo().getId());
			
			pst.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public boolean checkNombreDisponible(Caballero caballero) {
		boolean existe = false;
		try {
			PreparedStatement pst = conector.getConexion().prepareStatement("SELECT * FROM CABALLEROS WHERE NOMBRE= ?");
			pst.setString(1, caballero.getNombre());
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				existe = true;
			}
			else {
				existe = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return existe;
	}
	
}
