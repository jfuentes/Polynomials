
/**
 *****Solución Tarea 1*******
 * Estructura de Datos 2013-1
 * Prof. Joel Fuentes
 * Ayudante: Gaspar Soto
 */

import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Polinomio {
	private int grado= -1;
	private int[] coeficientes;

	public Polinomio() {
		grado = 0;
		coeficientes = new int[1];
		coeficientes[0] = 0;
	}

	public Polinomio(Polinomio polinomio) {
		this.grado = polinomio.grado;
		coeficientes = new int[polinomio.coeficientes.length];
		for (int i = 0; i < polinomio.coeficientes.length; i++)
			coeficientes[i] = polinomio.coeficientes[i];
	}

	public Polinomio(String str) throws DataFormatException {
		// el formato de str es de pares de int, ej. 2,3 indica el polinomio 2x^3. Pares estan separados 
		// por un espacio en blanco. Por ejemplo: 2,3 4,2 -5,0 corresponde a 2x^3 + 4x^2 -5
		Scanner poly = new Scanner(str);
		while (poly.hasNext()) {
			int coef = 0;
			int exponente = 0;
			String term = poly.next();
			Scanner termScan = new Scanner(term);
			termScan.useDelimiter(",");
			// lectura de cada termino (coeficiente,exponente)
			if (termScan.hasNextInt())
				coef = termScan.nextInt();
			else
				throw new DataFormatException("Termino invalido: " + term);
			if (termScan.hasNextInt())
				exponente = termScan.nextInt();
			else
				throw new DataFormatException("Termino invalido: " + term); 
			
			//setear grado polinomio
			if (grado < exponente)
				grado = exponente;
			
			//se crea arreglo de coeficientes
			if (coeficientes == null) {
				coeficientes = new int[grado + 1];
				for (int i = 0; i < coeficientes.length; i++)
					coeficientes[i] = 0;
			}
			coeficientes[exponente] = coef;
		}
	}

	// Duplica el polinomio actual y niega cada termino 
	public	Polinomio negar() {
		if (coeficientes == null)
			return null;
		Polinomio result = new Polinomio(this);
		for (int i = 0; i < result.coeficientes.length; i++)
			if (result.coeficientes[i] != 0)
				result.coeficientes[i] *= -1;
		return result;
	}

	// Suma dos polinomios crendo un nuevo y retornandolo
	public Polinomio sumar(Polinomio polinomio) {
		// Determina cual polinomio es mas grande, el cual se considerar� como base para el resultado
		Polinomio result;
		Polinomio lhs;
		if (grado >= polinomio.grado) {
			// El resultado formado como base de this
			result = new Polinomio(this);
			lhs = polinomio;
		} else {
			result = new Polinomio(polinomio);
			lhs = this;
		}
		for (int i = lhs.grado; i >= 0; i--)
			result.coeficientes[i] += lhs.coeficientes[i];
		return result;
	}

	// Resta el polinomio, primero se niega y luego se suma al actual
	public Polinomio restar(Polinomio polinomio) {
		return this.sumar(polinomio.negar());
	}

	public Polinomio multiplicar(Polinomio polinomio) {
		Polinomio result = new Polinomio();
		result.grado = this.grado + polinomio.grado;
		result.coeficientes = new int[result.grado + 1];
		for (int i = 0; i < polinomio.coeficientes.length; i++)
			for (int j = 0; j < this.coeficientes.length; j++)
				result.coeficientes[i + j] += this.coeficientes[j] * polinomio.coeficientes[i];
		return result;
	}

	// Returns verdadero si los polinomios son igual en todos los aspectos
	public boolean equals(Polinomio polinomio) {
		boolean result = true;
		if (grado != polinomio.grado)
			result = false;
		for (int i = 0; !result && i < grado; i++)
			if (coeficientes[i] != polinomio.coeficientes[i])
				result = false;
		return result;
	}

	// Returns una representacion en String del polinomio
	public String toString() {
		String result = "";
		for (int i = grado; i >= 0; i--) {
			if (i != grado && coeficientes[i] > 0)
				result += '+';
			if (coeficientes[i] != 0)
				result += coeficientes[i];
			if (i > 1 && coeficientes[i] != 0)
				result += "x^" + i + ' ';
			else if (i == 1 && coeficientes[i] != 0)
				result += "x" + ' ';
		}
		return result;
	}
}
