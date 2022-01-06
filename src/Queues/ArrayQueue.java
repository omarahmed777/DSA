package Queues;

/**
 * An array implementation of a queue
 * @param <E> whatever data type is entered into the queue
 */
public class ArrayQueue<E> implements Queue<E> {
    private final E[] array;
    private final int CAPACITY;
    private int front;
    private int size;

    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Queue must have a capacity.");
        }
        this.CAPACITY = capacity;
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot push null into queue.");
        } else if (size == CAPACITY) {
            throw new ArrayIndexOutOfBoundsException("Queue is full");
        }
        array[(front + size) % CAPACITY] = element;
        size++;
    }

    @Override
    public E dequeue() {
        if(array[front] == null) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }

        E element = array[front];
        front = (front + 1) % CAPACITY;
        size--;
        return element;
    }

    @Override
    public E peek() {
        return array[front];
    }

    @Override
    public int size() {
        return size;
    }
}
