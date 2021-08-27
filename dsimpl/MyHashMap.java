import java.util.ArrayList;
import java.util.Objects;

public class MyHashMap<K, V> {

    static class HashNode<K, V> {
        K key;
        V value;
        final int hash;

        HashNode<K, V> next;

        public HashNode(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }

    private ArrayList<HashNode<K, V>> bucketArray;

    private int capacity;
    private double loadFactor;

    private int size;

    public MyHashMap() {
        bucketArray = new ArrayList<>();
        capacity = 16;
        size = 0;
        loadFactor = 0.75;

        for (int i = 0; i < capacity; i++)
            bucketArray.add(null);
    }

    public MyHashMap(int capacity, double loadFactor) {
        this.bucketArray = new ArrayList<>();
        this.capacity = capacity;
        this.size = 0;
        this.loadFactor = loadFactor;

        for (int i = 0; i < capacity; i++)
            bucketArray.add(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private final int hashCode(K key) {
        return Objects.hashCode(key);
    }

    private int getBucketIndex(K key) {
        int hashCode = hashCode(key);
        int index = hashCode % capacity;

        index = index < 0 ? index * -1 : index;
        return index;
    }

    public V get(K key) {
        final int index = getBucketIndex(key);
        final int hashCode = hashCode(key);
        HashNode<K, V> currNode = bucketArray.get(index);
        while (currNode != null) {
            if (currNode.key.equals(key) && hashCode == hashCode(currNode.key)) {
                return currNode.value;
            }
            currNode = currNode.next;
        }
        return null;
    }

    public void put(K key, V value) {
        final int index = getBucketIndex(key);
        final int newHashCode = hashCode(key);
        if (bucketArray.get(index) == null) {
            final HashNode<K, V> newNode = new HashNode<>(key, value, newHashCode);
            bucketArray.set(index, newNode);
            size++;
        } else {
            HashNode<K, V> currNode = bucketArray.get(index);
            while (currNode != null) {
                if (currNode.key.equals(key) && newHashCode == hashCode(currNode.key)) {
                    currNode.value = value;
                    bucketArray.set(index, currNode);
                    return;
                }
                currNode = currNode.next;
            }
            currNode = bucketArray.get(index);
            currNode.next = new HashNode<>(key, value, newHashCode);
            size++;
            bucketArray.set(index, currNode);
        }

        if ((0.1 * size) >= (capacity * 0.75)) {
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            capacity = 2 * capacity;
            size = 0;
            for (int i = 0; i < capacity; i++)
                bucketArray.add(null);

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    put(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public V remove(K key) {
        final int index = getBucketIndex(key);
        final int newHashCode = hashCode(key);
        HashNode<K, V> currNode = bucketArray.get(index);
        HashNode<K, V> prev = null;
        while (currNode != null) {
            if (currNode.key.equals(key) && currNode.hash == newHashCode) {
                break;
            }
            prev = currNode;
            currNode = currNode.next;
        }

        if (currNode == null) {
            return null;
        }
        size--;
        if (prev != null) {
            prev.next = currNode.next;
        } else {
            bucketArray.set(index, currNode.next);
        }
        return currNode.value;
    }

    public String toString() {
        final StringBuilder output = new StringBuilder();
        output.append("[");
        for (HashNode<K, V> kvHashNode : bucketArray) {
            while (kvHashNode != null) {
                output.append(kvHashNode.key).append(" -> ").append(kvHashNode.value).append(",");
                kvHashNode = kvHashNode.next;
            }
        }
        output.deleteCharAt(output.length() - 1);
        output.append("]");
        return output.toString();
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);

        System.out.println(map);
        System.out.println(map.get("one"));
        System.out.println(map.isEmpty());
        System.out.println(map.remove("four"));
        System.out.println(map);
        System.out.println(map.size());

    }

}
