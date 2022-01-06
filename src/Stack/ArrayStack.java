package Stack;

import java.util.EmptyStackException;

/**
 * Array Implementation
 * @param <E> whatever type the stack holds
 */
public class ArrayStack<E> implements Stack<E> {
    private final E[] array;
    private final int CAPACITY;
    private int front;
    private int size;
    private boolean isLeaky;

    /**
     * Constructor given a capacity
     * @param capacity total capacity of the array
     */
    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("The stack must have a capacity");
        }
        this.CAPACITY = capacity;
        this.array = (E[]) new Object[capacity];
    }

    /**
     * Constructor given capacity + leaky
     * @param capacity total capacity of the array
     * @param isLeaky determines whether elements "leak off" the bottom of the stack or not when capacity is reached
     */
    public ArrayStack(int capacity, boolean isLeaky) {
        this(capacity); //Calls capacity constructor
        this.isLeaky = isLeaky;
    }

    @Override
    public void push(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot push null into stack");
        } else if (!isLeaky && size == CAPACITY) {
            throw new ArrayIndexOutOfBoundsException("Stack has reached capacity");
        }

        array[front] = element;
        front = (front + 1) % CAPACITY;

        if (size < CAPACITY) {
            size++;
        }
    }

    @Override
    public E pop() {
        front = (front + CAPACITY - 1) % CAPACITY;
        if (array[front] == null) {
            throw new EmptyStackException();
        }
        E popped = array[front];
        array[front] = null;
        size--;

        return popped;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E peek() {
        return array[front];
    }
}
