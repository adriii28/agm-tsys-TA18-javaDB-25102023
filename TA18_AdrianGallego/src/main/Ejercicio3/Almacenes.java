package main.Ejercicio3;

import main.Colores;
import main.SQLConnect;

public class Almacenes {
	
	public void ejecutarEj3() {
		System.out.println(Colores.ANSI_ORANGE + "\n----- EJERCICIO 3 -----" + Colores.ANSI_RESET);

		SQLConnect.createDB("Ej3TA18_Almacenes");

		SQLConnect.createTable("Ej3TA18_Almacenes", "Almacenes", "(\r\n" + "codigo int auto_increment,\r\n"
				+ "lugar nvarchar(100),\r\n" + "capacidad int,\r\n" + "PRIMARY KEY (codigo)\r\n" + ");");

		SQLConnect.insertData("Ej3TA18_Almacenes", "Almacenes", " (lugar, capacidad)",
				"('Almacen 1', 1000), ('Almacen 2', 2000), ('Almacen 3', 1500), ('Almacen 4', 2200), ('Almacen 5', 900);");

		SQLConnect.createTable("Ej3TA18_Almacenes", "Cajas",
				"(\r\n" + "num_referencia char(5),\r\n" + "contenido nvarchar(100),\r\n" + "valor int,\r\n"
						+ "codigo_almacen int,\r\n" + "PRIMARY KEY (num_referencia),\r\n"
						+ "FOREIGN KEY (codigo_almacen) REFERENCES Almacenes(codigo)\r\n"
						+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n" + ");");

		SQLConnect.insertData("Ej3TA18_Almacenes", "Cajas", " (num_referencia, contenido, valor, codigo_almacen)",
				"('A001', 'Caja 1', 100, 1), ('A002', 'Caja 2', 150, 2), ('A003', 'Caja 3', 125, 3), ('A004', 'Caja 4', 200, 4), ('A005', 'Caja 5', 250, 5);");

	}

}
