package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bdd.MaBdd;

public class LigneCmd {

	public LigneCmd() {
		super();
	}

	int quantite;
	String numeroC;
	String codeA;

	public String getCodeA() {
		return codeA;
	}

	public void setCodeA(String codeA) {
		this.codeA = codeA;
	}

	public String getNumeroC() {
		return numeroC;
	}

	public void setNumeroC(String numC) {
		this.numeroC = numC;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public void AjtLigneCmd() {

		Connection c = MaBdd.LoadDatabase();

		try {

			// on prepare la requete en utilisant PreparedStatement
			PreparedStatement ps = c
					.prepareStatement("INSERT INTO lignecommande (codeA, numeroC, quantite) VALUES (?, ?, ?);");
			// on utilise le joker ?
			// on ajoute les element qui remplace les joker
			System.out.println("codeA : " + this.codeA);
			System.out.println("numeroC: " + this.numeroC);
			System.out.println("quantite: " + this.quantite);
			ps.setString(1, this.codeA);
			ps.setString(2, this.numeroC);
			ps.setInt(3, this.quantite);
			// selon le type on utilise setType
			int nbr = ps.executeUpdate();
			if (nbr == 1)
				System.out.println("insertion reussie");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean verifLigneCmd() {
		/* méthode pour vérifier si une commande ne comporte pas déja cet article */

		Connection c = MaBdd.LoadDatabase();

		try {

			// recherche des commandes numeroC et les articles codeA
			PreparedStatement ps = c.prepareStatement("SELECT * FROM lignecommande WHERE codeA = ? AND numeroC = ?");
			ps.setString(1, this.codeA);
			ps.setString(2, this.numeroC);
			ResultSet result = ps.executeQuery();

			// boucle de recherche si une commande ne comprend pas déja l'article codeA
			// si c'est le cas, retournera true
			while (result.next()) {

				if (this.codeA.equals(result.getString("codeA")) && this.numeroC.equals(result.getString("numeroC"))) {
					return true;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
