package hbcu.stay.ready.algor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {

    public Boolean harmlessRansomNote(String message , String magazineText){

        String[] newMagazineArray = magazineText.split(" ");
        String[] newMessageArray = message.split(" ");

        Map<String, Integer> seenInMagazine = new HashMap<>();
        Map<String, Integer> seenInMessage = new HashMap<>();


        for(String s : newMagazineArray){
            if(!seenInMagazine.containsKey(s)){
                seenInMagazine.put(s, 0);
            }
            seenInMagazine.put(s, seenInMagazine.get(s) + 1);
        }

        for(String s : newMessageArray){
            if(!seenInMessage.containsKey(s)){
                seenInMessage.put(s, 0);
            }
            seenInMessage.put(s, seenInMessage.get(s) + 1);
        }

        for(String word : seenInMessage.keySet()){
            if (!seenInMagazine.containsKey(word)) {
                return false;
            }
            int expected = seenInMessage.get(word);
            if (seenInMessage.get(word) < expected)
                return false;
        }
        return true;
    }
}
