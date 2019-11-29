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
public class LinkedList<T> implements Iterable<T>{

    private int count, modcount;
    private LinearNode head, tail;

    /**
     * Creates a empty list.
     */
    public LinkedList() {
        LinearNode tmp = new LinearNode(null);
        count = 0;
        head = tail = tmp;
        modcount = 0;
    }

    private class BasicIterator implements Iterator {

        private LinearNode current;
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
            LinkedList.this.remove(next());
        }

    }

    public void add(T info) {
        LinearNode node = new LinearNode(info);
        boolean added = false;
        if (count == 0) {
            head = tail = node;
            added = true;
        } else {
            node.setNext(head);
            head = node;
            added = true;
        }
        if (added) {
            count++;
            modcount++;
            System.out.println("Node sucefully added!");
        }
    }

    public void remove(T info) {
        boolean removed = false;
        int i = 0;
        if (count == 0) {
            System.out.println("No Nodes in the list!");
        } else if (info == head.getNext().getElement()) {
            head.setNext(head.getNext().getNext());
            removed = true;
        } else {
            LinearNode tmp = head.getNext();
            while (!removed && i < count) {
                if (tmp.getElement() == info) {
                    tmp.setNext(tmp.getNext().getNext());
                    removed = true;
                }
                tmp = tmp.getNext();
                i++;
            }
        }
        if (removed) {
            System.out.println("Node removed!");
            count--;
            modcount++;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedList.BasicIterator();
    }

    public void listToString() {
        LinearNode tmp = head;
        for (int i = 0; i < count; i++) {
            System.out.println(tmp.getNext().toString());
            tmp = tmp.getNext();
        }
    }

    /**
     * @return the head
     */
    public LinearNode getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(LinearNode head) {
        this.head = head;
    }

    /**
     * @return the tail
     */
    public LinearNode getTail() {
        return tail;
    }

    /**
     * @param tail the tail to set
     */
    public void setTail(LinearNode tail) {
        this.tail = tail;
    }

}
