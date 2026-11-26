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
public class Repositorio<T extends Resumible> {

    private ArrayList<T> elementos;

    public Repositorio() {
        elementos = new ArrayList<T>();
    }

    public void agregar(T elemento) {
        if (elemento != null) {
            elementos.add(elemento);
        } else {
            System.out.println("NO se puede agregar un elemento nulo");
        }

    }
    
    public T obtener (int posicion) {
        if(posicion >= 0 && posicion < elementos.size()){
            return elementos.get(posicion);
        }
        return null;
    }
    
    public boolean actualizar (int posicion, T nuevoElemento) {
        if (posicion >= 0 && posicion < elementos.size()) {
            elementos.set(posicion, nuevoElemento);
            return true;
        }
        return false;
    }
    
    public boolean eliminar(int posicion){
        if (posicion >= 0 && posicion < elementos.size()) {
           elementos.remove(posicion);
           return true;
        }
        return false;
    }

    public int contar() {
        return elementos.size();
    }

    public ArrayList<T> obtenerTodos() {
        return elementos;
    }
    
    public void listar() {
        for (int i = 0; i < elementos.size(); i++) {
            elementos.get(i).mostrarResumen();
        } 
    }

}
