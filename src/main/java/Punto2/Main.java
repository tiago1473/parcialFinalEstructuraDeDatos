package Punto2;

public class Main {
    public static void main(String[] args) {

        //Creo la Pila
        Pila<String> pila = new Pila<>();
        pila.apilar("Comer");
        pila.apilar("Dormir");
        pila.apilar("Jugar");
        pila.apilar("Saltar");
        pila.apilar("Correr");
        pila.apilar("Llorar");
        pila.apilar("Trabajar");

        //Obtengo la Pila dentro del Segmento 2 - 4
        Pila<String> pilaRango1 = HistorialAcciones.obtenerSegmento(pila, 2, 4);
        System.out.println("===== Pila Dentro del Segmento 2 - 4 ===");
        pilaRango1.imprimirPila();

        //Obtengo la Pila dentro del Segmento 2 - 10 (La Pila Solo tiene 7 Elementos)
        Pila<String> pilaRango2 = HistorialAcciones.obtenerSegmento(pila, 2, 10);
        System.out.println("===== Pila Dentro del Segmento 2 - 10 ===");
        if(pilaRango2.isEmpty()){
            System.out.println("Pila Vacía");
        }else{
            pilaRango2.imprimirPila();
        }

        //Obtengo la Pila dentro del Segmento 2 - 2
        Pila<String> pilaRango3 = HistorialAcciones.obtenerSegmento(pila, 2, 2);
        System.out.println("===== Pila Dentro del Segmento 2 - 2 ====");
        pilaRango3.imprimirPila();

        //Imprimo La Pila Original
        System.out.println("===== Pila Original ====");
        pila.imprimirPila();
    }
}