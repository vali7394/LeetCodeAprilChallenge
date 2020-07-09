package com.coding.leetcode.dailycoding.practise;/*
  @created 6/12/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomDuplicates {

    Map<Integer, List<Integer>> values = new HashMap<>();
    List<Integer> list  = new ArrayList<>();
    Random random = new Random();
    public boolean insert(int val) {

        if(values.containsKey(val)){
            values.get(val).add(list.size());
            list.add(val);
        } else {
            var indices = new ArrayList<Integer>();
            indices.add(list.size());
            values.put(val,indices);
            list.add(val);
        }
        return true;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (values.containsKey(val)) {
            List<Integer> indices = values.get(val);
            int index = indices.get(indices.size() - 1);
            list.set(index, list.size() - 1);
            list.remove(list.size() - 1);
            values.get(val).remove(indices.size() - 1);
            if (values.get(val).size() == 0) {
                values.remove(val);
            }
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int i = random.nextInt(list.size());
        return list.get(i);
    }

    public static void main(String[] args) {
        var randomDuplicates = new InsertDeleteGetRandomDuplicates();
        randomDuplicates.insert(1);
        randomDuplicates.insert(1);
        randomDuplicates.insert(2);
        System.out.println(randomDuplicates.getRandom());
        randomDuplicates.remove(1);
        System.out.println(randomDuplicates.getRandom());
    }
}


/**

 Design a data structure that supports all following operations in average O(1) time.

 Note: Duplicate elements are allowed.
 insert(val): Inserts an item val to the collection.
 remove(val): Removes an item val from the collection if present.
 getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 Example:

 // Init an empty collection.
 RandomizedCollection collection = new RandomizedCollection();

 // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 collection.insert(1);

 // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 collection.insert(1);

 // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 collection.insert(2);

 // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 collection.getRandom();

 // Removes 1 from the collection, returns true. Collection now contains [1,2].
 collection.remove(1);

 // getRandom should return 1 and 2 both equally likely.
 collection.getRandom();

 */