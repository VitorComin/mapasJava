import java.util.Objects;

//Mapa
class Mapa<K, V> {
    private No<K, V> head;

    public void put(K key, V value) {
        No<K, V> novoNo = new No<>(key, value);
        if (head == null) {
            head = novoNo;
        } else {
            No<K, V> current = head;
            while (current.getNext() != null) {
                if (Objects.equals(current.getKey(), key)) {
                    current.setValue(value);
                    return;
                }
                current = current.getNext();
            }
            current.setNext(novoNo);
            novoNo.setPrev(current);
        }
    }


    //GET
    public V get(K key) {
        No<K, V> current = head;
        while (current != null) {
            if (Objects.equals(current.getKey(), key)) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }


    //REMOVE
    public void remover(K key) {
        No<K, V> current = head;
        while (current != null) {
            if (Objects.equals(current.getKey(), key)) {
                if (current.getPrev() != null) {
                    current.getPrev().setNext(current.getNext());
                } else {
                    head = current.getNext();
                }
                if (current.getNext() != null) {
                    current.getNext().setPrev(current.getPrev());
                }
                return;
            }
            current = current.getNext();
        }
    }

    private static class No<K, V> {
        private final K key;
        private V value;
        private No<K, V> prev;
        private No<K, V> next;

        public No(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public No<K, V> getPrev() {
            return prev;
        }

        public void setPrev(No<K, V> prev) {
            this.prev = prev;
        }

        public No<K, V> getNext() {
            return next;
        }

        public void setNext(No<K, V> next) {
            this.next = next;
        }
    }
}
