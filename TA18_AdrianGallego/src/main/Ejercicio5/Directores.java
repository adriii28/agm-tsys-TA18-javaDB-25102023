package main.Ejercicio5;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.Colores;
import main.SQLConnect;

public class Directores {

	public void ejecutarEj5() throws SQLException {
		System.out.println(Colores.ANSI_ORANGE + "\n----- EJERCICIO 5 -----" + Colores.ANSI_RESET);

		SQLConnect.createDB("Ej5TA18_Directores");

		SQLConnect.createTable("Ej5TA18_Directores", "Despachos",
				"(\r\n" + "numero int auto_increment,\r\n" + "capacidad int,\r\n" + "PRIMARY KEY (numero)\r\n" + ");");

		SQLConnect.insertData("Ej5TA18_Directores", "Despachos", " (capacidad)", "(10),(20),(30),(40),(50);");

		SQLConnect.createTable("Ej5TA18_Directores", "Directores",
				"(\r\n" + "dni varchar(9),\r\n" + "nom_apels nvarchar(255),\r\n" + "dni_jefe varchar(8),\r\n"
						+ "codigo_despacho int,\r\n" + "PRIMARY KEY (dni),\r\n"
						+ "FOREIGN KEY (dni_jefe) REFERENCES Directores(dni)\r\n"
						+ "ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
						+ "FOREIGN KEY (codigo_despacho) REFERENCES Despachos(numero)\r\n"
						+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n" + ");");

		SQLConnect.insertData("Ej5TA18_Directores", "Directores", " (dni, nom_apels, dni_jefe, codigo_despacho)",
				"('1111111A', 'Adrian Gallego', null, 1), ('2222222B', 'Robert Lopez', '1111111A', 2),('3333333C', 'Manel Castellvi', '1111111A', 3),('4444444D', 'Luis Gonzalez', '1111111A', 4),('5555555T', 'Pedro Pascal', '1111111A', 5);");
		
		ResultSet rs = SQLConnect.getValues("Ej5TA18_Directores","Despachos");
		ResultSet rs2 = SQLConnect.getValues("Ej5TA18_Directores","Directores");
		imprimirConsultas(rs,rs2);
	}

	private void imprimirConsultas(ResultSet rs, ResultSet rs2) throws SQLException {
		System.out.println(Colores.ANSI_ORANGE + "\nTABLA DESPACHOS" + Colores.ANSI_RESET);

		while (rs.next()) {
			System.out.println(
					"Numero despacho: "+rs.getString("numero")+" | "+
					"Capacidad: "+rs.getString("capacidad"));
		}
		
		System.out.println(Colores.ANSI_ORANGE + "\nTABLA DIRECTORES" + Colores.ANSI_RESET);

		while (rs2.next()) {
			System.out.println(
					"DNI: "+rs2.getString("dni")+" | "+
					"Nombre y apellidos: "+rs2.getString("nom_apels")+" | "+
					"DNI jefe: "+rs2.getString("dni_jefe")+" | "+
					"Codigo Despacho: "+rs2.getString("codigo_despacho"));
		}
		
	}
}
