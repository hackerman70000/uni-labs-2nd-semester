package task1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;


/**
 * Klasa reprezentująca drzewo binarne
 *
 * @param <T> typ przechowywanych danych
 */
public class BinaryTree<T extends Comparable<T>> implements Iterable<BinaryTree<T>.Node>{
    private Node root;

    /**
     * Metoda ta doadaje elementy do drzewa binarnego
     * @param value dodawana wartość
     */
    public void add(T value){
        if(root == null){
            root = new Node(value);
        }
        add(value, root);
    }

    /**
     * Metoda rekurencyjna odpowiadająca za umieszczenie elementu na odpowiedniej pozycji
     * @param value dodawana wartość
     * @param current Węzeł, korzeń podrzewa do którego chcemy dodać nowy węzeł
     * @return Dziecko węzła current (lewe lub prawe)
     */
    private Node add(T value, Node current){
        if(current == null){
            return new Node(value);
        }

        if(value.compareTo(current.getValue()) < 0) {
            current.left = add(value, current.getLeft()); // jeżeli element jest mniejszy od rodzica to zostaje lewym dzieckiem

        } else if(value.compareTo(current.getValue()) > 0) {
            current.right = add(value, current.getRight()); // jeżeli element jest mniejszy od rodzica a nie został lewym dzieckiem to zostaje prawym dzieckiem
        }
        return current;
    }

    public Node getRoot(){
        return root;
    }

    @Override
    public Iterator<Node> iterator(){
        if(getRoot() != null)
            return new TreeIterator();
        throw new NoSuchElementException();
    }

    @Override
    public String toString(){
        Iterator<Node> iterator = this.iterator();
        StringBuilder sb = new StringBuilder();

        while(iterator.hasNext()){ // wypisanie wszystkich wartości
            sb.append(iterator.next().toString()).append(" ");
        }
        return sb.toString();
    }

    /**
     * Klasa ta reprezentuje węzeł w drzewie binarnym BinaryTree
     */
    class Node{
        private final T value;
        private Node left, right;

        private Node(T value){
            this.value = value;
        }

        public T getValue(){
            return value;
        }

        public Node getLeft(){
            return left;
        }

        public Node getRight(){
            return right;
        }

        @Override
        public String toString(){
            return String.valueOf(value);
        }
    }

    /**
     * Klasa do iteracji po drzewie binarnym BinaryTree
     */
    class TreeIterator implements Iterator<BinaryTree<T>.Node>{
        private final Queue<BinaryTree<T>.Node> queue; // kolejka z uporządkowanymi wartościami
        public TreeIterator(){
            queue = new LinkedList<>();
            addInOrder(getRoot());
        }

        /**
         * Metoda rekurencyjna służąca do dodawania do kolejki wartości w odpowiedniej kolejności
         * @param current Obecny korzeń poddrzewa
         */
        private void addInOrder(BinaryTree<T>.Node current){
            if(current != null){
                addInOrder(current.getLeft()); // wywoływanie rekurencyjne do momentu, aż lewa część poddrzewa nie zostanie dodana do kolejki
                queue.add(current); // dodanie korzenia poddrzewa
                addInOrder(current.getRight()); // wywoływanie rekurencyjne do momentu, aż prawa część poddrzewa nie zostanie dodana do kolejki
            }
        }

        @Override
        public boolean hasNext(){
            return !queue.isEmpty();
        }

        @Override
        public BinaryTree<T>.Node next(){
            return queue.remove();
        }
    }
}
