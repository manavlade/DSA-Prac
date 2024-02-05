import java.util.ArrayList;
import java.util.List;

/*
 Question 
You are given an integer array 'ARR' of size 'N' and an integer 'S'. Your task is to 
return the list of all pairs of elements such that each sum of elements of each pair 
equals 'S'. 
Note:
Each pair should be sorted i.e the first value should be less than or equals to the 
second value.Return the list of pairs sorted in non-decreasing order of their first 
value. In case if two pairs have the same first value, the pair with a smaller second
value should come first.
 */
public class PairSum {
     public static List<int[]> pairSum(int[] arr, int s) {
        List<int[]> lis = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] == s){
                    int [] pair = {Math.min(arr[i], arr[j]), Math.max(arr[i], arr[j])};
                    lis.add(pair);
                }
            }
        }
        lis.sort((a,b) -> Integer.compare(a[0], b[0]));
        return lis;
    }
}
