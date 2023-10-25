package main.Ejercicio4;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.Colores;
import main.SQLConnect;

public class PeliculasSalas {

	public void ejecutarEj4() throws SQLException {
		System.out.println(Colores.ANSI_ORANGE + "\n----- EJERCICIO 4 -----" + Colores.ANSI_RESET);

		SQLConnect.createDB("Ej4TA18_Peliculas");

		SQLConnect.createTable("Ej4TA18_Peliculas", "Peliculas", "(\r\n" + "codigo int auto_increment,\r\n"
				+ "nombre nvarchar(100),\r\n" + "calificacion_edad int,\r\n" + "PRIMARY KEY (codigo)\r\n" + ");");

		SQLConnect.insertData("Ej4TA18_Peliculas", "Peliculas", " (nombre, calificacion_edad)",
				"('Interestellar', 12),('Oppenheimer', 18),('Spiderman 1', 10),('Los Vengadores, Endgame', 16),('Barbie', 5);");

		SQLConnect.createTable("Ej4TA18_Peliculas", "Salas",
				"(\r\n" + "codigo int auto_increment,\r\n" + "nombre nvarchar(100),\r\n" + "codigo_pelicula int,\r\n"
						+ "PRIMARY KEY (codigo),\r\n" + "FOREIGN KEY (codigo_pelicula) REFERENCES Peliculas(codigo)\r\n"
						+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n" + ");");

		SQLConnect.insertData("Ej4TA18_Peliculas", "Salas", " (nombre, codigo_pelicula)",
				"('Sala 1', 1),('Sala 2', 2),('Sala 3', 3),('Sala 4', 4),('Sala 5', 5);");
		
		
		ResultSet rs = SQLConnect.getValues("Ej4TA18_Peliculas","Peliculas");
		ResultSet rs2 = SQLConnect.getValues("Ej4TA18_Peliculas","Salas");
		imprimirConsultas(rs,rs2);
	}

	private void imprimirConsultas(ResultSet rs, ResultSet rs2) throws SQLException {
		System.out.println(Colores.ANSI_ORANGE + "\nTABLA PELICULAS" + Colores.ANSI_RESET);

		while (rs.next()) {
			System.out.println(
					"Codigo: "+rs.getString("codigo")+" | "+
					"Nombre: "+rs.getString("nombre")+" | "+
					"Calificacion edad: "+rs.getString("calificacion_edad"));
		}
		
		System.out.println(Colores.ANSI_ORANGE + "\nTABLA SALAS" + Colores.ANSI_RESET);

		while (rs2.next()) {
			System.out.println(
					"Codigo: "+rs2.getString("codigo")+" | "+
					"Nombre: "+rs2.getString("nombre")+" | "+
					"Codigo pelicula: "+rs2.getString("codigo_pelicula"));
		}
		
	}

}
