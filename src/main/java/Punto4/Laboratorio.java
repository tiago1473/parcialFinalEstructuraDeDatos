package Punto4;

public class Laboratorio<T> {
    private String nombre;
    private Tree<Integer> arbol; // se manejan solo los codigos de los equipos, mas no una clase de Equipo

    public Laboratorio(String nombre) {
        this.nombre = nombre;
        this.arbol = new Tree<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void imprimirArbolInOrden(){
        arbol.inOrden();
    }

    public void insertarEquipo(int codigo){
        arbol.insertar(codigo);
    }

    public void eliminarEquipo(int codigo){
        arbol.eliminar(codigo);
    }

    public int consultarEquipo(int inferior, int superior){
        return arbol.contarEquiposEnRango(inferior, superior);
    }

    @Override
    public String toString() {
        return "Laboratorio{" +
                "nombre='" + nombre + '\'' +
                ", arbol=" + arbol +
                '}';
    }
}
