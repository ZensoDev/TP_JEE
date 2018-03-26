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

import bean.Clients;
import bean.Commandes;

/**
 * Servlet implementation class AjoutCommandes
 */
@WebServlet(name = "AjoutCommandes", urlPatterns = { "/AjoutCommandes" })

public class AjoutCommandes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjoutCommandes() {
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

			// récupération du tableau de client afin de l'envoyer en affichage dans le
			// select de la jsp
			Clients client = new Clients();
			ArrayList<String> tabClients = new ArrayList<String>();
			tabClients = Clients.RecupClient();
			request.setAttribute("lesClients", tabClients);

			this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutCommandes.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/noConnect.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// récupération des saisies de la jsp
		String date = request.getParameter("date");
		String numC = request.getParameter("numC");
		String listeClients = request.getParameter("listeClients");

		// dans la chaine de caractère je récupère le premier ensemble séparé par un " "
		// qui correspond au num de commande
		StringTokenizer st = new StringTokenizer(listeClients, " ");
		int idC = Integer.parseInt(st.nextToken());

		// création de l'objet renseignant de ses attributs
		Commandes commande = new Commandes();
		commande.setNumeroCmd(numC);
		commande.setDate(date);
		commande.setId(idC);

		// lancement de la méthode d'ajout de commande avec l'objet créé
		commande.AjtCommande();

		// page de confirmation
		this.getServletContext().getRequestDispatcher("/WEB-INF/validation.jsp").forward(request, response);

	}

}
