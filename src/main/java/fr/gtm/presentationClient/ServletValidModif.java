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
import com.objis.proxibanque.service.ServiceClient;
import com.objis.proxibanque.service.ServiceConseiller;
import fr.gtm.domaineClient.Client;


/** @author KR Cette Servlet regroupe les m�thodes de traitement, li�s � l'enregistrement des
 * modifications du clients.
 * Elle permet de re�evoir une requ�te client li� � l'authentification, effectue le traitement
 * et renvoie le r�sultat.
 * Servlet implementation class MaServlet
 */
@WebServlet("/ServletValidModif")
public class ServletValidModif extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletValidModif() {
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
	 * M�thode permettant le traitement de la requ�te HTTP pour la validation des
	 *  modifications des donn�es du client s�lectionn�
	 * @param request Objet de type HttpServletRequest contenant la requ�te HTTP et donne acc�s � toutes ses informations
	 * @param response Objet de type HttpServletResponse qui initialise la r�ponse HTTP et qui sera renvoy�e au client
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//R�cup�ration des param�tres de la requ�te
		int id_client = Integer.parseInt(request.getParameter("idclient"));
		int id_conseiller=Integer.parseInt(request.getParameter("idconseiller"));
		String nom_init = request.getParameter("nom");
		String prenom_init = request.getParameter("prenom");
		String email = request.getParameter("email");
		String adresse = request.getParameter("adresse");
		Client client2 = new Client(id_client,nom_init, prenom_init,email,adresse,id_conseiller);
		ServiceClient service_cli = new ServiceClient();
		service_cli.ModifierClient(client2);
		ServiceConseiller service_cons = new ServiceConseiller();
		RequestDispatcher dispatcher;
		
		HttpSession maSession = request.getSession();
		maSession.setAttribute("Liste", service_cons.AffichageListeClients(client2));
		
		
		dispatcher = request.getRequestDispatcher("Accueil1.jsp");
		
		
		dispatcher.forward(request, response);
		
		
	}

	

}
