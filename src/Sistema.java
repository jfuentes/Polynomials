/**
 *****Solución Tarea 1*******
 * Estructura de Datos 2013-1
 * Prof. Joel Fuentes
 * Ayudante: Gaspar Soto
 */

import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Sistema {

	public static void main(String[] args) {
		int opcion1 = 0, opcion2 = 0;
		String linea;
		Scanner sc;

		do {
			System.out.print("\n*****SISTEMA MATEMATICO*****");
			System.out.print("\n1.- Ingresar Polinomio");
			System.out.print("\n2.- Salir");
			System.out.print("\nopcion: ");
			sc = new Scanner(System.in);
			linea = sc.nextLine();
			opcion1 = Integer.parseInt(linea);
			if (opcion1 == 1) {
				Polinomio poly = null;
				System.out.print("\nIngrese polinomio: ");
				linea = sc.nextLine();
				try {
					poly = new Polinomio(linea);
				} catch (DataFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (poly != null)
					do {
						System.out.print("\n1.- Negar Polinomio");
						System.out.print("\n2.- Sumar a Polinomio");
						System.out.print("\n3.- Restar a Polinomio");
						System.out.print("\n4.- Multiplicar a Polinomio");
						System.out.print("\n5.- Volver");
						System.out.print("\nopcion: ");
						linea = sc.nextLine();
						opcion2 = Integer.parseInt(linea);
						switch (opcion2) {
						case 1:
							System.out.print("\nPolinomio negado: "
									+ (poly.negar()).toString());
							break;
						case 2: {
							System.out.print("\nIngrese polinomio: ");
							linea = sc.nextLine();
							try {
								Polinomio poly2 = new Polinomio(linea);
								Polinomio resultado = poly.sumar(poly2);
								System.out.print("\nresultado de: "
										+ poly.toString() + " + "
										+ poly2.toString() + " = "
										+ resultado.toString());

							} catch (DataFormatException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}
						case 3: {
							System.out.print("\nIngrese polinomio: ");
							linea = sc.nextLine();
							try {
								Polinomio poly2 = new Polinomio(linea);
								Polinomio resultado = poly.restar(poly2);
								System.out.print("\nresultado de: "
										+ poly.toString() + " - "
										+ poly2.toString() + " = "
										+ resultado.toString());

							} catch (DataFormatException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}
						case 4: {
							System.out.print("\nIngrese polinomio: ");
							linea = sc.nextLine();
							try {
								Polinomio poly2 = new Polinomio(linea);
								Polinomio resultado = poly.multiplicar(poly2);
								System.out.print("\nresultado de: "
										+ poly.toString() + " * "
										+ poly2.toString() + " = "
										+ resultado.toString());

							} catch (DataFormatException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}
						case 5:
							break;
						default:
							System.out.print("\nopcion no valida!");
						}
					} while (opcion2 != 5);
			}
		} while (opcion1 != 2);
	}

}
