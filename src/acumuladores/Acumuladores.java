package acumuladores;

import java.util.Arrays;

public class Acumuladores {

	/**
	 * Dada una matriz de enteros y un número, verifica si existe alguna fila 
	 * donde todos sus elementos sean múltiplos del número recibido por 
	 * parámetro.
	 * 
	 * Si la matriz está vacía o si el número no es positivo, devuelve falso.
	 * 
	 * @param mat
	 * @param num
	 * @return
	 */
	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) { 
		
		if(num <= 0 || mat == null || mat.length == 0) return false;
		
		boolean ret = false;
		for(int fila = 0; fila < mat.length; fila++) {
			boolean acum = true;
			for(int col = 0; col < mat[fila].length; col++) {
				acum = acum && (mat[fila][col] % num  == 0);
			}
			ret = ret || acum;
		}
		return ret;
		
	}

	/**
	 * Dado 2 matrices se verifica si hay intersección entre las filas de cada
	 * matriz, fila a fila.
	 * 
	 * Si las matrices tienen distinta cantidad de filas o si alguna matriz 
	 * está vacía, devuelve falso.
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	
	private boolean intersectaCon(int[] lista, int valor) {
		boolean ret = false;
		for(int i = 0; i < lista.length && !ret; i++) {
			ret = ret || (lista[i] == valor);
		}
		return ret;
	}
	
	
	public boolean hayInterseccionPorFila(int[][] mat1, int[][]mat2) { 
		
		if(mat1 == null || mat2 == null || mat1.length == 0 || mat1.length != mat2.length) return false;
		
		boolean ret = true;
		for(int fila = 0; fila < mat1.length && ret; fila++){
			boolean acum = false;
			for(int col = 0; col < mat2[fila].length && !acum; col++) {
				acum = acum || intersectaCon(mat1[fila], mat2[fila][col]);
			}
			ret = ret && acum;
		}
		
		return ret;
		
	}
	
	/**
	 * Dada una matriz y el índice de una columna, se verifica si existe alguna
	 * fila cuya suma de todos sus elementos sea mayor estricto que la suma de
	 * todos los elementos de la columna indicada por parámetro.
	 * 
	 * Si el índice de la columna es inválido o la matriz está vacía, devuelve 
	 * falso.
	 * 
	 * @param mat
	 * @param nColum
	 * @return
	 */
	
	private int sumaColumna(int[][] mat, int col) {
		int suma = 0;
		for(int fila = 0; fila < mat.length; fila++) {
			suma += mat[fila][col];
		}
		return suma;
	}
	
	
	private int sumaFila(int[] lista) {
		int suma = 0;
		for(int i = 0; i < lista.length; i++) {
			suma += lista[i];
		}
		return suma;
	}
	
	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) { 
		if(mat == null || mat.length == 0 || nColum < 0 || nColum > (mat[0].length - 1)) return false;
		
		int sumaColumna = sumaColumna(mat,nColum);
		
		boolean ret = false;
		
		for(int fila = 0; fila < mat.length && !ret; fila++) {
			ret = ret || (sumaFila(mat[fila]) > sumaColumna);
		}
		
		return ret;
	}
	
	/**
	 * Dadas 2 matrices, se verifica si hay intersección entre las columnas de
	 * cada matriz, columna a columna.
	 * 
	 * Si las matrices tienen distinta cantidad de columnas o alguna matriz 
	 * está vacía, devuelve falso. 
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorColumna(int[][] mat1, int[][]mat2) { 
		throw new RuntimeException("Metodo no implementado aun!!!");
	}
}
