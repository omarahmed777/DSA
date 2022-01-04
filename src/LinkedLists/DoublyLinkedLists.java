package LinkedLists;

import java.io.*;

/**
 * A NON-circlular, doubly-linked list
 */
public final class DoublyLinkedLists<T> implements LinkedLists<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    /**
     * Throws an exception when list is empty i.e. size = 0
     */
    private void isEmpty() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("The list has no elements");
        }
    }

    /**
     * Throws an exception when trying to do anything with an index >= size
     */
    private void checkIndex(int index) {
        if (size <= index) {
            throw new IndexOutOfBoundsException(String.format("The index %d is outside of range.", index));
        }
    }

    @Override
    public void removeFirst() {
        this.isEmpty(); //Check if list is empty

        if (size == 1) { //Case with only 1 item in the list
            first = null;
        } else { //Set the second item in the list to be the new first
            Node<T> second = first.getNext();
            second.setPrev(null);
            first = second;
        }

        size--;
    }

    @Override
    public void removeLast() {
        this.isEmpty(); //Check if list is empty

        if (size == 1) { //Case with only 1 item in the list
            first = null;
        } else { //Set the penultimate item to be the new last item
            Node<T> newLast = last.getPrev();
            newLast.setNext(null);
            last = newLast;
        }

        size--;
    }

    @Override
    public void remove(int index) {
        this.isEmpty();
        this.checkIndex(index);

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<T> current = first;
            Node<T> previous = null;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.getNext();
            }
            if (previous != null && current != null) {
                previous.setNext(current.getNext());
                current.getNext().setPrev(previous);
            }
        }

        size--;
    }

    @Override
    public T getFirst() {
        this.isEmpty();
        return first.getData();
    }

    @Override
    public T getLast() {
        this.isEmpty();
        return last.getData();
    }

    @Override
    public T get(int index) {
        this.isEmpty();
        this.checkIndex(index);

        Node<T> node = first;
        for (int i = 0; i < index; i++) { //Cycles through list until desired index is found
            node = node.getNext();
        }
        return node.getData();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insertFirst(T element) {
        Node<T> node = new Node<>(element, null, first);
        if (first != null) { //If first is not empty
            first.setPrev(node); //Set new node to be old node's prev
        }
        first = node; //new node is now first
        if (last == null) { //If list is empty and last was null
            last = first; //last is also first
        }
        size++; //Increment size of list
    }

    @Override
    public void insertLast(T element) {
        Node<T> node = new Node<>(element, last, null);
        if (last != null) {
            last.setNext(node);
        }
        last = node;
        if (first == null) {
            first = last;
        }
        size++;
    }

    @Override
    public void insert(T element, int index) {
        this.checkIndex(index);
        if (index == 0) {
            insertFirst(element);
        } else if (index == size - 1) {
            insertLast(element);
        } else {
            Node<T> current = first;
            Node<T> previous = null;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.getNext();
            }
            Node<T> node = new Node<>(element, previous, current);
            if (previous != null) {
                previous.setNext(node);
            }
            if (current != null) {
                current.setPrev(node);
            }
        }
        size++;
    }
}
