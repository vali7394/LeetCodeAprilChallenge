package com.coding.leetcode.challenge.april.week4;/*
  @created 4/25/20
  @Author - Meeravali Shaik
 */

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCache extends LinkedHashMap<Integer,Integer> {

    int capacity ;

    public LRUCache(int initialCapacity) {
        super(initialCapacity,0.75F,true);
        this.capacity = initialCapacity;
    }

    public int get(int i){
        return super.getOrDefault(i,-1);
    }

    public int put(int key, int value){
        return super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Entry<Integer,Integer> eldest) {
        return size() > capacity;
    }
}
