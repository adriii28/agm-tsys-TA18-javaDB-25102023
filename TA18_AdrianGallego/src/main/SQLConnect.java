package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnect {
	
	//En esta clase esta todo el codigo que crea la conexion con la base de datos y interactua con el programa

	
	/*Este primer metodo es el que establece la conexion con la base de datos
	 * 
	 * Cada vez que el programa interactua con la base de datos se establecera la conexion mediante este metodo
	 * y una vez finalizada la interaccion, se cerrara la conexion*/
	
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

	// Metodo que crea la base de datos y imprime el estado de esta, en caso de haber algun error lo imprime por consola
	
	public static void createDB(String name) {
		try {
			Connection conexion = ConexionDB();

			//Crea la base de datos con el nombre que le pasamos nosotros
			
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

	//Metodo que crea las tablas en la base de datos y imprime el estado de esta, en caso de haber algun error lo imprime por consola
	
	public static void createTable(String db, String name, String tablaAtributos) {
		try {
			Connection conexion = ConexionDB();
			
			//Utiliza la base de datos que hemos creado
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			System.out.println("Esta utilizando la base de datos: " + db);

			/*Para la creacion de la tabla lo que hago es pasar los atributos que se van a insertar desde la clase, 
			 * es decir, desde la clase del ej1 escribo los atributos que quiero insertar en la tabla
			 * 
			 * Esto lo hago asi para poder reutilizar este metodo y no tener que hacer un metodo por ejercicio*/
			
			//Crea la tabla con el nombre que le hemos pasado
			
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
	
	//Metodo que inserta datos en la tabla y imprime el estado de la BD, en caso de haber algun error lo imprime por consola

	public static void insertData(String db, String table_name, String parametros, String valores) {
		try {
			Connection conexion = ConexionDB();
			
			//Utiliza la base de datos que hemos creado

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			System.out.println("Esta utilizando la base de datos: " + db);

			/*Igual que cuando creo la tabla, cuando voy a insertar datos, los datos vienen desde la clase en la que se llama al metodo insertData
			 * 
			 * Esta hecho de esta manera para reutilizar el metodo*/
			
			//Inserta los datos en la tabla
			
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
	
	//Metodo que hace consultas
	
	public static ResultSet getValues(String db, String table_name) {
		Connection conexion = ConexionDB();
		
		try {
			
			//Utiliza la base de datos que hemos creado

			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			//Realiza la consulta en la tabla que le hemos pasado
			
			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			/*En el resultSet se almacena el resultado, pero me lo llevo a la clase donde se ha llamado el metodo getValues y ahi imprimo los resultados
			 * 
			 * Esta hecho asi por la reutilizacion de codigo*/
			return resultSet;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}
		return null;
		
	}
	
	
}
