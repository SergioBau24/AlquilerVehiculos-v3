package java.org.iesalandalus.programacion.alquilervehiculos.controlador;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class Controlador {

	Vista vista; // Atributo tipo vista
	Modelo modelo; // Atributo tipo modelo

	public Controlador(Modelo modelo, Vista vista) {

		if (modelo == null) {
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		}
		if (vista == null) {
			throw new NullPointerException("ERROR: La vista no puede ser nula");
		}
		
		this.modelo = modelo;
		this.vista = vista;

		Controlador controlador = new Controlador(modelo, vista); // Nueva instancia de la clase Controlador

		vista.setControlador(controlador); 
	}

	public void comenzar() { //Llamará a el método comenzar de modelo
		modelo.comenzar();
	}
	
	public void terminar() {
		modelo.terminar();
	}
	
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		modelo.insertar(cliente);
	}
	
	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		modelo.insertar(turismo);
	}
	
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		modelo.insertar(alquiler);
	}
	
	public Cliente buscar(Cliente cliente) {
		return modelo.buscar(cliente);
		
	}
	
	public Vehiculo buscar(Turismo turismo) {
		 return modelo.buscar(turismo);
	}
	
	public Alquiler buscar(Alquiler alquiler) {
		return modelo.buscar(alquiler);
	}
	
	public void modificar(Cliente cliente,String nombre,String telefono) throws OperationNotSupportedException {
		 modelo.modificar(cliente, nombre, telefono);
	}
	
	public void devolver(Alquiler alquiler,LocalDate fechaDevolucion) throws OperationNotSupportedException {
		modelo.devolver(alquiler, fechaDevolucion);
	}
	
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		modelo.borrar(cliente);
	}
	
	public void borrar(Vehiculo turismo) throws OperationNotSupportedException {
		modelo.borrar(turismo);
	}
	
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		modelo.borrar(alquiler);
	}
	
	public List <Cliente> getClientes() {
		 return modelo.getClientes();
	}
	
	public List <Turismo> getTurismos() {
		return modelo.getTurismos();
	}
	
	public List <Alquiler> getAlquileres() {
		return modelo.getAlquileres();
	}

	public List <Alquiler> getAlquileres(Cliente cliente) {
		return modelo.getAlquileres(cliente);
	}
	
	public List <Alquiler> getAlquileres(Vehiculo turismo) {
		return modelo.getAlquileres(turismo);
	}
}
