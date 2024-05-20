package controladorArma;

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

/**
 * Servlet implementation class IndexArma
 */
@WebServlet("/IndexArma")
public class IndexArma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexArma() {
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
		
		ArrayList<Arma> armas = am.getArmas();
		
		request.setAttribute("armas", armas);
		
		request.getRequestDispatcher("PanelArmas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
