package Punto4;

public class Main {
    public static void main(String[] args){
        Laboratorio laboratorio = new Laboratorio("Laboratorio");

        laboratorio.insertarEquipo(10);
        laboratorio.insertarEquipo(8);
        laboratorio.insertarEquipo(12);
        laboratorio.insertarEquipo(6);
        laboratorio.insertarEquipo(9);
        laboratorio.insertarEquipo(11);
        laboratorio.insertarEquipo(13);
        laboratorio.insertarEquipo(5);

        System.out.println("_______________");
        laboratorio.imprimirArbolInOrden();
        System.out.println("\n");
        System.out.println("_______________");
        int cantidad = laboratorio.consultarEquipo(8,12);
        System.out.println("Cantidad de equipos: " + cantidad);


    }

}
