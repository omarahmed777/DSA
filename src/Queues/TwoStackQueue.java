package Queues;
import java.util.EmptyStackException;
import java.util.Stack;
public class TwoStackQueue<E> implements Queue<E> {
    Stack<E> stack1 = new Stack<>();
    Stack<E> stack2 = new Stack<>();

    /**
     * O(n) implementation of enqueue
     * @param element element to be inserted
     */
    @Override
    public void enqueue(E element) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop()); //Stack 2 will hold reverse order of queue (stack1)
        }
        stack1.push(element); //Push new element to now empty stack1

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop()); //Maintain order of queue w/ element at the bottom of stack1
        }
    }


    /**
     * O(1) implementation of dequeue
     * @return returns dequeued element
     */
    @Override
    public E dequeue() {
        if (stack1.isEmpty()) {
            throw new EmptyStackException();
        }

        return stack1.pop();
    }

    @Override
    public E peek() {
        return stack1.peek();
    }

    @Override
    public int size() {
        return stack1.size();
    }
}
