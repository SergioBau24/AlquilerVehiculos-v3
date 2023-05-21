package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Vehiculos;

public class ModeloCascada extends Modelo {

	public ModeloCascada(IFuenteDatos fuenteDatos) {
	
		super(); // El constructor tiene que estar vacio porque no tiene ningún parámetro
		setIFuenteDatos(fuenteDatos);
		
	}

	@Override
	public void insertar(Cliente cliente) throws OperationNotSupportedException { // Estas excepciones se propagan

		if (cliente == null) {

			throw new NullPointerException("ERROR: No existe el cliente del alquiler.");
		}

		Cliente objetoCliente = new Cliente(cliente); // Creacion del objeto de la clase cliente usando el constructor copia
		
		clientes.insertar(objetoCliente);
	}

	@Override
	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException { // Uso una nueva instancia

		if (vehiculo == null) {
			
			throw new NullPointerException("ERROR: No existe el turismo del alquiler.");
		}

		Vehiculos objetoTurismo = new Vehiculos(); /*  */
		
		
		
	}

	
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException { // Buscar un cliente y un turismo

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}
		Cliente clienteBuscar = buscar(alquiler.getCliente());

		if (clienteBuscar == null) {
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}

		Turismo turismoBuscar = buscar();

		if (turismoBuscar == null) {
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		}

		Alquiler objetoAlquiler = new Alquiler(new Cliente(clienteBuscar), new Turismo(turismoBuscar),
				alquiler.getFechaAlquiler());
		alquileres.insertar(objetoAlquiler);

	}

	@Override
	public Cliente buscar(Cliente cliente) { // Devolverá una nueva instancia si este existe

		return clientes.buscar(cliente);

	}

	@Override
	public Turismo buscar(Turismo turismo) {

		return Turismo.buscar(turismo);

	}

	@Override
	public Alquiler buscar() {

		return alquileres.buscar();
	}

	@Override
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {

		clientes.modificar(cliente, nombre, telefono);

	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {

		alquiler = alquileres.buscar(alquiler); // Primero tengo que buscar el alquiler

		if (alquiler == null) {
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		}

		alquiler.devolver(fechaDevolucion);

	}

	@Override
	public void borrar(Cliente cliente) throws OperationNotSupportedException { //

		for (Alquiler variable : alquileres.get(cliente)) {

			alquileres.borrar(variable);
		}
		clientes.borrar(cliente);

	}

	@Override
	public void borrar(Vehiculo Vehiculo) throws OperationNotSupportedException { // Tengo que encontrar los alquileres
																				// para ese turismo
		
		for (Alquiler variable : alquileres.get(vehiculo)) { // Borro los alquileres que ha tenido ese turismo y despues
															// borro el turismo

			alquileres.borrar(variable);
		}

		turismos.borrar(vehiculo);
	}

	@Override
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException { // Borra un alquiler

		alquileres.borrar(alquiler);

	}

	@Override
	public List<Cliente> getClientes() { // Debe devolver una nueva lista pero que contengan nuevas instancias no una
											// copia de los elementos

		/*
		 * Declaramos la lista, despues llamamos al metodo que crea una lista de
		 * clientes y la almacenamos en la variable cliente Despues usando la
		 * listaCliente almacenamos un nuevo cliente llamando al constructor copia
		 */

		List<Cliente> listaCliente = new ArrayList<>();
		for (Cliente cliente : clientes.get()) {

			listaCliente.add(new Cliente(cliente));

		}
		return listaCliente;
	}

	@Override
	public List<Turismo> getTurismos() {

		List<Turismo> listaTurismo = new ArrayList<>();

		for (Turismo turismo : turismos.get()) {

			listaTurismo.add(new Turismo(turismo));
		}
		return listaTurismo;

	}

	@Override
	public List<Alquiler> getAlquileres() {

		List<Alquiler> listaAlquiler = new ArrayList<>();

		for (Alquiler alquiler : alquileres.get()) {

			listaAlquiler.add(new Alquiler(alquiler));

		}

		return listaAlquiler;
	}

	@Override
	public List<Alquiler> getAlquileres(Cliente cliente) { // Devolverá un alquiler de clientes

		List<Alquiler> listaAlquilerC = new ArrayList<>();

		for (Alquiler alquiler : alquileres.get(cliente)) {

			listaAlquilerC.add(new Alquiler(alquiler));
		}
		return listaAlquilerC;

	}

	@Override
	public List<Alquiler> getAlquileres(Turismo turismo) { // Devolverá los alquileres de un turismo

		List<Alquiler> listaAlquilerT = new ArrayList<>();

		for (Alquiler alquiler : alquileres.get(turismo)) {

			listaAlquilerT.add(new Alquiler(alquiler));
		}

		return listaAlquilerT;

	}

	@Override
	public void devolver(Vehiculo vehiculo, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void devolver(Cliente cliente, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Alquiler> getListaAlquileres(Turismo turismo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alquiler> getListaAlquileres(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alquiler> getListaAlquileres(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return null;
	}

}
