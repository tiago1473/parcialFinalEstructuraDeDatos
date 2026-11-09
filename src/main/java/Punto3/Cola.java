package Punto3;

import java.util.NoSuchElementException;

public class Cola<T> {

    private int size;
    private Nodo<T> nodoPrimero;
    private Nodo<T> nodoUltimo;

    public Cola() {
        size = 0;
        nodoPrimero = null;
        nodoUltimo = null;
    }

    public int getSize() {
        return size;
    }

    // 2. agregar al final de la cola
    public void encolar(T dato){
        Nodo<T> nuevoNodo = new Nodo<T>(dato);
        if(isEmpty()){
            nodoPrimero = nuevoNodo;
            nodoUltimo = nuevoNodo;
        }else{
            nodoUltimo.setSiguiente(nuevoNodo);
            nodoUltimo = nuevoNodo;
        }
        size++;
    }

    // 2. eliminar al inicio de la cola
    public T desencolar(){
        if(isEmpty()){
            throw new NoSuchElementException("No hay elementos en la cola");
        }else{
            T dato = nodoPrimero.getDato();
            nodoPrimero = nodoPrimero.getSiguiente();
            if(nodoPrimero == null){
                nodoUltimo = null;
            }
            size--;
            return dato;
        }

    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void imprimir( ) {
        imprimir(nodoPrimero);
    }

    private void imprimir(Nodo<T> aux ) {
        if(aux == null){
            return;
        }else {
            System.out.println(aux.getDato().toString());
            imprimir(aux.getSiguiente());
        }
    }
}