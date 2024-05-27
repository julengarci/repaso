package controladorCaballero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.Conector;
import modeloCaballero.Caballero;
import modeloCaballero.CaballeroModelo;

/**
 * Servlet implementation class DeleteCaballero
 */
@WebServlet("/DeleteCaballero")
public class DeleteCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCaballero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Conector conector = new Conector();
		CaballeroModelo cm = new CaballeroModelo();
		cm.setConector(conector);
		
		String eliminar = request.getParameter("eliminar");
		
		String[] eliminaciones = eliminar.split(",");
		
		ArrayList<String> lista = new ArrayList<>(Arrays.asList(eliminaciones));
		
		boolean existe = true;
		
		for (int i = 0; i < eliminaciones.length && existe; i++) {
			Caballero caballero = cm.getCaballero(Integer.parseInt(lista.get(i)));
			if (cm.checkId(caballero) == false) {
				existe = false;
			}
		}
		
		if (existe) {
			for (String id_caballero : lista) {
				cm.deleteCaballero(Integer.parseInt(id_caballero));
			}
		}
		
		response.sendRedirect("IndexCaballero");
		
		

	}

}
