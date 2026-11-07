package Punto4;

public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;
    private int peso;

    public Tree() {
        this.peso = 0;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    /// METODOS BASICOS DE ARBOL BINARIO DE BUSQUEDA ___________________

    /// INORDEN
    public void inOrden() {
        inOrden(root);
    }

    private void inOrden(TreeNode<T> rootAux) {
        if (rootAux == null) {
            return;
        }

        inOrden(rootAux.getLeftChild());
        System.out.print(" " + rootAux.getElement());
        inOrden(rootAux.getRightChild());
    }


    /// PREORDEN
    public void preOrden() {
        preOrden(root);
    }

    private void preOrden(TreeNode<T> rootAux) {
        if (rootAux == null) {
            return;
        }

        System.out.println(rootAux.getElement());
        preOrden(rootAux.getLeftChild());
        preOrden(rootAux.getRightChild());
    }


    /// POSTORDEN
    public void postOrden() {
        postOrden(root);
    }

    private void postOrden(TreeNode<T> rootAux) {
        if (rootAux == null) {
            return;
        }

        postOrden(rootAux.getLeftChild());
        postOrden(rootAux.getRightChild());
        System.out.println(rootAux.getElement());
    }


    /// OBTENER PESO
    public int obtenerPeso() {
        return obtenerPeso(root);
    }

    private int obtenerPeso(TreeNode<T> rootAux) {
        if (rootAux == null) {
            return 0;
        }

        return 1 + obtenerPeso(rootAux.getLeftChild()) + obtenerPeso(rootAux.getRightChild());
    }


    /// CALCULAR ALTURA
    public int calcularAltura() {
        return calcularAltura(root);
    }

    private int calcularAltura(TreeNode<T> rootAux) {
        if (rootAux == null) {
            return 0;
        }

        int alturaIzq = 1 + calcularAltura(rootAux.getLeftChild());
        int alturaDer = 1 + calcularAltura(rootAux.getRightChild());
        if (alturaIzq > alturaDer) {
            return alturaIzq;
        } else return alturaDer;

    }


    ///  BUSCAR NODO
    public TreeNode<T> buscarNodo(T buscado) {
        return buscarNodo(root, buscado);
    }

    private TreeNode<T> buscarNodo(TreeNode<T> rootAux, T buscado) {
        if (rootAux == null) {
            return null;
        }
        int cmp = rootAux.getElement().compareTo(buscado);

        if (cmp == 0) {
            return rootAux;
        }

        if (cmp > 0) {
            return buscarNodo(rootAux.getLeftChild(), buscado);
        }
        return buscarNodo(rootAux.getRightChild(), buscado);

    }


    /// INSERTAR NODO
    public void insertar(T element) {
        root = insertar(root, element, root);
    }

    private TreeNode<T> insertar(TreeNode<T> rootAux, T element, TreeNode<T> fatherAux) {
        if (rootAux == null) { // si está vacio el arbol, lo deja de raiz
            System.out.println("Insertado " + element);
            peso++;
            return new TreeNode<>(element, fatherAux);
        }

        int cmp = rootAux.getElement().compareTo(element);

        if (cmp == 0) { // no se guardan elementos repetidos
            throw new IllegalArgumentException("El elemento ya existe en el arbol");
        }

        if (cmp > 0) {
            rootAux.setLeftChild(insertar(rootAux.getLeftChild(), element, rootAux)); // si la raiz es mayor, se inserta a la izquierda
        } else {
            rootAux.setRightChild(insertar(rootAux.getRightChild(), element, rootAux)); // si la raiz es menor, se inserta a la derecha
        }
        return rootAux;
    }


    /// ELIMINAR NODO
    public void eliminar(T element) {
        eliminar(root, element);
    }

    private void eliminar(TreeNode<T> rootAux, T element) {

        TreeNode<T> encontrado = buscarNodo(rootAux, element);

        if (encontrado == null) { ///Elemento no existe en el arbol
            System.out.println("El elemento no existe en el arbol");
            return;
        }

        if (encontrado == root && !(encontrado.getLeftChild() != null && encontrado.getRightChild() != null)) {  /// Es la Raiz y tiene solo 0 o 1 hijos
            if (encontrado.getLeftChild() == null && encontrado.getRightChild() == null) {  // si no tiene hijos
                root = null;
            } else if (encontrado.getLeftChild() == null && encontrado.getRightChild() != null) { // el hijo esta a la derecha
                root = encontrado.getRightChild();
                root.setFather(null);
            } else {  // el hijo esta a la izquierda
                root = encontrado.getLeftChild();
                root.setFather(null);
            }
            System.out.println("Nodo eliminado");
            peso--;
            return;
        }

        if (encontrado.getLeftChild() == null && encontrado.getRightChild() == null) { /// PRIMER CASO: ES UN NODO HOJA
            int cmp = encontrado.getFather().getElement().compareTo(element);

            if (cmp > 0) {
                encontrado.getFather().setLeftChild(null); // esta a la izquierda
            } else {
                encontrado.getFather().setRightChild(null);  // esta a la derecha
            }
            System.out.println("Nodo eliminado");
            peso--;
            return;
        }

        // SEGUNDO CASO: TIENE UN HIJO
        if (!(encontrado.getLeftChild() != null && encontrado.getRightChild() != null)) {
            int cmp = encontrado.getFather().getElement().compareTo(element); // para saber si está a la izq o der del padre

            if (cmp > 0) {  // lado izquierdo del padre del encontrado(nodo a eliminar)
                if (encontrado.getLeftChild() != null) {  // hijo izquierdo del encontrado
                    encontrado.getLeftChild().setFather(encontrado.getFather()); // seteamos padre a hijo
                    encontrado.getFather().setLeftChild(encontrado.getLeftChild()); // seteamos hijo a padre
                } else { // hijo derecho del encontrado
                    encontrado.getRightChild().setFather(encontrado.getFather()); // seteamos padre a hijo
                    encontrado.getFather().setLeftChild(encontrado.getRightChild()); // seteamos hijo a padre
                }
            } else {  // lado derecho del padre del encontrado(nodo a eliminar)
                if (encontrado.getLeftChild() != null) {  // lado izquierdo del encontrado
                    encontrado.getLeftChild().setFather(encontrado.getFather()); // seteamos padre a hijo
                    encontrado.getFather().setRightChild(encontrado.getLeftChild()); // seteamos hijo a padre
                } else {  // hijo derecho del encontrado
                    encontrado.getRightChild().setFather(encontrado.getFather()); // seteamos padre a hijo
                    encontrado.getFather().setRightChild(encontrado.getRightChild()); // seteamos hijo a padre
                }
            }

        } else {  // TERCER CASO: TIENE DOS HIJOS

            TreeNode<T> nodoAux = encontrarNodoAux(encontrado.getLeftChild());  // maximo de la izquierda

            encontrado.setElement(nodoAux.getElement());

            if (nodoAux.getFather() == encontrado) {  // el maximo es el hijo izquierdo directo
                encontrado.setLeftChild(nodoAux.getLeftChild());
            } else {  // el maximo es hijo derecho de su padre
                nodoAux.getFather().setRightChild(nodoAux.getLeftChild());
            }
            if (nodoAux.getLeftChild() != null) {  // si tenia hijo, que ese hijo apunte al nuevo padre
                nodoAux.getLeftChild().setFather(nodoAux.getFather());
            }
        }

        System.out.println("Nodo eliminado");
        peso--;
    }


    /// Encuentra el maximo valor del subarbol izquierdo
    private TreeNode<T> encontrarNodoAux(TreeNode<T> rootAux) {
        if (rootAux.getRightChild() == null) {
            return rootAux;
        }

        return encontrarNodoAux(rootAux.getRightChild());
    }

    /// ________________________________________________________________

    /// contar Equipos En Rango

    public int contarEquiposEnRango(T lower, T upper) {
        if (lower.compareTo(upper) > 0 || isEmpty()) {  // inferior mayor a superior o esta vacio el arbol
            return 0;
        }
        return contarEquiposEnRango(root, lower, upper);
    }

    private int contarEquiposEnRango(TreeNode<T> rootAux, T lower, T upper) {
        if (rootAux == null) {  // caso base
            return 0;
        }

       if(rootAux.getElement().compareTo(lower) < 0){  /// Si el nodo es menor que el inferior, descarto su izquierda, porque todo ahí es aun menor.
           return contarEquiposEnRango(rootAux.getRightChild(), lower, upper);
       } else if (rootAux.getElement().compareTo(upper) > 0) {  /// Si el nodo es mayor que el superior, descarto su derecha, por la misma razon.
           return contarEquiposEnRango(rootAux.getLeftChild(), lower, upper);
       } else{  /// Si está en rango, cuento 1 y reviso ambos lados, porque en los dos puede haber más equipos en rango.
           return 1 + contarEquiposEnRango(rootAux.getLeftChild(),lower, upper) + contarEquiposEnRango(rootAux.getRightChild(), lower, upper);
       }

    }
}
