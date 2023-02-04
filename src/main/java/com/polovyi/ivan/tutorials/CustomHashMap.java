package com.polovyi.ivan.tutorials;

public interface CustomHashMap<K, V> {

    int size();

    boolean isEmpty();

    boolean containsKey(K key);

    boolean containsValue(V value);

    V get(K key);

    void put(K key, V value);

    V remove(K key);

}
