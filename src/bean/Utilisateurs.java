package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bdd.MaBdd;

public class Utilisateurs {

	String nomUser, mdp;

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Utilisateurs(String nomUser, String mdp) {
		super();
		this.nomUser = nomUser;
		this.mdp = mdp;
	}

	public boolean VerifUser() {

		Connection c = MaBdd.LoadDatabase();

		try {

			// recherche dans la table : des mdp saisie et nom d'utilisateur saisie
			PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE mdp = ? AND nomUser = ?");
			ps.setString(1, this.mdp);
			ps.setString(2, this.nomUser);
			ResultSet result = ps.executeQuery();

			// boucle de vérification si le mot de passe correspond à l'utilisateur
			// si ok, return true
			while (result.next()) {
				if (this.mdp.equals(result.getString("mdp")) && this.nomUser.equals(result.getString("nomUser"))) {
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
		return false;

	}

}
