import java.util.HashMap;
import java.util.Map;

/*
 Question
You have been given an array/list 'ARR' consisting of 'N' integers. Your task is to 
find the majority element in the array. If there is no majority element present, print -1.
Note:
A majority element is an element that occurs more than floor('N' / 2) times in the array.
 */
public class MajorityElement {
    
     public static int findMajority(int[] arr, int n) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int current =  arr[i];
            freq.put(current, freq.getOrDefault(current, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if(entry.getValue() > n / 2){
                return entry.getKey();
            }
        }
        return -1;
     }
}
