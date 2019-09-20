package com.pers.alan.struct.map;

public interface Map<K,V> {

    //添加key-value
    void add(K key,V value);
    //通过key移除该key-value
    V remove(K key);
    //是否包含key
    boolean contains(K key);
    //通过key获得value
    V get(K key);
    //修改键为key的value
    void set(K key,V valueN);
    //获得映射的当前大小
    int getSize();
    //当前映射是否为空
    boolean isEmpty();

}
