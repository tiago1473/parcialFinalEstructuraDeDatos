package Punto1;

public class Main {
    public static void main(String[] args) {
        //Creo el Historial
        Pila<Operacion> historial = new Pila<>();
        historial.apilar(new Operacion("O1", Estado.ANULADA));
        historial.apilar(new Operacion("O2", Estado.CONFIRMADA));
        historial.apilar(new Operacion("O3", Estado.CONFIRMADA));
        historial.apilar(new Operacion("O4", Estado.ANULADA));
        historial.apilar(new Operacion("O5", Estado.CONFIRMADA));

        System.out.println("Historial original:");
        historial.imprimirPila();

        //Para n = 1
        Pila<Operacion> resultado1 = HistorialOperaciones.obtenerUltimasConfirmadas(historial, 1);
        System.out.println("\n\nÚltimas 1 Operaciones Confirmadas:");
        resultado1.imprimirPila();

        //Para n = 2
        Pila<Operacion> resultado2 = HistorialOperaciones.obtenerUltimasConfirmadas(historial, 2);
        System.out.println("\n\nÚltimas 2 Operaciones Confirmadas:");
        resultado2.imprimirPila();

        //Para n = 6
        Pila<Operacion> resultado3 = HistorialOperaciones.obtenerUltimasConfirmadas(historial, 6);
        System.out.println("\n\nÚltimas 6 Operaciones Confirmadas:");
        resultado3.imprimirPila();

        //Historial vacío
        System.out.println("\n\nHistorial vacío con n = 3:");
        HistorialOperaciones.obtenerUltimasConfirmadas(new Pila<>(), 3).imprimirPila();

        //Verificar que el historial no cambió
        System.out.println("\n\nHistorial después de la llamada:");
        historial.imprimirPila();
    }
}