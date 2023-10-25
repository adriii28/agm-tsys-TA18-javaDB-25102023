package main.Ejercicio1;

import main.Colores;
import main.SQLConnect;

public class TiendaInformatica {

	public void ejecutarEj1() {
		System.out.println(Colores.ANSI_ORANGE + "----- EJERCICIO 1 -----" + Colores.ANSI_RESET);

		SQLConnect.createDB("Ej1TA18_TiendaInformatica");

		SQLConnect.createTable("Ej1TA18_TiendaInformatica", "Fabricantes", "(\r\n" + "codigo int auto_increment,\r\n"
				+ "nombre nvarchar(100),\r\n" + "PRIMARY KEY (codigo)\r\n" + ");");

		SQLConnect.insertData("Ej1TA18_TiendaInformatica", "Fabricantes", " (nombre)",
				"('Fabricante 1'), ('Fabricante 2'), ('Fabricante 3'), ('Fabricante 4'), ('Fabricante 5');");

		SQLConnect.createTable("Ej1TA18_TiendaInformatica", "Articulos",
				"(\r\n" + "codigo int auto_increment,\r\n" + "nombre nvarchar(100),\r\n" + "precio int,\r\n"
						+ "codigo_fabricante int ,\r\n" + "PRIMARY KEY (codigo),\r\n"
						+ "FOREIGN KEY (codigo_fabricante) REFERENCES Fabricantes(codigo)\r\n"
						+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n" + ");");

		SQLConnect.insertData("Ej1TA18_TiendaInformatica", "Articulos", " (nombre, precio, codigo_fabricante)",
				"('Articulo 1', 100, 1), ('Articulo 2', 50, 2), ('Articulo 3', 25, 3), ('Articulo 4', 33, 4), ('Articulo 5', 85, 5);");
	}

}
