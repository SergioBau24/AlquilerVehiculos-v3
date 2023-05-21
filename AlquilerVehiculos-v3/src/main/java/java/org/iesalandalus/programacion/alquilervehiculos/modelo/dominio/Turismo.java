package java.org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;



public class Turismo extends Vehiculo {

	private static final int FACTOR_CILINDRADA = 10;
	private int cilindrada;
	
	
	public Turismo(String marca, String modelo, int cilindrada, String matricula) {

		//El super llama al constructor por defecto de la clase padre
		
		super(marca,modelo,matricula); 
		setCilindrada(cilindrada); //Como cilindrada no esta en vehiculo lo asigno a parte
	}

	public Turismo(Turismo turismo) { 
		
		super(turismo); //¿A que constructor llama esto?
		
		if (turismo == null) {
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		}
		
		this.cilindrada = turismo.cilindrada;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		if (cilindrada <= 0 || cilindrada > 5000) {
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
		}
		
		this.cilindrada = cilindrada;
	}

	public int getFactorPrecio() { // El factor precio de un turismo es cilindrada / 10
		
		return cilindrada / FACTOR_CILINDRADA;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s (%d cc) - %s", getMarca(), getModelo(), cilindrada,
				getMatricula());
	}
	
}

