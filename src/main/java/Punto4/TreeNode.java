package Punto4;

import java.util.Objects;

public class TreeNode<T> {
    private T element;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;
    private TreeNode<T> father;

    public TreeNode(T element) {
        this.element = element;
        this.leftChild = null;
        this.rightChild = null;
        this.father = null;
    }

    public TreeNode(T element, TreeNode<T> leftChild, TreeNode<T> rightChild) {
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public TreeNode(T element, TreeNode<T> father) {
        this.element = element;
        this.father = father;
    }

    public T getElement() {
        return this.element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public TreeNode<T> getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode<T> getFather() {
        return this.father;
    }

    public void setFather(TreeNode<T> father) {
        this.father = father;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return Objects.equals(element, treeNode.element) && Objects.equals(leftChild, treeNode.leftChild) && Objects.equals(rightChild, treeNode.rightChild) && Objects.equals(father.element, treeNode.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, leftChild, rightChild, father.element);
    }

    @Override
    public String toString() {
        T fatherAux = null;

        if(father != null) {
            fatherAux = father.element;
        }

        String cadena = "TreeNode{" +
                "element=" + element +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                ", father=" + fatherAux +
                '}';
        return cadena;
    }
}

