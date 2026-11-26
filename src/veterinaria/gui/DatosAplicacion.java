package veterinaria.gui;

import veterinaria.Cliente;
import veterinaria.Consulta;
import veterinaria.Mascota;
import veterinaria.Repositorio;
import veterinaria.Veterinario;

public final class DatosAplicacion {

    public static final Repositorio<Cliente> CLIENTES
            = new Repositorio<>();
    public static final Repositorio<Veterinario> VETERINARIOS
            = new Repositorio<>();
    public static final Repositorio<Mascota> MASCOTAS
            = new Repositorio<>();
    public static final Repositorio<Consulta> CONSULTAS
            = new Repositorio<>();
    private static boolean inicializado = false;

    private DatosAplicacion() {
    }

    public static void inicializar() {
        if (inicializado) {
            return;
        }
        inicializado = true;
        Cliente c1 = new Cliente("C001", "Ana Pérez", "8888-1111");
        Cliente c2 = new Cliente("C002", "Luis Soto", "8777-2222");
        CLIENTES.agregar(c1);
        CLIENTES.agregar(c2);
        // Orden real del constructor: código, especialidad, nombre.
        Veterinario v1 = new Veterinario(
                "V001", "Medicina general", "Dra. Ana Torres");
        Veterinario v2 = new Veterinario(
                "V002", "Cirugía", "Dr. Carlos Vega");
        VETERINARIOS.agregar(v1);
        VETERINARIOS.agregar(v2);
        Mascota m1 = new Mascota("Luna", "Perro", 3, 12.5, c1);
        Mascota m2 = new Mascota("Milo", "Gato", 2, 4.2);//, c2);
        MASCOTAS.agregar(m1);
        MASCOTAS.agregar(m2);
        CONSULTAS.agregar(new Consulta(
                "04/11/2026", "Control general", m1, 15000.0, v1));
    }
}
