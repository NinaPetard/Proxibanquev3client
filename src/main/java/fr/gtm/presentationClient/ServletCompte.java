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
 * @author KR Cette Servlet regroupe les m�thodes de traitement, li�s � l'affichage de la liste
 * des comptes du client s�lectionn�.
 * Elle permet de re�evoir une requ�te client li� � l'authentification, effectue le traitement
 * et renvoie le r�sultat.
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
	 * M�thode permettant le traitement de la requ�te HTTP pour la gestion de l'affichage 
	 * des comptes du clients s�lectionn�.
	 * @param request Objet de type HttpServletRequest contenant la requ�te HTTP et donne acc�s � toutes ses informations
	 * @param response Objet de type HttpServletResponse qui initialise la r�ponse HTTP et qui sera renvoy�e au client
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//R�cup�ration des param�tres de la requ�te
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
