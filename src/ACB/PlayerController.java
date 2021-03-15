package ACB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PlayerController {

	private Connection connection;
	
	public PlayerController(Connection c) {
		this.connection = connection;
	}

	public void createPlayer() throws SQLException, IOException {

		Statement st = connection.createStatement();
		Scanner reader = new Scanner(System.in);
		int opcio = 0;
		do {
			System.out.println("Escriu el nom del nou equip:");
			int federationlicensecode = reader.nextInt();

			System.out.println("Escriu el nom del nou equip:");
			String firstname = reader.nextLine();

			System.out.println("Escriu el tipus del nou equip:");
			String lastname = reader.nextLine();

			System.out.println("Escriu el pais del nou equip:");
			Date birthdate = Date.valueOf(reader.nextLine());

			System.out.println("Escriu la ciutat del nou equip:");
			String gender = reader.nextLine();

			System.out.println("Escriu el nom de la pista del nou equip:");
			int height = reader.nextInt();

			System.out.println("Escriu el nom del nou equip:");
			String teamname = reader.nextLine();

			System.out.println("Escriu el nom del nou equip:");
			int mvptotal = reader.nextInt();

			System.out.println("Estas d'acord amb aquests parametres? (1 SI / 2 NO)");
			int repetir = reader.nextInt();
			if (repetir == 1) opcio = 1;
			else {
				opcio = 0;
				st.executeUpdate("INSERT INTO team (federation_license_code, first_name, last_name, birth_date, gender, height, team_name, mvp_total) VALUES ('" + federationlicensecode + "','"
						+ firstname + "','" + lastname + "','" + birthdate + "','" + gender + "','" + height + "','" + teamname + "','" + mvptotal + "')");

				st.close();
			}
		} while (opcio != 0);


	}

}
