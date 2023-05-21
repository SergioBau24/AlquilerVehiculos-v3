package java.org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public abstract class Vehiculo { //Si está en rosa es una clase abstracta

	private static final String ER_MARCA = ("(^[A-Z][a-z]+)|(^[A-Z][a-z]+\s[A-Z][a-z]+)|(^[A-Z]+)|(^[A-Z][a-z]+-[A-Z][a-z]+)|(^[A-Z][a-z]+[A-Z][a-z]+)");
	private static final String ER_MATRICULA = "\\d{4}[BCDFGHJKLMNPRSTVWYZ]{3}";
	private String marca;
	private String modelo;
	private String matricula;

	protected Vehiculo(String marca, String modelo, String matricula) {

		setMarca(marca);
		setModelo(modelo);
		setMatricula(matricula);
	}

	protected Vehiculo(Vehiculo vehiculo) { // Constructor copia

		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No es posible copiar un vehículo nulo.");
		}

		this.marca = vehiculo.marca;
		this.modelo = vehiculo.modelo;
		this.matricula = vehiculo.matricula;
	}

	public static Vehiculo copiar(Vehiculo vehiculo) {

		Vehiculo vehiculo1 = null;

		if (vehiculo instanceof Turismo turismo) { // Si el vehiculo es de tipo de dato turismo

			vehiculo1 = new Turismo(turismo); // Me crea un vehiculo de tipo de dato turismo
		}

		if (vehiculo instanceof Autobus autobus) { // Si el vehiculo es de tipo de dato turismo

			vehiculo1 = new Autobus(autobus); // Me crea un vehiculo de tipo de dato turismo
		}

		if (vehiculo instanceof Furgoneta furgoneta) {

			vehiculo1 = new Furgoneta(furgoneta);
		}

		return vehiculo1;

	}

	public static Vehiculo getVehiculoConMatricula(String matricula) {

		if (matricula == null) {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		return new Turismo("Seat", "León", 90, matricula);
	}

	public abstract int getFactorPrecio(); //Método abstracto

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if (marca == null) {
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		}
		if (!marca.matches(ER_MARCA)) {
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		}

		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if (modelo == null) {
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		}
		if (modelo.isBlank()) {
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
		}
		this.modelo = modelo;

	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		if (matricula == null) {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		if (!matricula.matches(ER_MATRICULA)) {
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
		}
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	// Equals usando instance of

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vehiculo))
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(matricula, other.matricula);
	}

}