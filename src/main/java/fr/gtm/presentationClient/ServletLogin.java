package fr.gtm.presentationClient;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.objis.proxibanque.dao.DaoConseiller;
import fr.gtm.domaineClient.Conseiller;
import com.objis.proxibanque.service.ServiceConseiller;


/**
 * Servlet implementation class MaServlet
 */
/**
 * @author KR Cette Servlet regroupe les m�thodes de traitement, li�s au formulaire 
 * d'authentification du conseiller.
 * Elle permet de re�evoir une requ�te client li� � l'authentification, effectue le traitement
 * et renvoie le r�sultat.
 */
@WebServlet("/Servletlogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * M�thode permettant le traitement de la requ�te HTTP d'authentification du conseiller ainsi
	 * que la gestion des erreurs, � savoir la mauvaise identification.
	 * @param request Objet de type HttpServletRequest contenant la requ�te HTTP et donne acc�s � toutes ses informations
	 * @param response Objet de type HttpServletResponse qui initialise la r�ponse HTTP et qui sera renvoy�e au client
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//R�cup�ration des param�tres de la requ�te
		String login = request.getParameter("loginuser");
		String pwd = request.getParameter("mdpuser");
		
		Conseiller conseiller = new Conseiller(login, pwd);
		ServiceConseiller service = new ServiceConseiller();
		DaoConseiller dao = new DaoConseiller();
			
	
		
		if(service.VerifConseiller(conseiller)==true)
		{
			RequestDispatcher dispatcher;
			HttpSession maSession = request.getSession();
			maSession.setAttribute("Liste", service.AffichageListeClients(conseiller));
			dispatcher = request.getRequestDispatcher("Accueil.jsp");
			dispatcher.forward(request, response);
			
		}
		else
		{
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("login-erreur.html");
			dispatcher.forward(request, response);
		}
		
		
		
	}

	

}
