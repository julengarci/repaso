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
 * Servlet implementation class IndexCaballero
 */
@WebServlet("/IndexCaballero")
public class IndexCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexCaballero() {
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
		
		
		request.getRequestDispatcher("PanelCaballeros.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
