package Punto1;

public class HistorialOperaciones {

    public static Pila<Operacion> obtenerUltimasConfirmadas(Pila<Operacion> historial, int n){
        Pila<Operacion> pilaResultado = new Pila<>();
        if(n <= 0){
            return pilaResultado;
        }else{
            Pila<Operacion> copia = historial.clonarPila();
            Pila<Operacion> pilaAuxiliar = new Pila<>();
            int encontradas = 0;

            while(!copia.isEmpty() && encontradas < n){
                Operacion operacion = copia.desapilar();
                if(operacion.getEstado() == Estado.CONFIRMADA){
                    pilaAuxiliar.apilar(operacion);
                    encontradas++;
                }
            }
            //Invierto para el Resultado
            while(!pilaAuxiliar.isEmpty()){
                pilaResultado.apilar(pilaAuxiliar.desapilar());
            }
            return pilaResultado;
        }
    }
}
