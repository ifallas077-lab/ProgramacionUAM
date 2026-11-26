/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;

import java.util.Comparator;

/**
 *
 * @author Isaac Fallas
 */
public class ComparadorMascotaPorNombre implements Comparator<Mascota> {

    @Override
    public int compare(Mascota m1, Mascota m2) {
        return m1.getNombre().compareToIgnoreCase(m2.getNombre());
    }
    
}
