package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Utilisateurs;

/**
 * Servlet implementation class Authentification
 */
@WebServlet(name = "Authentification", urlPatterns = { "/Authentification" })
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Authentification() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// page demandant l'authentification
		this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean verif;

		// récupération des saisies de la jsp
		String nom = request.getParameter("nomUser");
		String mdp = request.getParameter("mdpUser");

		// création des variables de sessions pour le nom et log
		HttpSession sessionNom = request.getSession();
		HttpSession sessionLog = request.getSession();

		// création de l'objet Utilisateur avec les données saisies
		Utilisateurs user = new Utilisateurs(nom, mdp);

		// appel a la méthode pour vérifier la correspondance du nom et mdp
		verif = user.VerifUser();
		user.VerifUser();

		// si la méthode renvoi true: la variable SessLog prendra la valeur "OK" et
		// permettra l'accés aux autres pages, le nom également sera conserver et
		// affiché en permanence
		if (verif == true) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/validation.jsp").forward(request, response);
			sessionNom.setAttribute("SessNom", user.getNomUser());
			sessionLog.setAttribute("SessLog", "OK");
		} else {
			sessionLog.invalidate();
			request.setAttribute("logKo", "Erreur de saisie");
			this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(request, response);
		}
	}

}
