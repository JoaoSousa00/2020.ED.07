package Uses;

import java.util.Iterator;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * PP - Paradigmas de Programação<br>
 * </h3>
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 * Class that represents
 * </p>
 */
public class DoubleLinkedList<T> implements Iterable<T> {

    protected DoubleNode head;
    protected DoubleNode rear;
    protected int count;
    protected int modcount;

    private class BasicIterator implements Iterator {

        private DoubleNode current;
        private final int expectedmodcount;

        public BasicIterator() {
            this.current = head;
            this.expectedmodcount = modcount;
        }

        @Override
        public boolean hasNext() {
            if (expectedmodcount != modcount) {
                throw new Error();
            }
            return (current != null);
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new Error();
            }
            T tmp = (T) current.getElement();
            current = current.getNext();
            return tmp;
        }

        @Override
        public void remove() {
            if (!hasNext()) {
                throw new Error();
            }
            DoubleLinkedList.this.remove(next());
        }

    }

    /**
     * Creates a empty DoubleLinkedList
     */
    public DoubleLinkedList() {
        this.head = null;
        this.rear = null;
        this.count = 0;
        this.modcount = 0;
    }

    public void add(T element) {
        int i = 0;
        DoubleNode<T> newNode = new DoubleNode<>(element);
        DoubleNode<T> temp = head;
        Comparable tempElement = (Comparable) element;
        while (i < size() && tempElement.compareTo(temp.getElement()) > 0) {
            i++;
            temp = temp.getNext();
        }
        if (size() == 0) {
            head = rear = newNode;
        } else if (i == 0) {
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
        } else if (i == size()) {
            rear.setNext(newNode);
            newNode.setPrevious(rear);
            rear = newNode;
        } else {
            newNode.setNext(temp);
            newNode.setPrevious(temp.getPrevious());
            temp.setPrevious(newNode);
            newNode.getPrevious().setNext(newNode);
        }
        count++;
        modcount++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new Error("A lists está vazia, não pode remover...");
        }
        T toremove = (T) head.getElement();
        if (size() == 1) {
            head = rear = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }
        count--;
        modcount++;
        return toremove;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new Error("A lists está vazia, não pode remover...");
        }
        T toremove = (T) rear.getElement();
        if (size() == 1) {
            head = rear = null;
        } else {
            rear = rear.getPrevious();
            rear.setNext(null);
        }
        count--;
        modcount++;
        return toremove;
    }

    public T remove(T element) {
        if (isEmpty()) {
            throw new Error();
        }
        if (!contains(element)) {
            throw new Error();
        }
        DoubleNode<T> temp = find(element);
        if (size() == 1) {
            head = null;
            rear = null;
        } else if (temp.getPrevious() == null) {
            head = head.getNext();
            head.setPrevious(null);
        } else if (temp.getNext() == null) {
            rear = rear.getPrevious();
            rear.setNext(null);
        } else {
            temp.getPrevious().setNext(temp.getNext());
            temp.getNext().setPrevious(temp.getPrevious());
        }

        count--;
        modcount++;
        return temp.getElement();
    }

    public T first() {
        if (isEmpty()) {
            throw new Error("A lista está vazia...");
        }
        return (T) head.getElement();
    }

    public DoubleNode firstNode() {
        if (isEmpty()) {
            throw new Error("A lista está vazia...");
        }
        return head;
    }

    public T last() {
        if (isEmpty()) {
            throw new Error("A lista está vazia...");
        }
        return (T) rear.getElement();
    }

    public DoubleNode LastNode() {
        if (isEmpty()) {
            throw new Error("A lista está vazia...");
        }
        return rear;
    }

    public boolean contains(T target) {
        boolean found = false;
        Iterator it = iterator();
        while (it.hasNext() && !found) {
            Comparable tmp = (Comparable) it.next();
            if (tmp.compareTo(target) == 0) {
                found = true;
            }
        }
        return found;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicIterator();
    }

    private DoubleNode<T> find(T element) {
        boolean found = false;
        DoubleNode<T> temp = head;
        while (temp != null && !found) {
            Comparable tempElement = (Comparable) temp.getElement();
            if (tempElement.compareTo(element) == 0) {
                found = true;
            } else {
                temp = temp.getNext();
            }
        }
        if (!found) {
            temp = null;
        }
        return temp;
    }

    @Override
    public String toString() {
        String result = "\n\t-----To String-----";
        Iterator it = iterator();
        while (it.hasNext()) {
            result += "\n" + it.next();
        }
        return result;
    }

}
