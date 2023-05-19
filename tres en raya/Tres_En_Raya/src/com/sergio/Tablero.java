package com.sergio;

public class Tablero {
    private String[][] tablero;

    public Tablero() {
        tablero = new String[3][3];
        limpiar();
    }

    public void limpiar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = "";
            }
        }
    }

    public boolean estaVacia(int fila, int columna) {
        return tablero[fila][columna].equals("");
    }

    public void marcar(int fila, int columna, String simbolo) {
        tablero[fila][columna] = simbolo;
    }

    public String obtenerValor(int fila, int columna) {
        return tablero[fila][columna];
    }

    public void mostrar() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                String valor = estaVacia(i, j) ? " " : obtenerValor(i, j);
                System.out.print(valor);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
    }
}



