package main.Ejercicio7;

import main.Colores;
import main.SQLConnect;

public class Cientificos {

	public void ejecutarEj7() {
		
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

	}
}
