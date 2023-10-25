package main.Ejercicio8;

import main.Colores;
import main.SQLConnect;

public class GrandesAlmacenes {

	public void ejecutarEj8() {

		System.out.println(Colores.ANSI_ORANGE + "\n----- EJERCICIO 8 -----" + Colores.ANSI_RESET);

		SQLConnect.createDB("Ej8TA18_GrandesAlmacenes");

		SQLConnect.createTable("Ej8TA18_GrandesAlmacenes", "Cajeros", "(\r\n" + "codigo int auto_increment,\r\n"
				+ "nom_apels nvarchar(255),\r\n" + "PRIMARY KEY (codigo)\r\n" + ");\r\n" + "");

		SQLConnect.insertData("Ej8TA18_GrandesAlmacenes", "Cajeros", " (nom_apels)", "('Adrian Gallego'),\r\n"
				+ "('Robert Lopez'),\r\n" + "('Manel Castellvi'),\r\n" + "('Luis Gonzalez'),\r\n" + "('Pedro Pascal')");

		SQLConnect.createTable("Ej8TA18_GrandesAlmacenes", "Productos", "(\r\n" + "codigo int auto_increment,\r\n"
				+ "nombre nvarchar(100),\r\n" + "precio int,\r\n" + "PRIMARY KEY (codigo)\r\n" + ");");

		SQLConnect.insertData("Ej8TA18_GrandesAlmacenes", "Productos", " (nombre, precio)",
				"('Producto 1', 10),\r\n" + "('Producto 2', 5),\r\n" + "('Producto 3', 7),\r\n"
						+ "('Producto 4', 15),\r\n" + "('Producto 5', 27)");

		SQLConnect.createTable("Ej8TA18_GrandesAlmacenes", "MaquinasRegistradoras",
				"(\r\n" + "codigo int auto_increment,\r\n" + "piso int,\r\n" + "PRIMARY KEY (codigo)\r\n" + ");");

		SQLConnect.insertData("Ej8TA18_GrandesAlmacenes", "MaquinasRegistradoras", " (codigo, piso)",
				"(1, 1),\r\n" + "(2, 2),\r\n" + "(3, 3),\r\n" + "(4, 4),\r\n" + "(5, 5)");

		SQLConnect.createTable("Ej8TA18_GrandesAlmacenes", "Venta",
				"(\r\n" + "codigo_cajero int,\r\n" + "codigo_maquina int,\r\n" + "codigo_producto int,\r\n"
						+ "PRIMARY KEY (codigo_cajero, codigo_maquina, codigo_producto),\r\n"
						+ "FOREIGN KEY (codigo_cajero) REFERENCES Cajeros(codigo)\r\n"
						+ "ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
						+ "FOREIGN KEY (codigo_maquina) REFERENCES MaquinasRegistradoras(codigo)\r\n"
						+ "ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
						+ "FOREIGN KEY (codigo_producto) REFERENCES Productos(codigo)\r\n"
						+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n" + ");");

		SQLConnect.insertData("Ej8TA18_GrandesAlmacenes", "Venta", " (codigo_cajero, codigo_maquina, codigo_producto)",
				"(1, 1, 1),\r\n" + "(2, 2, 2),\r\n" + "(3, 3, 3),\r\n" + "(4, 4, 4),\r\n" + "(5, 5, 5)");

	}
}
