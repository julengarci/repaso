package controladorCaballero;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.Conector;
import modeloArma.Arma;
import modeloArma.ArmaModelo;
import modeloCaballero.Caballero;
import modeloCaballero.CaballeroModelo;
import modeloEscudo.Escudo;
import modeloEscudo.EscudoModelo;

/**
 * Servlet implementation class InsertCaballero
 */
@WebServlet("/InsertCaballero")
public class InsertCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCaballero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Conector conector = new Conector();
		ArmaModelo am = new ArmaModelo();
		am.setConector(conector);
		
		EscudoModelo em = new EscudoModelo();
		em.setConector(conector);
		
		ArrayList<Arma> armas = am.getArmas();
		ArrayList<Escudo> escudos = em.getEscudos();
		
		request.setAttribute("escudos", escudos);
		request.setAttribute("armas", armas);
		request.setAttribute("validacion", request.getParameter("validacion"));
		
		request.getRequestDispatcher("FormularioCaballero.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean validacion = false;
		Caballero caballero = new Caballero();

		String nombre = request.getParameter("nombre");
		int fuerza;

		if (request.getParameter("fuerza").equals("")) {
			fuerza = 0;
		}else {
			fuerza = Integer.parseInt(request.getParameter("fuerza"));
			int experiencia = Integer.parseInt(request.getParameter("experiencia"));
			String foto = request.getParameter("foto");

			if (request.getParameter("arma").equals("arma") || request.getParameter("escudo").equals("escudo")) {
				validacion = false;
			}
			else {
				int id_arma = Integer.parseInt(request.getParameter("arma"));
				int id_escudo = Integer.parseInt(request.getParameter("escudo"));
				
				caballero.setNombre(nombre);
				caballero.setFuerza(fuerza);
				caballero.setExperiencia(experiencia);
				caballero.setFoto(foto);
				
				Arma arma = new Arma();
				arma.setId(id_arma);
				caballero.setArma(arma);
				
				Escudo escudo = new Escudo();
				escudo.setId(id_escudo);
				caballero.setEscudo(escudo);
				
				Conector conector = new Conector();
				CaballeroModelo cm = new CaballeroModelo();
				cm.setConector(conector);
				
				boolean existe = cm.checkNombreDisponible(caballero);
				
				if (existe || caballero.getNombre() == null || caballero.getExperiencia() > 100 || caballero.getExperiencia() < 0 || caballero.getFuerza() > 100 || caballero.getFuerza() < 0) {
					validacion = false;
					response.sendRedirect("InsertCaballero?validacion="+validacion);
				}else {
					cm.insertCaballero(caballero);
					validacion = true;
					request.setAttribute("validacion", validacion);
					request.getRequestDispatcher("IndexCaballero").forward(request, response);
				}
			}
		}
		
	}

}
