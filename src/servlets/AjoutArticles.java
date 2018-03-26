package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Articles;

/**
 * Servlet implementation class AjoutArticles
 */
@WebServlet(name = "AjoutArticles", urlPatterns = { "/AjoutArticles" })

public class AjoutArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutArticles() {
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
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutArticles.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/noConnect.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// récupération des saisies de la jsp
		String designation = request.getParameter("designation");
		int prix = Integer.parseInt(request.getParameter("prix"));
		int stock = Integer.parseInt(request.getParameter("stock"));

		// création de l'objet renseignement de ses attributs
		Articles article = new Articles();
		article.setDesignation(designation);
		article.setPrixU(prix);
		article.setEtatStock(stock);

		// lancement de la méthode d'ajout article avec l'objet créé
		article.AjtArticle();

		// page de confirmation
		this.getServletContext().getRequestDispatcher("/WEB-INF/validation.jsp").forward(request, response);

	}

}
