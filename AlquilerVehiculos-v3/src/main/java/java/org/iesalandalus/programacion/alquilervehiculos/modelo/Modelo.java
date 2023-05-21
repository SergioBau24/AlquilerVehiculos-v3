package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IAlquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IVehiculos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Vehiculos;

public abstract class Modelo {

	protected IClientes clientes;
	protected IAlquileres alquileres;
	protected IVehiculos turismos;
	protected IFuenteDatos fuenteDatos;

	protected void setIClientes(IClientes clientes) {
		this.clientes = clientes;
	}
	
	protected void setIAlquileres(IAlquileres alquileres) {
		this.alquileres = alquileres;
	}
	
	protected void setIVehiculos(IVehiculos turismos) {
		this.turismos = turismos;
	}
	
	protected void setIFuenteDatos(IFuenteDatos fuenteDatos) {
		this.fuenteDatos = fuenteDatos;
	}
	
	public Modelo() {

		super();
	}

	public void comenzar() { // Creará una instancia de las clases, es decir un nuevo objeto

		this.clientes = new Clientes(); // Igualas el atributo a el constructor para crear una nueva instancia
		this.turismos = new Vehiculos();
		this.alquileres = new Alquileres();

	}

	public void terminar() {

		System.out.println("Modelo finalizado");

	}

	public abstract void insertar(Alquiler alquiler) throws OperationNotSupportedException;

	public abstract void insertar(Vehiculo vehiculo) throws OperationNotSupportedException;

	public abstract void insertar(Cliente cliente) throws OperationNotSupportedException;

	public abstract Alquiler buscar(Alquiler alquiler);

	public abstract Turismo buscar(Turismo turismo);

	public abstract Cliente buscar(Cliente cliente);

	public abstract void modificar(Cliente cliente, String nombre, String telefono)
			throws OperationNotSupportedException;

	public abstract void devolver(Vehiculo vehiculo, LocalDate fechaDevolucion) throws OperationNotSupportedException;

	public abstract void devolver(Cliente cliente, LocalDate fechaDevolucion) throws OperationNotSupportedException;

	public abstract void borrar(Alquiler alquiler) throws OperationNotSupportedException;

	public abstract void borrar(Vehiculo vehiculo) throws OperationNotSupportedException;

	public abstract void borrar(Cliente cliente) throws OperationNotSupportedException;

	public abstract List<Alquiler> getAlquileres();

	public abstract List<Turismo> getTurismos();

	public abstract List<Cliente> getClientes();
	
	public abstract List<Alquiler> getListaAlquileres(Cliente cliente);
	
	public abstract List<Alquiler> getListaAlquileres(Vehiculo vehiculo);

	

	

	

	

}