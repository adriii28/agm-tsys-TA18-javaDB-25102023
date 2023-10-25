package main;

import java.sql.SQLException;

import main.Ejercicio1.TiendaInformatica;
import main.Ejercicio2.Empleados;
import main.Ejercicio3.Almacenes;
import main.Ejercicio4.PeliculasSalas;
import main.Ejercicio5.Directores;
import main.Ejercicio6.PiezasProveedores;
import main.Ejercicio7.Cientificos;
import main.Ejercicio8.GrandesAlmacenes;
import main.Ejercicio9.Investigadores;

public class mainApp {

	public static void main(String[] args) throws SQLException {
		
		TiendaInformatica ej1 = new TiendaInformatica();
		ej1.ejecutarEj1();

		Empleados ej2 = new Empleados();
		ej2.ejecutarEj2();
		
		Almacenes ej3 = new Almacenes();
		ej3.ejecutarEj3();
		
		PeliculasSalas ej4 = new PeliculasSalas();
		ej4.ejecutarEj4();

		Directores ej5 = new Directores();
		ej5.ejecutarEj5();
		
		PiezasProveedores ej6 = new PiezasProveedores();
		ej6.ejecutarEj6();
		
		Cientificos ej7 = new Cientificos();
		ej7.ejecutarEj7();

		GrandesAlmacenes ej8 = new GrandesAlmacenes();
		ej8.ejecutarEj8();

		Investigadores ej9 = new Investigadores();
		ej9.ejecutarEj9();
	}

}
