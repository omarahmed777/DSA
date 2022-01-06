package Stack;

public interface Stack<E> {

    /**
     * Inserts an element to the top of the stack
     * @param element element to be inserted
     */
    void push(E element);

    /**
     * Pops the element of the top of the stack
     * @return Returns the popped element
     */
    E pop();

    /**
     * Returns the element at the top of the stack, NOT removes
     * @return the element at the top of the stack
     */
    E peek();

    /**
     * Returns the size of the stack
     * @return the size of the stack
     */
    int size();
}
