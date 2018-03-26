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

/**
 * Servlet implementation class SupprClients
 */
@WebServlet(name = "SupprClients", urlPatterns = { "/SupprClients" })
public class SupprClients extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SupprClients() {
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
			// récupération du tableau de clients pour l'envoyer dans le select de la JSP
			Clients client = new Clients();
			ArrayList<String> tabClients = new ArrayList<String>();
			tabClients = Clients.RecupClient();
			request.setAttribute("lesClients", tabClients);

			this.getServletContext().getRequestDispatcher("/WEB-INF/supprClients.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/noConnect.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// récupération des saisies de la jsp
		String listeClients = request.getParameter("listeClients");

		// extraction de l'id client de la chaine selectionné
		StringTokenizer st = new StringTokenizer(listeClients, " ");
		String idC = st.nextToken();

		// création de l'objet renseignant ses attributs
		Clients client = new Clients();
		client.setId(idC);
		client.SupprClients();
		this.getServletContext().getRequestDispatcher("/WEB-INF/validation.jsp").forward(request, response);

	}

}
