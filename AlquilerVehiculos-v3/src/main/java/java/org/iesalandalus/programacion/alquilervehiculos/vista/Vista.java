package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

public class Vista {

	Controlador controlador;

	public void setControlador(Controlador controlador) {

		if (controlador == null) {
			throw new NullPointerException("ERROR: El controlador no puede ser nulo");
		}
		this.controlador = controlador;
	}

	public void comenzar() { // Mostrará el menu y leera la opcion y la ejecutara

		Opcion opcion = null;

		do {

			Consola.mostrarMenu();
			opcion = Consola.elegirOpcion();

		} while (opcion != Opcion.SALIR); // Preguntar

	}

	public void terminar() {

		System.out.println("El programa ha finalizado.");
	}

	private void ejecutar(Opcion opcion) {

	}

	private void insertarCliente() {

		
	}

	private void insertarTurismo() {

	}

	private void insertarAlquiler() {

	}

	private void buscarCliente() {

	}

	private void buscarTurismo() {

	}

	private void buscarAlquiler() {

	}

	private void modificarCliente() {

	}

	private void devolverAlquiler() {

	}

	private void borrarCliente() {

	}

	private void borrarTurismo() {

	}

	private void borrarAlquiler() {

	}

	private void listarClientes() {

	}

	private void listarTurismos() {

	}

	private void listarAlquileres() {

	}

	private void listarAlquileresCliente() {

	}

	private void listarAlquileresTurismo() {

	}

}
