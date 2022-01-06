package Queues;

public interface Queue<E> {
    /**
     * Inserts an element at the end of the queue
     * @param element element to be inserted
     */
    void enqueue(E element);

    /**
     * Removes element from the front of queue and returns it
     * @return The first element/The element removed from the queue
     */
    E dequeue();

    /**
     * Returns the element at the top of the queue
     * @return element at the top of the queue
     */
    E peek();

    /**
     * Returns the size of the queue
     * @return size of the queue
     */
    int size();
}
