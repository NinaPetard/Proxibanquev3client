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


/** @author KR Cette Servlet regroupe les m�thodes de traitement, li�s au formulaire 
 * de modification des donn�es de chaque client.
 * Elle permet de re�evoir une requ�te client li� � la modification des donn�es, effectue le traitement
 * et renvoie le r�sultat.
 * Servlet implementation class MaServlet
 */
@WebServlet("/ServletModifClient")
public class ServletModifClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifClient() {
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
	 * M�thode permettant le traitement de la requ�te HTTP de modification des donn�es du client s�lectionn�
	 * @param request Objet de type HttpServletRequest contenant la requ�te HTTP et donne acc�s � toutes ses informations
	 * @param response Objet de type HttpServletResponse qui initialise la r�ponse HTTP et qui sera renvoy�e au client
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//R�cup�ration des param�tres de la requ�te
		int idconseiller = Integer.parseInt(request.getParameter("idconseiller"));
		int idclient = Integer.parseInt(request.getParameter("idclient"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String codePostal = request.getParameter("codepostal");
		String ville = request.getParameter("ville");
		String telephone = request.getParameter("telephone");
		
		
		Client client1 = new Client(idclient,nom, prenom,adresse, codePostal,ville, telephone);
		//ServiceClient service_cli = new ServiceClient();
		RequestDispatcher dispatcher;
		
		
		HttpSession maSession = request.getSession();
		maSession.setAttribute("Session_SaveID", client1);
		
		
		dispatcher = request.getRequestDispatcher("ModifInfoClient.jsp");
		
		dispatcher.forward(request, response);
		
		
	}

	

}
