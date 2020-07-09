package com.coding.leetcode.amazon.online.assement;/*
  @created 7/8/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoriteGenres {

    public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap,
        Map<String, List<String>> genreMap) {

        Map<String,String> songMap = new HashMap<>();

        for(String key : genreMap.keySet()){
            for(String song : genreMap.get(key)){
                songMap.put(song,key);
            }
        }

        Map<String,List<String>> result = new HashMap<>();

        for(String user : userMap.keySet()) {
            Map<String,Integer> count = new HashMap<>();
            int max = 0;

            for(String song : userMap.get(user)){
                if(songMap.containsKey(song)) {
                    int curCount = count.getOrDefault(songMap.get(song), 0) + 1;
                    max = Math.max(curCount, max);
                    count.put(songMap.get(song), curCount);
                }
            }

            List<String> favGen = new ArrayList<>();

            for(String favGe : count.keySet()){
                if(count.get(favGe)==max){
                    favGen.add(favGe);
                }
            }
            result.put(user,favGen);
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {

        Map<String,List<String>> users = new HashMap<>();
        users.put("David",List.of("song1", "song2", "song3", "song4", "song8"));
        users.put("emma",List.of("song5", "song6", "song7"));

        Map<String,List<String>> geners = new HashMap<>();
       /* geners.put("Rock",List.of("song1", "song3"));
        geners.put("Dubstep",List.of("song7"));
        geners.put("Techno",List.of("song2", "song4"));
        geners.put("Pop",List.of("song5", "song6"));
        geners.put("Jazz",List.of("song8", "song9"));*/

        FavoriteGenres fav = new FavoriteGenres();
        fav.favoritegenre(users,geners);


    }

}


/**
 Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user has listened to as values.

 Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within that genre as values. The song can only belong to only one genre.

 The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list of the user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.

 Example 1:

 Input:
 userSongs = {
 "David": ["song1", "song2", "song3", "song4", "song8"],
 "Emma":  ["song5", "song6", "song7"]
 },
 songGenres = {
 "Rock":    ["song1", "song3"],
 "Dubstep": ["song7"],
 "Techno":  ["song2", "song4"],
 "Pop":     ["song5", "song6"],
 "Jazz":    ["song8", "song9"]
 }

 Output: {
 "David": ["Rock", "Techno"],
 "Emma":  ["Pop"]
 }

 Explanation:
 David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
 Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
 Example 2:

 Input:
 userSongs = {
 "David": ["song1", "song2"],
 "Emma":  ["song3", "song4"]
 },
 songGenres = {}

 Output: {
 "David": [],
 "Emma":  []
 }
 **/