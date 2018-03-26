package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bdd.MaBdd;

public class Commandes {

	String numeroCmd;
	int id;
	String date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroCmd() {
		return numeroCmd;
	}

	public void setNumeroCmd(String numC) {
		this.numeroCmd = numC;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void AjtCommande() {

		Connection c = MaBdd.LoadDatabase();

		try {

			// on prepare la requete en utilisant PreparedStatement
			PreparedStatement ps = c.prepareStatement("INSERT INTO commande (numeroC, date, id) VALUES (?, ?, ?);");

			// on utilise le joker ?
			// on ajoute les element qui remplace les joker
			ps.setString(1, this.numeroCmd);
			ps.setString(2, this.date);
			ps.setInt(3, this.id);

			// selon le type on utilise setType
			int nbr = ps.executeUpdate();
			if (nbr == 1)
				System.out.println("insertion reussie");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void SupprCommande() {

		Connection c = MaBdd.LoadDatabase();

		try {
			// suppression des lignes de commande ayant ce numero de commande
			PreparedStatement psOne = c.prepareStatement("DELETE FROM lignecommande WHERE numeroC = ?;");
			psOne.setString(1, this.numeroCmd);
			psOne.executeUpdate();

			// suppression des commandes ayant ce numero de commande
			PreparedStatement psTwo = c.prepareStatement("DELETE FROM commande WHERE numeroC = ?;");
			psTwo.setString(1, this.numeroCmd);
			psTwo.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList<String> RecupCommande() {

		Connection c = MaBdd.LoadDatabase();

		try {

			// recherche de la totalité des commandes
			PreparedStatement ps = c.prepareStatement("SELECT * FROM commande;");
			ResultSet result = ps.executeQuery();

			// chaque commande est mise dans un tableau de String
			// puis retourné
			ArrayList<String> tabCommandes = new ArrayList<String>();
			while (result.next()) {
				tabCommandes.add("Commande n° " + result.getString("numeroC") + " du " + result.getString("date"));
			}

			return tabCommandes;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public String InfoCommandeClient() {

		Connection c = MaBdd.LoadDatabase();

		try {

			// exctraction de la totalité des commandes pour un client id
			PreparedStatement psOne = c.prepareStatement("SELECT id FROM commande WHERE numeroC = ?;");
			psOne.setString(1, this.numeroCmd);
			ResultSet result = psOne.executeQuery();
			result.next();

			// exctraction du nom du client de l'id
			PreparedStatement psTwo = c.prepareStatement("SELECT nom FROM client WHERE id = ?;");
			psTwo.setString(1, result.getString("id"));
			ResultSet resultNom = psTwo.executeQuery();
			resultNom.next();

			// exctraction du prenom du client de l'id
			PreparedStatement psThree = c.prepareStatement("SELECT prenom FROM client WHERE id = ?;");
			psThree.setString(1, result.getString("id"));
			ResultSet resultPrenom = psThree.executeQuery();
			resultPrenom.next();
			String PrenomNom = (resultPrenom.getString("prenom") + " " + resultNom.getString("nom"));

			// retourne la chaine de caractere à afficher
			return PrenomNom;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public int InfoCommandeTotal() {

		Connection c = MaBdd.LoadDatabase();

		try {
			int prix, quantite, total = 0;
			// exctraction de la totalité des infos d'un commande de la ligne de commande
			PreparedStatement psOne = c.prepareStatement("SELECT * FROM lignecommande WHERE numeroC = ?;");
			psOne.setString(1, this.numeroCmd);
			ResultSet result = psOne.executeQuery();

			// exctraction de la totalité des infos des articles
			PreparedStatement psTwo = c.prepareStatement("SELECT * FROM article;");
			ResultSet resultArticles = psTwo.executeQuery();

			// boucle de calcul du montant totla des articles en fonction de leur quantité
			while (result.next()) {
				while (resultArticles.next()) {
					System.out.println("boucle article");
					if (resultArticles.getString("codeA").equals(result.getString("codeA"))) {

						prix = Integer.parseInt(resultArticles.getString("prixU"));
						quantite = Integer.parseInt(result.getString("quantite"));
						total = total + (prix * quantite);
					}
				}
				// recharchement des articles dans la table article pour x comparaisons
				resultArticles = psTwo.executeQuery();
			}
			return total;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

}
