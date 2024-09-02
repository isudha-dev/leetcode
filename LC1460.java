package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LC1460 {

    public static void main(String[] args) {
        canBeEqual(new int[] {1,2,3,4}, new int[] {2,4,1,3});
    }

    public static boolean canBeEqual(int[] target, int[] arr) {

        HashMap<Integer, Integer> mapArr = new HashMap();
        Arrays.stream(arr).forEach(i -> mapArr.put(i, mapArr.getOrDefault(i, 0)+1));

        HashMap<Integer, Integer> mapTar = new HashMap();
        Arrays.stream(target).forEach(i -> mapTar.put(i, mapTar.getOrDefault(i, 0)+1));

        if(mapArr.size() != mapTar.size()){
            return false;
        }

        if(!mapArr.keySet().equals(mapTar.keySet())){
            return false;
        }

        for(Map.Entry<Integer, Integer> entry : mapArr.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();

            if(mapTar.get(key) != val){
                return false;
            }
        }

        return true;

    }
}
