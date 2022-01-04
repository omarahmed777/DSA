package LinkedLists;

public interface LinkedLists<T> {
    class Node<T> {
        private final T data;
        private Node<T> prev;
        private Node<T> next;

        /**
         * Constructor given only data
         *
         * @param data data of the node
         */
        public Node(T data) {
            this.data = data;
        }

        /**
         * Constructor given all 3 param
         *
         * @param data data of the node
         * @param prev pointer to previous node
         * @param next pointer to next node
         */
        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        /*
        Getters & Setters for prev
         */
        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        /*
        Getters & Setters for next
         */
        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    /**
     * Removes first node in the list
     */
    void removeFirst();

    /**
     * Removes the last node in the list
     */
    void removeLast();

    /**
     * Removes node at specific index
     *
     * @param index index of the element to be removed
     */
    void remove(int index);

    /**
     * Returns the first element in the list
     *
     * @return the first element in the list
     */
    T getFirst();

    /**
     * Returns the last element in the list
     *
     * @return the last element in the list
     */
    T getLast();

    /**
     * Returns the element at a specific index
     *
     * @param index index of the element ot be returned
     * @return the element at the specified index
     */
    T get(int index);

    /**
     * Returns the size of the list
     *
     * @return the size of the list
     */
    int size();

    /**
     * Inserts an element in the first index of the list
     *
     * @param element the element to be inserted
     */
    void insertFirst(T element);

    /**
     * Inserts an element at the end of the list
     *
     * @param element element to be inserted
     */
    void insertLast(T element);

    /**
     * Inserts an element at a specified index
     *
     * @param element element to be inserted
     * @param index   index to insert the element at
     */
    void insert(T element, int index);


}
