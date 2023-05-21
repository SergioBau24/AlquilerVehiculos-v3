package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import java.org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

public class Clientes implements IClientes {

	List<Cliente> coleccionClientes; // Declaracion de la lista vacía

	public Clientes() {

		coleccionClientes = new ArrayList<>(); // Creacion de la lista

	}

	@Override
	public List<Cliente> get() {

		return coleccionClientes;
	}

	@Override
	public int getCantidad() { // Debería estar bien

		return coleccionClientes.size();

	}

	@Override
	public void insertar(Cliente cliente) throws OperationNotSupportedException { //Estas excepciones se propagan 

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}
		if (!coleccionClientes.contains(cliente)) {

			coleccionClientes.add(cliente);
		} else {
			
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
			
		}
	}

	@Override
	public Cliente buscar(Cliente cliente) {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}

		if (!coleccionClientes.contains(cliente)) {
			cliente = null;
		}
		return cliente;

	}

	@Override
	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}

		if (!coleccionClientes.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}

		if (coleccionClientes.contains(cliente)) {

			coleccionClientes.remove(cliente);
		} else {

		}
	}

	@Override
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}

		if (telefono != null && !telefono.isBlank()) {

			cliente.setTelefono(telefono);

		}
		if (nombre != null && !nombre.isBlank()) {

			cliente.setNombre(nombre);
		}

		if (!coleccionClientes.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}

	}
}
