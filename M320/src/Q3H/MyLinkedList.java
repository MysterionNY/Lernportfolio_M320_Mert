package Q3H;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;

public class MyLinkedList<T> implements Iterable<T> {

    private static final class Node<T> {
        T value;
        Node<T> next;

        Node(T value) { this.value = value; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> n = new Node<>(value);
        if (head == null) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        Node<T> cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        return cur.value;
    }

    public boolean contains(T value) {
        for (T v : this) {
            if (Objects.equals(v, value)) return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public boolean remove(T value) {
        Node<T> prev = null;
        Node<T> cur = head;

        while (cur != null) {
            if (Objects.equals(cur.value, value)) {
                unlink(prev, cur);
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    public T removeAt(int index) {
        checkIndex(index);
        Node<T> prev = null;
        Node<T> cur = head;
        for (int i = 0; i < index; i++) {
            prev = cur;
            cur = cur.next;
        }
        T old = cur.value;
        unlink(prev, cur);
        return old;
    }

    public boolean removeByPredicate(Predicate<T> predicate) {
        Objects.requireNonNull(predicate, "predicate");

        Node<T> prev = null;
        Node<T> cur = head;

        while (cur != null) {
            if (predicate.test(cur.value)) {
                unlink(prev, cur);
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    private void unlink(Node<T> prev, Node<T> cur) {
        if (prev == null) { // removing head
            head = cur.next;
        } else {
            prev.next = cur.next;
        }
        if (cur == tail) {
            tail = prev;
        }
        size--;
        if (size == 0) {
            head = tail = null;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> cur = head;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public T next() {
                if (cur == null) throw new NoSuchElementException();
                T v = cur.value;
                cur = cur.next;
                return v;
            }
        };
    }
}
