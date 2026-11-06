package Punto1;

public class Pila<T> {
    private int size;
    private Nodo<T> cima;

    public Pila() {
        this.size = 0;
        this.cima = null;
    }

    public boolean isEmpty(){
        return cima == null;
    }

    public void apilar(T dato){
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if(isEmpty()){
            cima = nuevoNodo;
        }else{
            nuevoNodo.setSiguiente(cima);
            cima = nuevoNodo;
        }
        size ++;
    }

    public T desapilar(){
        if(isEmpty()){
            throw new PilaVacia("La Pila Está Vacía");
        }else{
            T dato = cima.getDato();
            cima = cima.getSiguiente();
            size--;
            return dato;
        }
    }

    //Método para añadir una pila a la original
    public void addPila(Pila<T> pilaNueva){
        if (pilaNueva.isEmpty()) {
            return;
        }
        Pila<T> pilaAuxiliar = new Pila<>();
        Nodo<T> nodoAuxiliar = pilaNueva.cima;
        while(nodoAuxiliar != null){
            pilaAuxiliar.apilar(nodoAuxiliar.getDato());
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        while(!pilaAuxiliar.isEmpty()){
            this.apilar(pilaAuxiliar.desapilar());
        }
    }

    public Pila<T> clonarPila(){
        Pila<T> pilaClonada = new Pila<>();
        if(isEmpty()){
            return pilaClonada;
        }else{
            Pila<T> pilaAuxiliar = new Pila<>();
            Nodo<T> nodoActual = cima;
            while(nodoActual != null){
                pilaAuxiliar.apilar(nodoActual.getDato());
                nodoActual = nodoActual.getSiguiente();
            }
            while(!pilaAuxiliar.isEmpty()){
                pilaClonada.apilar(pilaAuxiliar.desapilar());
            }
            return pilaClonada;
        }
    }

    public void imprimirPila(){
        if(isEmpty()){
            System.out.println("La Pila Está Vacía");
        }else{
            Nodo<T> nodoAuxiliar = cima;
            while(nodoAuxiliar != null){
                System.out.print(nodoAuxiliar.getDato());
                nodoAuxiliar = nodoAuxiliar.getSiguiente();
            }
        }
    }

    public void limpiarPila(){
        this.cima = null;
        this.size = 0;
    }

    public int sizePila(){
        return this.size;
    }

    public Nodo<T> getCima() {
        return cima;
    }

    public int getSize() {
        return size;
    }

}
