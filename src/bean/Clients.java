package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bdd.MaBdd;

public class Clients {
	private String nom;
	private String prenom;
	private String id;

	public Clients() {
	}

	public Clients(String id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void AjtClient() {

		Connection c = MaBdd.LoadDatabase();

		try {

			// on prepare la requete en utilisant PreparedStatement
			PreparedStatement ps = c.prepareStatement("INSERT INTO client (nom, prenom) VALUES (?, ?);");
			// on utilise le joker ?
			// on ajoute les element qui remplace les joker
			ps.setString(1, this.nom);
			ps.setString(2, this.prenom);
			// selon le type on utilise setType
			int nbr = ps.executeUpdate();
			if (nbr == 1)
				System.out.println("insertion reussie");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void SupprClients() {

		Connection c = MaBdd.LoadDatabase();

		try {

			// recherche des commandes lié à ce client
			String numC;
			PreparedStatement psOne = c.prepareStatement("SELECT numeroC FROM commande WHERE id = ?;");
			psOne.setString(1, this.id);
			ResultSet result = psOne.executeQuery();
			Commandes commande = new Commandes();

			// Boucle pour trouver et supprimer les commandes lié à ce client
			while (result.next()) {
				numC = result.getString("numeroC");
				commande.setNumeroCmd(numC);
				commande.SupprCommande();
			}

			// suppression du client par la suite
			PreparedStatement psTwo = c.prepareStatement("DELETE FROM client WHERE id = ?;");
			psTwo.setString(1, this.id);
			psTwo.executeUpdate(); // envoi de la requete

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList<String> RecupClient() {

		Connection c = MaBdd.LoadDatabase();

		try {

			// recherche de la totalité des clients
			PreparedStatement ps = c.prepareStatement("SELECT * FROM client;");
			ResultSet result = ps.executeQuery();

			ArrayList<String> tabClients = new ArrayList<String>();
			// chaque clients sont mis dans un tableau de String
			// puis retourné
			while (result.next()) {
				tabClients
						.add(result.getString("id") + " " + result.getString("nom") + " " + result.getString("prenom"));
			}

			return tabClients;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public String toString() {
		return "nom: " + nom + ", prenom: " + prenom;
	}
}
