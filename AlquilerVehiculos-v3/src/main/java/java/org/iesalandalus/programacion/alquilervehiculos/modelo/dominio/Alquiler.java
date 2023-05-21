package java.org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Alquiler {

	static DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Tipo de dato para trabajar
																						// con fechas
	private static final int PRECIO_DIA = 20; // El precio día es 20
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;

	// Hereda atributos de otras clases

	Cliente cliente;
	Vehiculo vehiculo;

	public Alquiler(Cliente cliente, Vehiculo vehiculo, LocalDate fechaAlquiler) {

		setCliente(cliente);
		setVehiculo(vehiculo);
		setFechaAlquiler(fechaAlquiler);
		
	}

	public Alquiler(Alquiler alquiler) {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
		}
		
		setCliente(cliente);
		setVehiculo(vehiculo);
		this.fechaAlquiler = alquiler.fechaAlquiler;
		setFechaDevolucion(fechaDevolucion);
	}

	public Cliente getCliente() {
		return cliente;
	}

	private void setCliente(Cliente cliente) {

		if (cliente == null) {
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		}
		this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	private void setVehiculo(Vehiculo vehiculo) {

		if (vehiculo == null) {
			throw new NullPointerException("ERROR: El vehículo no puede ser nulo.");
		}

		this.vehiculo = vehiculo;
	}

	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}

	private void setFechaAlquiler(LocalDate fechaAlquiler) {

		if (fechaAlquiler == null) {
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		}
		this.fechaAlquiler = fechaAlquiler;

		if (fechaAlquiler.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
		}
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		if (fechaDevolucion == null) {
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		}
		if (fechaDevolucion.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
		}
		if (fechaDevolucion.isBefore(fechaAlquiler) || fechaDevolucion.isEqual(getFechaAlquiler())) {
			throw new IllegalArgumentException(
					"ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
		}
		this.fechaDevolucion = fechaDevolucion;
	}

	public void devolver(LocalDate fechaDevolucion) throws OperationNotSupportedException {

		if (this.fechaDevolucion != null) {
			throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada.");

		}
		setFechaDevolucion(fechaDevolucion);
	}

	public int getPrecio() { // Usamos el método de la clase padre, usando el patrón estrategia

		int factorCilindrada;
		int numDias;
		int precio;

		if (getFechaDevolucion() == null) {

			precio = 0;
			
		} else {

			factorCilindrada = vehiculo.getFactorPrecio();

			numDias = (int) ChronoUnit.DAYS.between(fechaAlquiler, fechaDevolucion);

			precio = (PRECIO_DIA + factorCilindrada) * numDias;
		}

		return precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, fechaDevolucion, vehiculo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Alquiler))
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(fechaDevolucion, other.fechaDevolucion) && Objects.equals(vehiculo, other.vehiculo);
	}

	@Override
	public String toString() { //Uso format para usar ese formato fecha

		String cadena = null; // Inicializo variable de tipo String

		if (getFechaDevolucion() == null) {

			cadena = String.format("%s <---> %s, %s - %s (%d€)", cliente, vehiculo, fechaAlquiler.format(FORMATO_FECHA),
					"Aún no devuelto", getPrecio());
		} else {

			cadena = String.format("%s <---> %s, %s - %s (%d€)", cliente, vehiculo, fechaAlquiler.format(FORMATO_FECHA),
					fechaDevolucion.format(FORMATO_FECHA), getPrecio());
		}
		return cadena;
	}

}
