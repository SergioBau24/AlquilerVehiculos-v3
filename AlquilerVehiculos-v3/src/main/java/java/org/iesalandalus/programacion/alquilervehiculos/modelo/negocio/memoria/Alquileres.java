package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import java.org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import java.org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import java.org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IAlquileres;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

public class Alquileres implements IAlquileres {

	List<Alquiler> coleccionAlquileres;// Inicializada la array coleccion alquileres

	public Alquileres() {

		coleccionAlquileres = new ArrayList<>(); // Creación de la lista vacía
	}

	@Override
	public List<Alquiler> get() { // ¿Tienen que devolver una copia?

		return coleccionAlquileres;
	}

	@Override
	public List<Alquiler> get(Cliente cliente) { // Devuelve el alquiler de un cliente

		List<Alquiler> listaCliente = new ArrayList<>(); // Nueva Lista

		for (Alquiler coleccionAlquiler : coleccionAlquileres) { // Recorres las dos listas

			if (coleccionAlquiler.getCliente().equals(cliente)) {
				listaCliente.add(coleccionAlquiler);

			}
		}
		return listaCliente;

	}

	@Override
	public List<Alquiler> get(Vehiculo turismo) { // Devolverá una lista con los alquileres con los turismos

		List<Alquiler> listaVehiculo = new ArrayList<>();

		for (Alquiler coleccionAlquiler : coleccionAlquileres) {

			if (coleccionAlquiler.getVehiculo().equals(turismo)) {
				listaVehiculo.add(coleccionAlquiler);
			}
		}

		return listaVehiculo;
	}

	@Override
	public int getCantidad() { // Cantidad de elementos que contenga la lista

		return coleccionAlquileres.size();
	}

	private void comprobarAlquiler(Cliente cliente, Vehiculo turismo, LocalDate fechaAlquiler)
			throws OperationNotSupportedException {

		for (Alquiler Alquileres : coleccionAlquileres) { // Estructura Tipo de dato + variable + : + lista

			if (Alquileres.getFechaDevolucion() == null) {
				// Si la fechaDevolucion es nula quiere decir que es verdadero por lo tanto, el
				// alquiler no está devuelto

				if (Alquileres.getCliente().equals(cliente)) {

					throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");

				}
				if (Alquileres.getVehiculo().equals(turismo)) {

					throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
				}

			} else {
				// Si la fechaAlquiler no es nula quiere decir que es verdadero por lo tanto, el
				// alquiler está devuelto

				if (Alquileres.getCliente().equals(cliente) && (Alquileres.getFechaDevolucion().isAfter(fechaAlquiler)
						|| Alquileres.getFechaDevolucion().isEqual(fechaAlquiler))) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
				}
				if (Alquileres.getVehiculo().equals(turismo) && (Alquileres.getFechaDevolucion().isAfter(fechaAlquiler)
						|| Alquileres.getFechaDevolucion().isEqual(fechaAlquiler))) {
					throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
				}
			}
		}
	}

	@Override
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}
		if (!coleccionAlquileres.contains(alquiler)) {
			comprobarAlquiler(alquiler.getCliente(), alquiler.getVehiculo(), alquiler.getFechaAlquiler());
			coleccionAlquileres.add(alquiler);
		}
	}

	@Override
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
		}
		if (!coleccionAlquileres.contains(alquiler)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		} else {
			alquiler.devolver(fechaDevolucion);

		}
	}

	public void getAlquilerAbierto(Cliente cliente) { // Falta implementarlo

	}

	public void getAlquilerAbierto(Vehiculo vehiculo) { // Faltan implementarlo

	}

	@Override
	public Alquiler buscar(Alquiler alquiler) { // Así esta bien?

		int indice = coleccionAlquileres.indexOf(alquiler); // Devuelve el índice de ese elemento

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}

		Alquiler variable = null;

		if (indice != -1) { // Comprobamos que el índice de la lista no es nula

			variable = coleccionAlquileres.get(indice); // Si no que me devuelva

		}

		return variable;

	}

	@Override
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}

		if (coleccionAlquileres.contains(alquiler)) {
			coleccionAlquileres.remove(alquiler);
		} else {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}

	}

}
