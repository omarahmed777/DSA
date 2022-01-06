package Stack;
import LinkedLists.LinkedLists;
import LinkedLists.DoublyLinkedLists;
import java.util.EmptyStackException;

public class LLStack<E> implements Stack<E>{
    private final LinkedLists<E> list = new DoublyLinkedLists<E>();

    @Override
    public void push(E element) {
        list.insertFirst(element);
    }

    @Override
    public E pop() {
        if (list.size() == 0) {
            throw new EmptyStackException();
        }
        E popped = list.getFirst();
        list.removeFirst();

        return popped;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }
}

