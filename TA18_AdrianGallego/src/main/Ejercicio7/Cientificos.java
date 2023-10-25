package main.Ejercicio7;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.Colores;
import main.SQLConnect;

public class Cientificos {

	public void ejecutarEj7() throws SQLException {
		
		System.out.println(Colores.ANSI_ORANGE + "\n----- EJERCICIO 7 -----" + Colores.ANSI_RESET);

		SQLConnect.createDB("Ej7TA18_Cientificos");

		SQLConnect.createTable("Ej7TA18_Cientificos", "Cientificos",
				"(\r\n" + "dni varchar(9),\r\n" + "nom_apels nvarchar(255),\r\n" + "PRIMARY KEY (dni)\r\n" + ");");

		SQLConnect.insertData("Ej7TA18_Cientificos", "Cientificos", " (dni, nom_apels)",
				"('11111111V', 'Cientifico 1'),('22222222B', 'Cientifico 2'),('33333333N', 'Cientifico 3'),('44444444A', 'Cientifico 4'),('55555555S', 'Cientifico 5');");

		SQLConnect.createTable("Ej7TA18_Cientificos", "Proyecto", "(\r\n" + "id char(4),\r\n"
				+ "nombre nvarchar(255),\r\n" + "horas int,\r\n" + "PRIMARY KEY (id)\r\n" + ");");

		SQLConnect.insertData("Ej7TA18_Cientificos", "Proyecto", " (id, nombre, horas)",
				"('P001', 'Proyecto 1', 100),('P002', 'Proyecto 2', 150),('P003', 'Proyecto 3', 120),('P004', 'Proyecto 4', 90),('P005', 'Proyecto 5', 200);");

		SQLConnect.createTable("Ej7TA18_Cientificos", "AsignadoA", "(\r\n" + "cientifico varchar(9),\r\n"
				+ "proyecto char(4),\r\n" + "PRIMARY KEY (cientifico, proyecto),\r\n"
				+ "FOREIGN KEY (cientifico) REFERENCES Cientificos(dni)\r\n"
				+ "ON DELETE CASCADE ON UPDATE CASCADE,\r\n" + "FOREIGN KEY (proyecto) REFERENCES Proyecto(id)\r\n"
				+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n" + ");");

		SQLConnect.insertData("Ej7TA18_Cientificos", "AsignadoA", " (cientifico, proyecto)",
				"('11111111V', 'P001'),\r\n" + "('22222222B', 'P002'),\r\n" + "('33333333N', 'P003'),\r\n"
						+ "('44444444A', 'P004'),\r\n" + "('55555555S', 'P005');");

		ResultSet rs = SQLConnect.getValues("Ej7TA18_Cientificos","Cientificos");
		ResultSet rs2 = SQLConnect.getValues("Ej7TA18_Cientificos","Proyecto");
		ResultSet rs3 = SQLConnect.getValues("Ej7TA18_Cientificos","AsignadoA");

		imprimirConsultas(rs,rs2,rs3);
	}

	private void imprimirConsultas(ResultSet rs, ResultSet rs2, ResultSet rs3) throws SQLException {
		System.out.println(Colores.ANSI_ORANGE + "\nTABLA CIENTIFICOS" + Colores.ANSI_RESET);

		while (rs.next()) {
			System.out.println(
					"DNI cientifico: "+rs.getString("dni")+" | "+
					"Nombre y apellidos: "+rs.getString("nom_apels"));
		}
		
		System.out.println(Colores.ANSI_ORANGE + "\nTABLA PROYECTO" + Colores.ANSI_RESET);

		while (rs2.next()) {
			System.out.println(
					"Id proyecto: "+rs2.getString("id")+" | "+
					"Nombre proyecto: "+rs2.getString("nombre")+" | "+
					"Horas: "+rs2.getString("horas"));
		}
		
		System.out.println(Colores.ANSI_ORANGE + "\nTABLA ASIGNADO A" + Colores.ANSI_RESET);

		while (rs3.next()) {
			System.out.println(
					"DNI Cientifico: "+rs3.getString("cientifico")+" | "+
					"Id Proyecto: "+rs3.getString("proyecto"));
					
		}
		
	}
}
