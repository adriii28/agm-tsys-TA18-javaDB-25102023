package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnect {

	public static Connection ConexionDB() {

		Connection conexion = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:33060", "root", "admin1234");
			System.out.println(Colores.ANSI_GREEN + "Server Connected" + Colores.ANSI_RESET);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("No se ha podido conectar con la base de datos");
			System.out.println(e);
		}

		return conexion;
	}

	public static void createDB(String name) {
		try {
			Connection conexion = ConexionDB();

			String Query = "CREATE DATABASE " + name;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Base de datos " + Colores.ANSI_CYAN + name + Colores.ANSI_RESET + " creada con exito!");

			conexion.close();
			System.out.println("Conexion finalizada\n");

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			System.out.println("Error crando tabla.");
		}
	}

	public static void createTable(String db, String name, String tablaAtributos) {
		try {
			Connection conexion = ConexionDB();

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			System.out.println("Esta utilizando la base de datos: " + db);

			String Query = "CREATE TABLE " + name + " " + tablaAtributos;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla " + Colores.ANSI_CYAN + name + Colores.ANSI_RESET + " creada con exito!");

			conexion.close();
			System.out.println("Conexion finalizada\n");

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			System.out.println("Error crando tabla.");

		}

	}

	public static void insertData(String db, String table_name, String parametros, String valores) {
		try {
			Connection conexion = ConexionDB();

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			System.out.println("Esta utilizando la base de datos: " + db);

			String Query = "INSERT INTO " + table_name + parametros + " VALUE " + valores;
			Statement st = conexion.createStatement();
			st.execute(Query);
			System.out.println("Datos almacenados correctamente");

			conexion.close();
			System.out.println("Conexion finalizada\n");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error en el almacenamiento");
		}

	}
}
