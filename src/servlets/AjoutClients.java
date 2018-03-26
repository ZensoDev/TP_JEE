package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Clients;

/**
 * Servlet implementation class AjoutClients
 */
@WebServlet(name = "AjoutClients", urlPatterns = { "/AjoutClients" })
public class AjoutClients extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjoutClients() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// déclaration de la varibale session qui est récupéré
		HttpSession sessionLog = request.getSession();

		// si elle est = à Ok alors l'identification s'est bien passé, possibilité
		// d'accés à la page
		// sinon message d'erreur
		if (sessionLog.getAttribute("SessLog") == "OK") {
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutClients.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/noConnect.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// récupération des saisies de la jsp
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		// création de l'objet renseignant de ses attributs
		Clients client = new Clients();
		client.setNom(nom);
		client.setPrenom(prenom);

		// lancement de la méthode d'ajout client avec l'objet créé
		client.AjtClient();

		// page de confirmation
		this.getServletContext().getRequestDispatcher("/WEB-INF/validation.jsp").forward(request, response);

	}

}
