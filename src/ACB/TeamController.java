package ACB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
