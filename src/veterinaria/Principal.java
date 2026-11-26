/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Isaac Fallas
 */
public class Principal {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("11111111", "Ronaldo", "7777777777");
        Mascota mascota1 = new Mascota("Luna", "perro", 5, 25.5, cliente1);
        Mascota mascota2 = new Mascota("Goku", "Loro", 3, 0.8);

        mascota1.mostrarResumen();
        System.out.println("Dueno: " + mascota1.getDuenio().getIdentificacion());
        System.out.println("===================");
        mascota2.mostrarResumen();

        cliente1.setIdentificacion("2222222222222");
        System.out.println("Dueno: " + mascota1.getDuenio().getIdentificacion());

        Veterinario veterinario1 = new Veterinario("V001", "Medicina General", "Dra Shirley Cruz");

        Consulta consulta1 = new Consulta(
                "5/10/2026",
                "Control General",
                mascota1,
                15000,
                veterinario1);

        consulta1.mostrarResumen();
        System.out.println("===================");
        consulta1.actualizarCosto(17500);
        consulta1.mostrarResumen();
        System.out.println("===================");
        consulta1.actualizarCosto(18000, "Control y medicamento");
        consulta1.mostrarResumen();

        Cliente cliente2 = new Cliente("12345678910", "Carlos Mora", "8888888888");
        Persona personaReferencia = cliente2;

        System.out.println(cliente2.getNombre());
        System.out.println(personaReferencia.getNombre());

        System.out.println("========Resumibles========");

        Resumible r1 = cliente1;
        Resumible r2 = mascota1;
        Resumible r3 = consulta1;

        r1.mostrarResumen();
        r2.mostrarResumen();
        r3.mostrarResumen();

        System.out.println("==========ArrayList Mascotas==========");

        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        mascotas.add(mascota1);
        mascotas.add(mascota2);
        mascotas.add(new Mascota("Luffy", "Perro", 1, 30));

        if (!mascotas.isEmpty()) {
            Mascota primera = mascotas.get(0);
            primera.mostrarResumen();
        }
        System.out.println("=====Recorre Array List=====");
        for (int i = 0; i < mascotas.size(); i++) {
            mascotas.get(i).mostrarResumen();
        }

        System.out.println("========Array Mascotas======");
        Mascota[] mascotas1 = new Mascota[3];
        mascotas1[0] = mascota2;
        mascotas1[1] = mascota1;
        mascotas1[2] = new Mascota("Luffy", "perro", 1, 1);
        if (mascotas1.length > 0) {
            System.out.println("=======Primera========");
            Mascota primera = mascotas1[0];
            primera.mostrarResumen();
        }
        System.out.println("=====Recorre Array =====");
        for (int i = 0; i < mascotas1.length; i++) {
            mascotas1[i].mostrarResumen();
        }

        System.out.println("=======Recorre Array List de Consultas=======");

        ArrayList<Consulta> consultas = new ArrayList<Consulta>();
        consultas.add(consulta1);

        consultas.add(new Consulta("12/10/2026", "Vacunas", mascota2, 1000, veterinario1));

        for (int i = 0; i < consultas.size(); i++) {
            consultas.get(i).mostrarResumen();
        }

        System.out.println("=======Recorre Array List de Resumibles=======");

        ArrayList<Resumible> resumibles = new ArrayList<Resumible>();

        resumibles.add(cliente2);
        resumibles.add(veterinario1);
        resumibles.add(mascota2);
        resumibles.add(consulta1);

        for (int i = 0; i < resumibles.size(); i++) {
            resumibles.get(i).mostrarResumen();
            System.out.println("==============");
        }

        System.out.println("==== Repositorios ====");

        Repositorio<Mascota> repoMascotas = new Repositorio<Mascota>();
        Repositorio<Consulta> repoConsultas = new Repositorio<Consulta>();

        repoMascotas.agregar(mascota1);
        repoMascotas.agregar(mascota2);
        repoMascotas.agregar(new Mascota("zoro", "perro", 1, 1));
        repoConsultas.agregar(consulta1);

        System.out.println(repoMascotas.contar());
        System.out.println(repoConsultas.contar());

        repoMascotas.listar();
        Utilidades.mostrarTodos(mascotas);
        Utilidades.mostrarTodos(repoMascotas.obtenerTodos());

        System.out.println("Comparando mascota 1 y 2");
        int resultadoComparacion = mascota1.compareTo(mascota2);
        if (resultadoComparacion > 0) {
            System.out.println("Mascota1 pesa mas");
        } else if (resultadoComparacion < 0) {
            System.out.println("Mascota2 pesa mas");
        } else {
            System.out.println("Mascotas pesan igual");
        }
        
        System.out.println("Mascota con mayor peso");
        Mascota mayorPeso = Utilidades.obtenerMayor(mascotas);
        if(mayorPeso != null) {
            mayorPeso.mostrarResumen();
        }
        
        System.out.println("Listas Ordenadas");
        System.out.println("======MASCOTAS ORDENADAS POR PESO======");
        Collections.sort(mascotas);
        Utilidades.mostrarTodos(mascotas);
        System.out.println("=====MASCOTAS ORDENADAS POR NOMBRE=====");
        Collections.sort(mascotas, new ComparadorMascotaPorNombre());
        Utilidades.mostrarTodos(mascotas);
        
        System.out.println("*****Iterador Mascotas*******");
        Iterator<Mascota> iterador = repoMascotas.obtenerTodos().iterator();
        
        while(iterador.hasNext()){
            Mascota mascota = iterador.next();
            mascota.mostrarResumen();
        }
        
        System.out.println("*****Clones*****");
        Mascota copiaMascota = mascota1.clone();
        Mascota linkMascota = mascota1;
        
        System.out.println("Misma Mascota = "+ (linkMascota == mascota1)); // true 
        System.out.println("Misma Mascota = "+ (copiaMascota == mascota1)); // false 
        
        System.out.println("Mismo Duenio = " +
                (copiaMascota.getDuenio() == mascota1.getDuenio()));// true 
        
        Mascota copiaMascota2 = mascota1.copiaProfunda();
        System.out.println("Mismo Duenio = " +
                (copiaMascota.getDuenio() == mascota1.getDuenio()));//false
        
        System.out.println("MAscota original: ");
        mascota1.mostrarResumen();
        
        System.out.println("Mascota clonada: ");
        copiaMascota.mostrarResumen();
        
        System.out.println("Mascota clonada2: ");
        copiaMascota2.mostrarResumen();
        
        System.out.println("===Clone de Consulta===");
        Consulta copiaConsulta = consulta1.clone();
        System.out.println("Diferentes Consultas: " +
                (copiaConsulta == consulta1));//false
        System.out.println("Consulta1: ");
        consulta1.mostrarResumen();
        System.out.println("Copia consulta: ");
        copiaConsulta.mostrarResumen();
        
        //CRUD es igual a: 
        //CREATE 
        //READ
        //UPDATE
        //DELETE
        
        System.out.println("==CRUD en memoria repositorio==");
        copiaMascota2.setNombre("Naruto");
        repoMascotas.agregar(copiaMascota2);
        System.out.println(" == todas las mascotas del repositorio === ");
        repoMascotas.listar();
        System.out.println("=== Obtener y Copiar Mascota de repo ===");
        Mascota copiaMascotaRepo = repoMascotas.obtener(3).copiaProfunda();
        if(copiaMascotaRepo != null){
            System.out.println("Los datos de la mascota encontrada son: ");
            copiaMascotaRepo.mostrarResumen();
            System.out.println("actualizacion de mascota en repo");
            copiaMascotaRepo.setNombre("Goku SS");
            if(repoMascotas.actualizar(3, copiaMascotaRepo)){
                System.out.println("Mascota actualizada correctamente");
            }else {
                System.out.println("No se pudo actualizar la mascota");
            }
            
        }else{
            System.out.println("Mascota no encontrada");
        }
        System.out.println("===Todas las mascotas del repositorio==");
        repoMascotas.listar();
        
        System.out.println("=== ELiminar mascota===");
        boolean elimino = repoMascotas.eliminar(4);
        if(elimino){
            System.out.println("Mascota Eliminada correctamente");
        }else {
            System.out.println("No se pudo eliminar la mascota");
        }
        System.out.println("===Todas las mascotas del repositorio==");
        repoMascotas.listar();
        
    }
}
