package ACB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TeamController {

	private Connection connection;

	public TeamController(Connection connection) {
		this.connection = connection;
	}

	public void showTeams() throws SQLException, IOException {

		Statement st = connection.createStatement();
		ResultSet rs;


		rs = st.executeQuery("SELECT * FROM team");
		while (rs.next()) {
			System.out.println("Nom: " + rs.getString("name") +
							   "\t| Tipus: " + rs.getString("type") +
							   "\t| Pais: " + rs.getString("country") +
							   "\t| Ciutat: " + rs.getString("city") +
							   "\t| Pista: " + rs.getString("court_name"));
		}

		rs.close();
		st.close();
	}

	public void createTeam() throws SQLException, IOException {

		Statement st = connection.createStatement();
		Scanner reader = new Scanner(System.in);
		int opcio = 0;
		do {
			System.out.println("Escriu el nom del nou equip:");
			String teamname = reader.nextLine();

			System.out.println("Escriu el tipus del nou equip:");
			String teamtype = reader.nextLine();

			System.out.println("Escriu el pais del nou equip:");
			String teamcountry = reader.nextLine();

			System.out.println("Escriu la ciutat del nou equip:");
			String teamcity = reader.nextLine();

			System.out.println("Escriu el nom de la pista del nou equip:");
			String teamcourtname = reader.nextLine();

			System.out.println("Estas d'acord amb aquests parametres? (1 SI / 2 NO)");
			int repetir = reader.nextInt();
			if (repetir == 1) opcio = 1;
			else {
				opcio = 0;
				st.executeUpdate("INSERT INTO team (name, type, country, city, court_name) VALUES ('" + teamname + "','" + teamtype + "','"
						+ teamcountry + "','" + teamcity + "','" + teamcourtname + "')");

				st.close();
			}
		} while (opcio != 0);


	}

}
