package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bdd.MaBdd;

public class Articles {

	String designation;
	int prixU;
	int etatStock;
	String codeA;

	public String getCodeA() {
		return codeA;
	}

	public void setCodeA(String codeA) {
		this.codeA = codeA;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getPrixU() {
		return prixU;
	}

	public void setPrixU(int prixU) {
		this.prixU = prixU;
	}

	public int getEtatStock() {
		return etatStock;
	}

	public void setEtatStock(int etatStock) {
		this.etatStock = etatStock;
	}

	public void AjtArticle() {

		Connection c = MaBdd.LoadDatabase();

		try {

			// on prepare la requete en utilisant PreparedStatement
			PreparedStatement ps = c
					.prepareStatement("INSERT INTO article (designation, prixU, stock) VALUES (?, ?, ?);");
			// on utilise le joker ?
			// on ajoute les element qui remplace les jokerS
			ps.setString(1, this.designation);
			ps.setInt(2, this.prixU);
			ps.setInt(3, this.etatStock);
			// selon le type on utilise setType
			int nbr = ps.executeUpdate();
			if (nbr == 1)
				System.out.println("insertion reussie");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void SupprArticle() {

		Connection c = MaBdd.LoadDatabase();
		String numC;
		try {
			// recherche des commandes ayant cet article
			PreparedStatement psOne = c.prepareStatement("SELECT numeroC FROM lignecommande WHERE codeA = ?;");
			psOne.setString(1, this.codeA);
			ResultSet result = psOne.executeQuery();
			Commandes commande = new Commandes();

			// Boucle pour trouver et supprimer les commandes ayant cet article
			while (result.next()) {
				numC = result.getString("numeroC");
				commande.setNumeroCmd(numC);
				commande.SupprCommande();
			}

			// suppression de l'article par la suite
			PreparedStatement psTwo = c.prepareStatement("DELETE FROM article WHERE codeA = ?;");
			psTwo.setString(1, this.codeA);
			psTwo.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int EtatStock() {
		Connection c = MaBdd.LoadDatabase();

		try {
			// recherche du stock lié à l'article this.codeA
			PreparedStatement ps = c.prepareStatement("SELECT stock FROM article WHERE codeA = ?;");
			ps.setString(1, this.codeA);
			ResultSet result = ps.executeQuery();
			result.next();

			// resulat enregistré dans stock puis retourné
			int stock = Integer.parseInt(result.getString("stock"));
			return stock;

		} catch (SQLException e) {
			System.out.println("exception stock");
			e.printStackTrace();
		}
		return 0;
	}

	public int codeArticle() {
		Connection c = MaBdd.LoadDatabase();

		try {
			// recherche de l'article lié à l'article this.codeA
			PreparedStatement ps = c.prepareStatement("SELECT stock FROM codeA WHERE designation = ?;");
			ps.setString(1, this.designation);
			ResultSet result = ps.executeQuery();
			result.next();

			// resulat enregistré dans codeA puis retourné
			int codeA = Integer.parseInt(result.getString("codeA"));
			return codeA;

		} catch (SQLException e) {
			System.out.println("exception stock");
			e.printStackTrace();
		}
		return 0;
	}

	public void ModifStock(int newStock) {
		// System.out.println("entré etat stock");
		Connection c = MaBdd.LoadDatabase();

		try {
			// requette sql pour modifier le stock correspondant au codeA
			PreparedStatement ps = c.prepareStatement("UPDATE article SET stock = ? WHERE codeA = ?;");
			ps.setInt(1, newStock);
			ps.setString(2, this.codeA);
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("exception stock");
			e.printStackTrace();
		}

	}

	public static ArrayList<String> RecupArticle() {

		Connection c = MaBdd.LoadDatabase();

		try {

			// recherche de la totalité des articles
			PreparedStatement ps = c.prepareStatement("SELECT * FROM article;");
			ResultSet result = ps.executeQuery();

			// chaque articles (code+designation+prix) sont mise dans un tableau de String
			// puis retourné
			ArrayList<String> tabArticles = new ArrayList<String>();
			while (result.next()) {
				tabArticles.add(result.getString("codeA") + " " + result.getString("designation") + " prix: "
						+ result.getString("prixU") + " €");
			}

			return tabArticles;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
