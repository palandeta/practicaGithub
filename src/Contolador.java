

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Contolador
 */
@WebServlet("/Contolador")
public class Contolador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contolador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Modelo m = new Modelo();
		Boolean resultado = m.esValido(request.getParameter("txtUsuario"));
		request.getSession().setAttribute("usuario", request.getParameter("txtUsuario"));
		if(resultado==true){
			RequestDispatcher r=request.getRequestDispatcher("LoginAceptado.jsp");
			r.forward(request, response);
		}
		else{
			RequestDispatcher r=request.getRequestDispatcher("LoginFallido.jsp");
			r.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
