package main.Ejercicio6;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.Colores;
import main.SQLConnect;

public class PiezasProveedores {

	public void ejecutarEj6() throws SQLException {
		System.out.println(Colores.ANSI_ORANGE + "\n----- EJERCICIO 6 -----" + Colores.ANSI_RESET);

		SQLConnect.createDB("Ej6TA18_Proveedores");

		SQLConnect.createTable("Ej6TA18_Proveedores", "Piezas", "(\r\n" + "codigo int auto_increment,\r\n"
				+ "nombre nvarchar(100),\r\n" + "PRIMARY KEY (codigo)\r\n" + ");");

		SQLConnect.insertData("Ej6TA18_Proveedores", "Piezas", " (nombre)",
				"('Pieza 1'),('Pieza 2'),('Pieza 3'),('Pieza 4'),('Pieza 5');");

		SQLConnect.createTable("Ej6TA18_Proveedores", "Proveedores",
				"(\r\n" + "id char(4),\r\n" + "nombre nvarchar(100),\r\n" + "PRIMARY KEY (id)\r\n" + ");");

		SQLConnect.insertData("Ej6TA18_Proveedores", "Proveedores", " (id ,nombre)",
				"('P001', 'Proveedor 1'),('P002', 'Proveedor 2'),('P003', 'Proveedor 3'),('P004', 'Proveedor 4'),('P005', 'Proveedor 5');");

		SQLConnect.createTable("Ej6TA18_Proveedores", "Suministra",
				"(\r\n" + "codigo_pieza int,\r\n" + "id_proveedor char(4),\r\n" + "precio int,\r\n"
						+ "PRIMARY KEY (codigo_pieza, id_proveedor),\r\n"
						+ "FOREIGN KEY (codigo_pieza) REFERENCES Piezas(codigo)\r\n"
						+ "ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
						+ "FOREIGN KEY (id_proveedor) REFERENCES Proveedores(id)\r\n"
						+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n" + ");");

		SQLConnect.insertData("Ej6TA18_Proveedores", "Suministra", " (codigo_pieza, id_proveedor,precio)",
				"(1, 'P001', 100),(2, 'P002', 50),(3, 'P003', 200),(4, 'P004', 33),(5, 'P005', 15);");

		ResultSet rs = SQLConnect.getValues("Ej6TA18_Proveedores","Piezas");
		ResultSet rs2 = SQLConnect.getValues("Ej6TA18_Proveedores","Proveedores");
		ResultSet rs3 = SQLConnect.getValues("Ej6TA18_Proveedores","Suministra");

		imprimirConsultas(rs,rs2,rs3);
	}

	private void imprimirConsultas(ResultSet rs, ResultSet rs2, ResultSet rs3) throws SQLException {
		System.out.println(Colores.ANSI_ORANGE + "\nTABLA PIEZAS" + Colores.ANSI_RESET);

		while (rs.next()) {
			System.out.println(
					"Codigo pieza: "+rs.getString("codigo")+" | "+
					"Nombre: "+rs.getString("nombre"));
		}
		
		System.out.println(Colores.ANSI_ORANGE + "\nTABLA PROVEEDORES" + Colores.ANSI_RESET);

		while (rs2.next()) {
			System.out.println(
					"Id proveedor: "+rs2.getString("id")+" | "+
					"Nombre proveedor: "+rs2.getString("nombre"));
		}
		
		System.out.println(Colores.ANSI_ORANGE + "\nTABLA SUMINISTRA" + Colores.ANSI_RESET);

		while (rs3.next()) {
			System.out.println(
					"Codigo pieza: "+rs3.getString("codigo_pieza")+" | "+
					"Id proveedor: "+rs3.getString("id_proveedor")+" | "+
					"Precio: "+rs3.getString("precio"));
		}
		
	}
}
