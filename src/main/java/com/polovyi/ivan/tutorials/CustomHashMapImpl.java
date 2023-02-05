package com.polovyi.ivan.tutorials;

import java.util.Objects;

public class CustomHashMapImpl<K, V> implements CustomHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 4;
    private static final int INCREASE_FACTOR = 2;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int size;
    private EntryNode<K, V>[] buckets;

    public CustomHashMapImpl() {
        buckets = new EntryNode[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void put(K key, V value) {
        double currentFactor = ((double) size / buckets.length);
        if (currentFactor >= DEFAULT_LOAD_FACTOR) {
            reHash();
        }
        EntryNode<K, V> existingNode = getNode(key);
        if (existingNode != null) {
            existingNode.value = value;
            return;
        }
        int index = getIndex(key);

        EntryNode<K, V> entryNode = new EntryNode<>(key, value);
        if (buckets[index] == null) {
            buckets[index] = entryNode;
        } else {
            EntryNode<K, V> presentEntryNode = buckets[index];
            while (presentEntryNode.next != null) {
                presentEntryNode = presentEntryNode.next;
            }
            presentEntryNode.next = entryNode;
        }
        this.size++;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        EntryNode<K, V> node = buckets[index];
        if (node != null) {
            while (node.next != null && !Objects.equals(node.key, key)) {
                node = node.next;
            }
            return node.value;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = getIndex(key);
        EntryNode<K, V> node = buckets[index];
        if (node != null) {
            if (node.next == null && Objects.equals(node.key, key)) {
                V value = buckets[index].value;
                size--;
                buckets[index] = null;
                return value;
            } else if (node.next != null && Objects.equals(node.key, key)) {
                V value = buckets[index].value;
                size--;
                buckets[index] = node.next;
                return value;
            } else {
                while (node.next != null) {
                    if (node.next.key.equals(key)) {
                        node.next = node.next.next;
                        this.size--;
                        return node.value;
                    }
                    node = node.next;
                }
            }
        }
        return null;
    }


    @Override
    public boolean containsKey(K key) {
        return getNode(key) != null;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < buckets.length; i++) {
            EntryNode<K, V> node = buckets[i];
            if (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                while (node.next != null) {
                    node = node.next;
                    if (node.value.equals(value)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void reHash() {
        int newLength = buckets.length * INCREASE_FACTOR;
        EntryNode<K, V>[] oldBucketsTmp = buckets;
        buckets = new EntryNode[newLength];

        for (int i = 0; i < oldBucketsTmp.length; i++) {
            EntryNode<K, V> node = oldBucketsTmp[i];
            if (node != null) {
                int index = getIndex(node.key);
                buckets[index] = node;
                while (node.next != null) {
                    node = node.next;
                    index = getIndex(node.key);
                    buckets[index] = node;
                }
            }
        }
    }

    private static class EntryNode<K, V> {

        private K key;
        private V value;
        private EntryNode<K, V> next;

        EntryNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int getIndex(K key) {
        int keyHashCode = key != null ? key.hashCode() : 0;
        int index = Math.abs((keyHashCode % this.buckets.length) - 1);
        return index;
    }

    private EntryNode<K, V> getNode(K key) {
        for (int i = 0; i < buckets.length; i++) {
            EntryNode<K, V> node = buckets[i];
            if (node != null) {
                if (Objects.equals(node.key, key)) {
                    return node;
                }
                while (node.next != null) {
                    node = node.next;
                    if (Objects.equals(node.key, key)) {
                        return node;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String value = "[ ";

        for (int i = 0; i < buckets.length; i++) {
            EntryNode<K, V> node = buckets[i];
            value = value + " " + i + "-";
            if (node != null) {
                value = value + "[" + node.key + "," + node.value + "]";
                EntryNode<K, V> currentNode = node.next;
                while (currentNode != null) {
                    value = value + "->[" + currentNode.key + "," + currentNode.value + "]";
                    currentNode = currentNode.next;
                }
                value = value + "]";
            } else {
                value = value + "[]";
            }

            if (i < buckets.length - 1) {
                value = value + ", ";
            }
        }
        value = value + " ]";
        return value;
    }
}
