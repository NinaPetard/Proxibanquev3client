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
import com.objis.proxibanque.domaine.Client;
import com.objis.proxibanque.domaine.Compte;
import com.objis.proxibanque.domaine.Conseiller;
import com.objis.proxibanque.service.ServiceCompte;
import com.objis.proxibanque.service.ServiceConseiller;


/**
 * Servlet implementation class MaServlet
 */
/**
 * @author KR Cette Servlet regroupe les méthodes de traitement, liés à la gestion des virements et à 
 * son éxécution.
 * Elle permet de reçevoir une requête client lié à l'authentification, effectue le traitement
 * et renvoie le résultat.
 *
 */
@WebServlet("/ServletVirement")
public class ServletVirement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVirement() {
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
	 * Méthode permettant le traitement de la requête HTTP pour l'éxécution du virement. Elle prend en compte tous
	 * les cas d'erreurs à savoir : 
	 * - Montant du virement supérieur au solde du compte choisi à débiter
	 * - Le type de Compte choisi à créditer n'appartenant pas au client
	 * - Le type de Compte du client à créditer = type de compte du client à débiter
	 * Elle renvoi vers la page permettant d'effectuer le virement.
	 * @param request Objet de type HttpServletRequest contenant la requête HTTP et donne accès à toutes ses informations
	 * @param response Objet de type HttpServletResponse qui initialise la réponse HTTP et qui sera renvoyée au client
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Récupération des paramètres de la requête
		
		int id_client = Integer.parseInt(request.getParameter("idclient"));
		String type_compte_debit = request.getParameter("typecompte_debit");
		String type_compte_credit = request.getParameter("typecompte_credit");
		int montant_virement1 = Integer.parseInt(request.getParameter("montant_virement"));
		
		Compte compte1 = new Compte(id_client,type_compte_credit);
 
		Compte compte2= new Compte(id_client, type_compte_debit);
		
		//Conseiller conseiller = new Conseiller(login, pwd);
		ServiceConseiller service = new ServiceConseiller();
		DaoConseiller dao = new DaoConseiller();
		ServiceCompte service_compte = new ServiceCompte();
		//Client client = new Client(nom_client,prenom_client);
		RequestDispatcher dispatcher;
		
		
		if(!type_compte_debit.equals(type_compte_credit)) {
			if(service_compte.Verifcompte(compte1)== true) {
		
			
				if(service_compte.VerifSolde(compte2, montant_virement1)==true) {
					Compte compte_aftervirement = new Compte(id_client,type_compte_debit,service_compte.Nouveau_Solde(compte2, montant_virement1));
				
					service_compte.UpdateCompte_NewSolde(compte_aftervirement);
					HttpSession maSession = request.getSession();
					maSession.setAttribute("NouveauSolde", compte_aftervirement);
					dispatcher = request.getRequestDispatcher("Accueil2.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					dispatcher = request.getRequestDispatcher("Erreur-Virement1.jsp");
					dispatcher.forward(request, response);
				}
			
			}
			else
			{
				
				dispatcher = request.getRequestDispatcher("Erreur-Virement2.jsp");
				dispatcher.forward(request, response);
			
			}
	 }
		else
		{
			
			dispatcher = request.getRequestDispatcher("Erreur-Virement3.jsp");
			dispatcher.forward(request, response);
		}
	}
}
