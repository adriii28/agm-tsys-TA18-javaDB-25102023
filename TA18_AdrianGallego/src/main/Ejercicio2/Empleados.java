package main.Ejercicio2;

import main.Colores;
import main.SQLConnect;

public class Empleados {
	
	public void ejecutarEj2() {
		System.out.println(Colores.ANSI_ORANGE + "\n----- EJERCICIO 2 -----" + Colores.ANSI_RESET);

		SQLConnect.createDB("Ej2TA18_Empleados");

		SQLConnect.createTable("Ej2TA18_Empleados", "Departamentos", "(\r\n" + "codigo int auto_increment,\r\n"
				+ "nombre nvarchar(100),\r\n" + "presupuesto int,\r\n" + "PRIMARY KEY (codigo)\r\n" + ");");

		SQLConnect.insertData("Ej2TA18_Empleados", "Departamentos", " (nombre, presupuesto)",
				"('Departamento 1', 50000), ('Departamento 2', 20000), ('Departamento 3', 35000), ('Departamento 4', 60000), ('Departamento 5', 45000);");

		SQLConnect.createTable("Ej2TA18_Empleados", "Empleados",
				"(\r\n" + "dni varchar(9),\r\n" + "nombre nvarchar(100),\r\n" + "apellidos nvarchar(255),\r\n"
						+ "codigo_departamento int,\r\n" + "PRIMARY KEY (dni),\r\n"
						+ "FOREIGN KEY (codigo_departamento) REFERENCES Departamentos(codigo)\r\n"
						+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n" + ");");

		SQLConnect.insertData("Ej2TA18_Empleados", "Empleados", " (dni, nombre, apellidos, codigo_departamento)",
				"('12345678A', 'Adrian', 'Gallego', 1), ('87654321Q', 'Robert', 'Lopez', 2), ('18273645N', 'Manel', 'Castellvi', 3), ('11111111V', 'Pepe', 'Perez', 4), ('22222222N', 'Paco', 'Jimenez', 5)");

	}

}
