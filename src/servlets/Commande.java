package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Commandes;

/**
 * Servlet implementation class Commande
 */


@WebServlet(name = "Commande", urlPatterns = { "/Commande" })

public class Commande extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Commande() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// déclaration de la varibale session qui est récupéré
		HttpSession sessionLog = request.getSession();
		
		// si elle est = à Ok alors l'identification s'est bien passé, possibilité
		// d'accés à la page
		// sinon message d'erreur
		if (sessionLog.getAttribute("SessLog") == "OK") {
			// récupération du tableau de commande pour l'envoyer dans le select de la JSP
			Commandes commande = new Commandes();
			ArrayList<String> tabCommandes = new ArrayList<String>();
			tabCommandes = commande.RecupCommande();
			request.setAttribute("lesCommandes", tabCommandes);
			this.getServletContext().getRequestDispatcher("/WEB-INF/commande.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/noConnect.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// récupération des saisies de la jsp
		String listeCommandes = request.getParameter("listeCommandes");

		// extraction du num de la commande de la chaine selectionné
		StringTokenizer stCmd = new StringTokenizer(listeCommandes, " ");
		stCmd.nextToken();
		stCmd.nextToken();
		// en 3e position dans la chaine
		String numC = stCmd.nextToken();
		Commandes commande = new Commandes();
		commande.setNumeroCmd(numC);
		request.setAttribute("infoNumC", numC);
		request.setAttribute("infoClient", commande.InfoCommandeClient());
		request.setAttribute("infoTotal", commande.InfoCommandeTotal());
		
		// récupération du tableau de commande pour l'envoyer dans le select de la JSP
		ArrayList<String> tabCommandes = new ArrayList<String>();
		tabCommandes = commande.RecupCommande();
		request.setAttribute("lesCommandes", tabCommandes);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/commande.jsp").forward(request, response);
	}

}
