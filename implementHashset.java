import java.util.ArrayList;
import java.util.HashMap;

/*
 Question 
 Design a data structure that stores a mapping of a key to a given value and supports 
 the following operations in constant time.
1. INSERT(key, value): Inserts an integer value to the data structure against a string type key if not 
already present. If already present, it updates the value of the key with the new one. This function will not return anything.
2. DELETE(key): Removes the key from the data structure if present. It doesn't return anything.
3. SEARCH(key): It searches for the key in the data structure. In case it is present, return true. Otherwise, return false.
4. GET(key): It returns the integer value stored against the given key. If the key is not present, return -1. 
5. GET_SIZE(): It returns an integer value denoting the size of the data structure. 
6. IS_EMPTY(): It returns a boolean value, denoting whether the data structure is empty or not. 
Note :
1. Key is always a string value.
2. Value can never be -1.
 */
public class implementHashset {

    HashMap<String, Integer> hm = new HashMap<>();
    public implementHashset() {
        // Implement the Constructor(s).
        hm = new HashMap<>();

    }

    public void insert(String key, int value) {
       hm.put(key, value);
    }

    public int get(String key) {
        return hm.getOrDefault(key, -1);
    }

    public void remove(String key) {
        // Implement the remove(k) function.
        hm.remove(key);
    }

    public boolean search(String key) {
        // Implement the search(k) function.
        return hm.containsKey(key);
    }

    public int getSize() {
        // Implement the getSize() function.
        return hm.size();
    }

    public boolean isEmpty() {
        // Implement the isEmpty() function.
        return hm.isEmpty();
    }

}