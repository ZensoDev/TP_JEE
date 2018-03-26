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

import bean.Articles;
import bean.Clients;
import bean.Commandes;
import bean.LigneCmd;

/**
 * Servlet implementation class LigneCommande
 */
@WebServlet(name = "LigneCommande", urlPatterns = { "/LigneCommande" })
public class LigneCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LigneCommande() {
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
			// récupération du tableau d'article pour l'envoyer dans le select de la JSP
			Articles article = new Articles();
			ArrayList<String> tabArticle = new ArrayList<String>();
			tabArticle = article.RecupArticle();
			request.setAttribute("lesArticles", tabArticle);

			// récupération du tableau de commande pour l'envoyer dans le select de la JSP
			Commandes commande = new Commandes();
			ArrayList<String> tabCommandes = new ArrayList<String>();
			tabCommandes = commande.RecupCommande();
			request.setAttribute("lesCommandes", tabCommandes);

			this.getServletContext().getRequestDispatcher("/WEB-INF/ligneCommande.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/noConnect.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// récupération des saisies de la jsp
		String listeArticles = request.getParameter("listeArticles");
		String listeCommandes = request.getParameter("listeCommandes");
		int quantiteSaisie = Integer.parseInt(request.getParameter("quantite"));

		// extraction du num de commande de la chaine selectionné
		StringTokenizer stCmd = new StringTokenizer(listeCommandes, " ");
		stCmd.nextToken();
		stCmd.nextToken();
		// 3e position dans la chaine
		String numC = stCmd.nextToken();

		// extraction du code de l'artcile de la chaine selectionné
		StringTokenizer st = new StringTokenizer(listeArticles, " ");
		// 1er position dans la chaine
		String codeA = st.nextToken();

		// création de l'objet renseignant de ses attributs
		Articles article = new Articles();
		article.setCodeA(codeA);

		// variable récupérant l'état du stock de cet article
		int quantiteRestante = article.EtatStock();

		// si la quantité en stock est < à la quantité saisie
		// rechargement de la jsp avec les données des tableaux
		// et message d'erreur
		if (quantiteRestante < quantiteSaisie) {
			ArrayList<String> tabArticle = new ArrayList<String>();
			tabArticle = article.RecupArticle();
			request.setAttribute("lesArticles", tabArticle);
			Commandes commande = new Commandes();
			ArrayList<String> tabCommandes = new ArrayList<String>();
			tabCommandes = commande.RecupCommande();
			request.setAttribute("lesCommandes", tabCommandes);
			request.setAttribute("quantiteTest", "Stock Insuffisant");
			this.getServletContext().getRequestDispatcher("/WEB-INF/ligneCommande.jsp").forward(request, response);

		} else {

			// sinon création de l'objet renseignant de ses attributs
			LigneCmd ligneCmd = new LigneCmd();
			ligneCmd.setCodeA(codeA);
			ligneCmd.setNumeroC(numC);
			ligneCmd.setQuantite(quantiteSaisie);

			// vérification que le couple article et commande n'existe pas déja
			boolean verif = ligneCmd.verifLigneCmd();
			if (verif == true) {
				// si oui rechargement de la jsp avec les données des tableaux
				// et message d'erreur
				ArrayList<String> tabArticle = new ArrayList<String>();
				tabArticle = article.RecupArticle();
				request.setAttribute("lesArticles", tabArticle);
				Commandes commande = new Commandes();
				ArrayList<String> tabCommandes = new ArrayList<String>();
				tabCommandes = commande.RecupCommande();
				request.setAttribute("lesCommandes", tabCommandes);
				request.setAttribute("existDejaTest",
						"Cette commande contient déja cette article, vous pouvez seulement la modifier");
				this.getServletContext().getRequestDispatcher("/WEB-INF/ligneCommande.jsp").forward(request, response);

			} else {
				// sinon appel à la méthode d'ajout de la commande
				ligneCmd.AjtLigneCmd();

				// mise à jour du nouveau stock
				article.setCodeA(codeA);
				int stockAvant = article.EtatStock();
				int stockApres = stockAvant - quantiteSaisie;
				article.ModifStock(stockApres);
				this.getServletContext().getRequestDispatcher("/WEB-INF/validation.jsp").forward(request, response);

			}
		}

	}

}
