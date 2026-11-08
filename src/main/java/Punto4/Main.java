package Punto4;

public class Main {
    public static void main(String[] args){
        Laboratorio laboratorio1 = new Laboratorio("Laboratorio1");

        laboratorio1.insertarEquipo(10);
        laboratorio1.insertarEquipo(8);
        laboratorio1.insertarEquipo(12);
        laboratorio1.insertarEquipo(6);
        laboratorio1.insertarEquipo(9);
        laboratorio1.insertarEquipo(11);
        laboratorio1.insertarEquipo(13);
        laboratorio1.insertarEquipo(5);

        System.out.println("_______________");

        laboratorio1.imprimirArbolInOrden();

        System.out.println("\n");
        System.out.println("_______________");

        int cantidad = laboratorio1.consultarEquipo(8,12);
        System.out.println("Cantidad de equipos: " + cantidad);

        System.out.println("_______________");

        /// _________________________________________

        Laboratorio laboratorio2 = new Laboratorio("Laboratorio2");

        laboratorio2.insertarEquipo(50);
        laboratorio2.insertarEquipo(30);
        laboratorio2.insertarEquipo(70);
        laboratorio2.insertarEquipo(20);
        laboratorio2.insertarEquipo(40);
        laboratorio2.insertarEquipo(60);
        laboratorio2.insertarEquipo(80);
        laboratorio2.insertarEquipo(55);
        laboratorio2.insertarEquipo(65);

        System.out.println("_______________");
        System.out.println("Antes de eliminar");

        laboratorio2.imprimirArbolInOrden();
        System.out.println(" ");

        System.out.println("_______________");

        laboratorio2.eliminarEquipo(50);

        System.out.println("_______________");
        System.out.println("Despues de eliminar");

        laboratorio2.imprimirArbolInOrden();
        System.out.println(" ");

        System.out.println("_______________");


    }

}
