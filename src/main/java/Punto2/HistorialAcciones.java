package Punto2;

public class HistorialAcciones {

    public static <T> Pila<T> obtenerSegmento(Pila<T> historial, int inicio, int fin){
        Pila<T> pilaResultado = new Pila<>();
        if(inicio < 1 || fin > historial.getSize() || inicio > fin ){
            return pilaResultado;
        }else{
            int posicion = 1;
            Pila<T> pilaClonada = historial.clonarPila();
            Pila<T> pilaAuxiliar = new Pila<>();
            while(posicion <= fin){
                T dato = pilaClonada.desapilar();
                if(posicion >= inicio){
                    pilaAuxiliar.apilar(dato);
                }
                posicion++;
            }
            //Revierto el Orden
            while(!pilaAuxiliar.isEmpty()){
                pilaResultado.apilar(pilaAuxiliar.desapilar());
            }
            return pilaResultado;
        }
    }
}
