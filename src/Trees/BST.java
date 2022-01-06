package Trees;

import com.sun.jdi.request.DuplicateRequestException;

/**
 * A Binary Search Tree
 * @param <E> Whatever data type the tree holds
 */
public class BST<E extends Comparable<? super E>> implements  BinaryTree<E> {
    private BinaryNode<E> root;
    private int size;
    private int height;

    public BST(E root) {
        this.root = new BinaryNode<>(root);
        this.size = 1;
        this.height = 0; //Our definition of height means empty tree is height -1, root is 0
    }

    public BinaryNode<E> getRoot() {
        return root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        return height;
    }

    @Override
    public void insert(E element) {
        root = insert(element, root, 1);
    }

    private BinaryNode<E> insert(E element, BinaryNode<E> node, int depth) {
        if (node == null) {
            node = new BinaryNode<>(element);
        } else if (element.compareTo(node.getData()) > 0) {
            node.setRight(insert(element, node.getRight(), depth+1));
        } else if (element.compareTo(node.getData()) < 0) {
            node.setLeft(insert(element, node.getLeft(), depth+1));
        } else {
            throw new IllegalArgumentException("Element already in tree");
        }
        return node;
    }

    @Override
    public boolean contains(E element) {
        return search(element, root) != null;
    }

    private BinaryNode<E> search(E element, BinaryNode<E> node) {
        if (node == null) {
            return null;
        } else if (element.equals(node.getData())) { //If node is found
            return node;
        } else if (element.compareTo(node.getData()) > 0 ) { //If element > node...
            return search(element, node.getRight()); //Search right branch
        } else if (element.compareTo(node.getData()) < 0 ) { //If element < node
            return search(element, node.getLeft()); //Search left branch
        } else { //Element not found
            return null;
        }
    }

    /*
    Needs implementation bc wtf brain go boom
     */
    @Override
    public void remove(E element) {
        if (!contains(element)) {
            throw new IllegalArgumentException("Element does not exist in the tree");
        }

        root = remove(element, root);
        size--;
    }

    private BinaryNode<E> remove(E element, BinaryNode<E> node) {
        if (node == null) {

        }
    }
}
