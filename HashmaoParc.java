import java.util.*;
import java.util.HashMap;
// baaki hai practice

public class HashmaoParc {
    static class HashMap<k, v> {
        private class Node {
            k key;
            v value;

            public Node(k key, v value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;

        private LinkedList<Node> buckets[];

    // @SuppressWarnings("unchecked")
    // @SuppressWarnings

     public HashMap(){
      this.N = 4;
      this.buckets = new LinkedList[4];

      for (int i = 0; i <= 4; i++) { 
        this.buckets[i]= new LinkedList<>();
      }
     }

        private int hashFunction(k key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        private int searchInLL(k key, int bi) {
            LinkedList<Node> li = buckets[bi];

            for (int i = 0; i < li.size(); i++) {
                if (li.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        // private int rehash() {
        //     LinkedList<Node> oldbuckets[] = buckets;
        //     buckets = new LinkedList[N * 2];

        //     for (int i = 0; i < N * 2; i++) {
        //         buckets[i] = new LinkedList<>();
        //     }

        //     for (int i = 0; i < oldbuckets.length; i++) {
        //         LinkedList<Node> li = oldbuckets[i];
        //         for (int j = 0; j < li.size(); j++) {
        //             Node node = li.get(j);
        //             put(node.key, node.value);
        //         }
        //     }
        // }

        public void put(k key, v value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                buckets[bi].add(new Node(key, value));
            } else {
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            double lambda = (double) n / N;
            // if (lambda > 2.0) {
            //     rehash();
            // }
        }

    }

    // Find maximum frequency from array
   
}
