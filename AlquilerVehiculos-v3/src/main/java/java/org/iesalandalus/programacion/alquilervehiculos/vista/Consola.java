package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private static final String PATRON_FECHA = "dd/MM/yyyy";
	private static DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA); // Va a tener un formato

	private Consola() {

	}

	public static void mostrarCabecera(String mensaje) { // Uso del StringBuilder

		StringBuilder cabecera = new StringBuilder();
		cabecera.append("-");
		System.out.println(mensaje);
		for (int i = 0; i < mensaje.length(); i++) {
			System.out.print(cabecera);
		}

	}

	public static void mostrarMenu() {

		for (int i = 0; i < Opcion.values().length; i++) { // Que en cada vuelta del bucle, me recorra la longitud del
															// enumerado opcion
			System.out.println(Opcion.values()[i]);
		}
	}

	private static String leerCadena(String mensaje) {

		System.out.println(mensaje);
		mensaje = Entrada.cadena();

		return mensaje;
	}

	private static Integer LeerEntero(String mensaje) { // Aquí le hago caso al sonartLint?

		System.out.println(mensaje);
		return Entrada.entero();

	}

	private static LocalDate leerfecha(String mensaje) {

		LocalDate fecha = LocalDate.parse(Entrada.cadena(), FORMATO_FECHA); // Mirar en casa

		do {

			System.out.println(mensaje);
			mensaje = Entrada.cadena();

		} while (!mensaje.matches(PATRON_FECHA)); // Que lo repita de mientras sea contrario

		return fecha;
	}

	public static Opcion elegirOpcion() {

		Opcion opcionElegida = null; // Inicializo una variable con tipo opcion

		for (Opcion opcion : Opcion.values()) { // Hago un for each para acceder a los indices del array de opcion

			System.out.println(opcion); // Me imprime su valor
		}

		int numero = LeerEntero("Introduce un numero entero:"); // Me lee el entero con el siguiente mensaje

		try {

			opcionElegida = Opcion.get(numero); // Intenta hacer el método get de la clase

		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}

		return opcionElegida;

	}

	public static Cliente leerCliente() { // Un constructor también puede aceptar métodos si lo que devuelve es lo mismo
											// que sus parámetros

		return new Cliente(leerCadena("Introduce el dni:"), leerCadena("Introduce el nombre:"),
				leerCadena("Introduce el telefono:"));

	}

	public static Cliente clienteConDni() {

		return new Cliente(Cliente.getClienteConDni(leerCadena("Introduce un dni:")));
	}

	public static String leerNombre() {

		return leerCadena("Introduce un nombre:");
	}

	public static String leerTelefono() {

		return leerCadena("Introduce un telefono:");
	}

	public static Turismo leerTurismo() {

		return new Turismo(leerCadena("Introduce una marca:"), leerCadena("Introduce un modelo:"),
				LeerEntero("Introduce la cilindrada:"), leerCadena("Introduce la matricula:"));
	}

	public static Vehiculo leerTurismoMatricula() {

		return new Turismo(Turismo.getTurismoConMatricula(leerCadena("Introduce la matricula:")));
	}

	public static Alquiler leerAlquiler() {

		return new Alquiler(leerCliente(), leerTurismo(), leerfecha("Introduce la fecha del alquiler:"));
	}

	public static LocalDate leerFechaAlquiler() {

		return leerfecha("Introduce la fecha del alquiler:");
	}
}
