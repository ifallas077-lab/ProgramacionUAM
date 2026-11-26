/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;

import java.util.ArrayList;

/**
 *
 * @author Isaac Fallas
 */
public class Utilidades {

    public static <T extends Resumible> void mostrarTodos(ArrayList<T> lista) {

        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).mostrarResumen();
        }
    }

    public static <T extends Comparable<T>> T obtenerMayor(ArrayList<T> lista) {
        if (lista == null || lista.isEmpty()) {
            return null;
        }

        T mayor = lista.get(0);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).compareTo(mayor) > 0) {
                mayor = lista.get(i);
            }
        }
        return mayor;
    }
}
