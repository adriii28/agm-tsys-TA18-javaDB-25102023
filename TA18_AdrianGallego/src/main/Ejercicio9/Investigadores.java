package main.Ejercicio9;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.Colores;
import main.SQLConnect;

public class Investigadores {

	public void ejecutarEj9() throws SQLException {
		
		System.out.println(Colores.ANSI_ORANGE + "\n----- EJERCICIO 9 -----" + Colores.ANSI_RESET);

		SQLConnect.createDB("Ej9TA18_Investigadores");

		SQLConnect.createTable("Ej9TA18_Investigadores", "Facultad", "(\r\n" + "codigo int auto_increment,\r\n"
				+ "nombre nvarchar(100),\r\n" + "PRIMARY KEY (codigo)\r\n" + ");");

		SQLConnect.insertData("Ej9TA18_Investigadores", "Facultad", " (nombre)", "('Facultad 1'),\r\n"
				+ "('Facultad 2'),\r\n" + "('Facultad 3'),\r\n" + "('Facultad 4'),\r\n" + "('Facultad 5')");

		SQLConnect.createTable("Ej9TA18_Investigadores", "Investigadores",
				"(\r\n" + "dni varchar(9),\r\n" + "nom_apels nvarchar(255),\r\n" + "codigo_facultad int,\r\n"
						+ "PRIMARY KEY (dni),\r\n" + "FOREIGN KEY (codigo_facultad) REFERENCES Facultad(codigo)\r\n"
						+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n" + ");");

		SQLConnect.insertData("Ej9TA18_Investigadores", "Investigadores", " (dni,nom_apels,codigo_facultad)",
				"('11111111A','Adrian Gallego',1),\r\n" + "('22222222M','Robert Lopez',2),\r\n"
						+ "('33333333D','Manel Castellvi',3),\r\n" + "('44444444H','Luis Gonzalez',4),\r\n"
						+ "('55555555L','Pedro Pascal',5)");

		SQLConnect.createTable("Ej9TA18_Investigadores", "Equipos",
				"(\r\n" + "num_serie char(4),\r\n" + "nombre nvarchar(100),\r\n" + "codigo_facultad int,\r\n"
						+ "PRIMARY KEY (num_serie),\r\n"
						+ "FOREIGN KEY (codigo_facultad) REFERENCES Facultad(codigo)\r\n"
						+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n" + ");");

		SQLConnect.insertData("Ej9TA18_Investigadores", "Equipos", " (num_serie, nombre, codigo_facultad)",
				"('E001', 'Equipo 1', 1),\r\n" + "('E002', 'Equipo 2', 2),\r\n" + "('E003', 'Equipo 3', 3),\r\n"
						+ "('E004', 'Equipo 4', 4),\r\n" + "('E005', 'Equipo 5', 5)");

		SQLConnect.createTable("Ej9TA18_Investigadores", "Reserva",
				"(\r\n" + "dni_investigador varchar(9),\r\n" + "num_serie char(4),\r\n" + "comienzo datetime,\r\n"
						+ "fin datetime,\r\n" + "PRIMARY KEY (dni_investigador, num_serie),\r\n"
						+ "FOREIGN KEY (dni_investigador) REFERENCES Investigadores(dni)\r\n"
						+ "ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
						+ "FOREIGN KEY (num_serie) REFERENCES Equipos(num_serie)\r\n"
						+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n" + ");");

		SQLConnect.insertData("Ej9TA18_Investigadores", "Reserva", " (dni_investigador, num_serie, comienzo, fin)",
				"('11111111A', 'E001', '2023-10-20', '2023-10-20'),\r\n"
						+ "('22222222M', 'E002', '2023-10-21', '2023-10-21'),\r\n"
						+ "('33333333D', 'E003', '2023-10-22', '2023-10-22'),\r\n"
						+ "('44444444H', 'E004', '2023-10-23', '2023-10-23'),\r\n"
						+ "('55555555L', 'E005', '2023-10-24', '2023-10-24')");

		ResultSet rs = SQLConnect.getValues("Ej9TA18_Investigadores","Facultad");
		ResultSet rs2 = SQLConnect.getValues("Ej9TA18_Investigadores","Investigadores");
		ResultSet rs3 = SQLConnect.getValues("Ej9TA18_Investigadores","Equipos");
		ResultSet rs4 = SQLConnect.getValues("Ej9TA18_Investigadores","Reserva");

		imprimirConsultas(rs,rs2,rs3,rs4);
	}

	private void imprimirConsultas(ResultSet rs, ResultSet rs2, ResultSet rs3, ResultSet rs4) throws SQLException {
		System.out.println(Colores.ANSI_ORANGE + "\nTABLA FACULTAD" + Colores.ANSI_RESET);

		while (rs.next()) {
			System.out.println(
					"Codigo facultad: "+rs.getString("codigo")+" | "+
					"Nombre facultad: "+rs.getString("nombre"));
		}
		
		System.out.println(Colores.ANSI_ORANGE + "\nTABLA INVESTIGADORES" + Colores.ANSI_RESET);

		while (rs2.next()) {
			System.out.println(
					"DNI investigadores: "+rs2.getString("dni")+" | "+
					"Nombre y apellidos: "+rs2.getString("nom_apels")+" | "+
					"Codigo facultad: "+rs2.getString("codigo_facultad"));
		}
		
		System.out.println(Colores.ANSI_ORANGE + "\nTABLA EQUIPOS" + Colores.ANSI_RESET);

		while (rs3.next()) {
			System.out.println(
					"Numero serie: "+rs3.getString("num_serie")+" | "+
					"Nombre equipo: "+rs3.getString("nombre")+" | "+
					"Codigo facultad: "+rs3.getString("codigo_facultad"));
					
		}
		
		System.out.println(Colores.ANSI_ORANGE + "\nTABLA RESERVA" + Colores.ANSI_RESET);

		
		while (rs4.next()) {
			System.out.println(
					"DNI investigador: "+rs4.getString("dni_investigador")+" | "+
					"Numero serie: "+rs4.getString("num_serie")+" | "+
					"Comienzo: "+rs4.getString("comienzo")+" | "+
					"Fin: "+rs4.getString("fin"));
		}
		
	}
}
