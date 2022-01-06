package Trees;

public interface BinaryTree<E> {
    class BinaryNode<T> {
        private T data;
        private BinaryNode<T> left;
        private BinaryNode<T> right;
        private BinaryNode<T> parent;

        public BinaryNode(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }
        public void setData(T data) {
            this.data = data;
        }

        public BinaryNode<T> getLeft() {
            return left;
        }
        public void setLeft(BinaryNode<T> left) {
            this.left = left;
        }

        public BinaryNode<T> getRight() {
            return right;
        }
        public void setRight(BinaryNode<T> right) {
            this.right = right;
        }

        public BinaryNode<T> getParent() {
            return parent;
        }
        public void setParent(BinaryNode<T> parent) {
            this.parent = parent;
        }
    }

    /**
     * Returns the size of the tree
     * @return size of the tree
     */
    int size();

    /**
     * Returns height of the tree
     * @return height of the tree
     */
    int height();

    /**
     * Inserts an element into the tree
     * @param element element to be inserted
     */
    void insert(E element);

    /**
     * Returns T/F depending on if the element is in the tree
     * @param element element to be checked
     * @return True / False
     */
    boolean contains(E element);

    /**
     * Removes specific element from tree
     * @param element element to be removed
     */
    void remove(E element);

}
