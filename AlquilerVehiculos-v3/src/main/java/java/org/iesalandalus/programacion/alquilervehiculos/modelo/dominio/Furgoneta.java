package java.org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Furgoneta extends Vehiculo {

	private static final int FACTOR_PMA = 100;
	private static final int FACTOR_PLAZA = 1;

	private int pma;
	private int plazas;

	public Furgoneta(String marca, String modelo, int pma, int plazas, String matricula) {

		super(marca, modelo, matricula); // Llama a el constructor por defecto de la clase padre
		setPma(pma);
		setPlazas(plazas);
	}

	public Furgoneta(Furgoneta furgoneta) { // Llama a el constructor copia

		super(furgoneta);
		
		this.pma = furgoneta.pma;
		this.plazas = furgoneta.plazas;
	}

	public int getPma() {
		return pma;
	}

	private void setPma(int pma) {

		if (pma <= 100 || pma > 10000) {
			throw new IllegalArgumentException("ERROR: El PMA no es correcto.");
		}
		this.pma = pma;
	}

	public int getPlazas() {
		return plazas;
	}

	private void setPlazas(int plazas) {

		if (plazas < 2 || plazas > 9) {
			throw new IllegalArgumentException("ERROR: Las plazas no son correctas.");
		}

		this.plazas = plazas;
	}

	public int getFactorPrecio() {

		return pma / FACTOR_PMA + plazas * FACTOR_PLAZA;
	}

	@Override
	public String toString() { 
		return String.format("%s %s (%s kg, %s plazas) - %s",
				getMarca(), getModelo(), pma, plazas, getMatricula());
	}

}
