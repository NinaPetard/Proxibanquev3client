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
import com.objis.proxibanque.domaine.Conseiller;
import com.objis.proxibanque.service.ServiceClient;
import com.objis.proxibanque.service.ServiceCompte;
import com.objis.proxibanque.service.ServiceConseiller;
import com.objis.proxibanque.domaine.Client;


/**
 * Servlet implementation class MaServlet
 */
/**
 * @author KR Cette Servlet regroupe les méthodes de traitement, liés à l'affichage de la liste
 * des comptes du client sélectionné.
 * Elle permet de reçevoir une requête client lié à l'authentification, effectue le traitement
 * et renvoie le résultat.
 *
 */
@WebServlet("/ServletCompte")
public class ServletCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCompte() {
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
	 * Méthode permettant le traitement de la requête HTTP pour la gestion de l'affichage 
	 * des comptes du clients sélectionné.
	 * @param request Objet de type HttpServletRequest contenant la requête HTTP et donne accès à toutes ses informations
	 * @param response Objet de type HttpServletResponse qui initialise la réponse HTTP et qui sera renvoyée au client
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Récupération des paramètres de la requête
		int id_client = Integer.parseInt(request.getParameter("idclient"));
		
		
		RequestDispatcher dispatcher;
		ServiceCompte service_compte = new ServiceCompte();
		
		Client client3 = new Client(id_client);
		HttpSession maSession = request.getSession();
		maSession.setAttribute("Listecompte", service_compte.AffichageListeCompte(client3));
		dispatcher = request.getRequestDispatcher("VoirCompteClient.jsp");
			
		
		
	
		dispatcher.forward(request, response);
		
		
	}

	

}
