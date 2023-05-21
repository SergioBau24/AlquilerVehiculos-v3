package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

public enum Opcion {

	SALIR("Salir"), INSERTAR_CLIENTE("Insertar cliente"), INSERTAR_TURISMO("Insertar turismo"),
	INSERTAR_ALQUILER("Insertar alquiler"), BUSCAR_CLIENTE("Buscar cliente"), BUSCAR_TURISMO("Buscar turismo"),
	BUSCAR_ALQUILER("Buscar alquiler"), MODIFICAR_CLIENTE("Modificar cliente"), DEVOLVER_ALQUILER("Devolver alquiler"),
	BORRAR_CLIENTE("Borrar cliente"), BORRAR_TURISMO("Borrar turismo"), BORRAR_ALQUILER("Borrar alquiler"),
	LISTAR_CLIENTES("Listar clientes"), LISTAR_TURISMOS("Listar turismos"), LISTAR_ALQUILERES("Listar alquileres"),
	LISTAR_ALQUILERES_CLIENTE("Listar alquileres del cliente"),
	LISTAR_ALQUILERES_TURISMO("Listar alquileres del turismo");

	String texto;

	private Opcion(String texto) { // String para almacenar el texto del enumerado

		this.texto = texto;
	}

	private static boolean esOrdinalValido(int ordinal) {

		// Un ordinal es valido cuando se sale de los limites de la array

		boolean comprobacionOrdinal = true;

		if (ordinal <= 0 && ordinal > Opcion.values().length) {

			comprobacionOrdinal = false;
		}
		return comprobacionOrdinal;

	}

	public static Opcion get(int ordinal) throws OperationNotSupportedException {

		Opcion valor = null;

		if (esOrdinalValido(ordinal)) {

			valor = Opcion.values()[ordinal]; // No necesito recorrerlo ya accede a el array por los índices

		} else {

			throw new OperationNotSupportedException("El ordinal introducido no es válido");
		}
		return valor;
	}

	@Override
	public String toString() {

		return String.format(("%d.-%s"), ordinal(), texto); //¿Cómo accedo a un ordinal si no es un atributo?
	}

}
