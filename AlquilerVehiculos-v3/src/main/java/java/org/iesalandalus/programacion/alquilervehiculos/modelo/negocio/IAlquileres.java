package java.org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

public interface IAlquileres {

	List<Alquiler> get();

	List<Alquiler> get(Cliente cliente);

	List<Alquiler> get(Vehiculo turismo);

	int getCantidad();

	void insertar(Alquiler alquiler) throws OperationNotSupportedException;

	void devolver(Cliente cliente1, LocalDate fechaDevolucion) throws OperationNotSupportedException;

	Alquiler buscar(Alquiler alquiler);

	void borrar(Alquiler alquiler) throws OperationNotSupportedException;

}