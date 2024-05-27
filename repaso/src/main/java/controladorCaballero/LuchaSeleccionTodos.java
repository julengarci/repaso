package controladorCaballero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.Conector;
import modeloCaballero.Caballero;
import modeloCaballero.CaballeroModelo;


/**
 * Servlet implementation class LuchaSeleccionTodos
 */
@WebServlet("/LuchaSeleccionTodos")
public class LuchaSeleccionTodos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LuchaSeleccionTodos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Conector conector = new Conector();
		CaballeroModelo cm = new CaballeroModelo();
		cm.setConector(conector);
		
		ArrayList<Caballero> caballeros = cm.getCaballeros();
		
		request.setAttribute("caballeros", caballeros);
		
		request.getRequestDispatcher("LuchaTodos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id_caballero = Integer.parseInt(request.getParameter("caballero"));
		
		Conector conector = new Conector();
		CaballeroModelo cm = new CaballeroModelo();
		cm.setConector(conector);
		
		Caballero caballero1 = cm.getCaballero(id_caballero);
		
		ArrayList<Caballero> caballeros = cm.getCaballeros();
		
		Iterator<Caballero> it = caballeros.iterator();
		
		while (it.hasNext()) {
			if (it.next().getId() == id_caballero) {
				it.remove();
			}
		}
		
		request.setAttribute("caballeros", caballeros);
		request.setAttribute("caballero1", caballero1);
		
		request.getRequestDispatcher("LuchaUnoSeleccionado.jsp").forward(request, response);
	}

}
