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
 * @author KR Cette Servlet regroupe les méthodes de traitement, liés au formulaire 
 * d'authentification du conseiller.
 * Elle permet de reçevoir une requête client lié à l'authentification, effectue le traitement
 * et renvoie le résultat.
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
	 * Méthode permettant le traitement de la requête HTTP d'authentification du conseiller ainsi
	 * que la gestion des erreurs, à savoir la mauvaise identification.
	 * @param request Objet de type HttpServletRequest contenant la requête HTTP et donne accès à toutes ses informations
	 * @param response Objet de type HttpServletResponse qui initialise la réponse HTTP et qui sera renvoyée au client
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Récupération des paramètres de la requête
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
