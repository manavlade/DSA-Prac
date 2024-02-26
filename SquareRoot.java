public class SquareRoot {
    public static int sqrtN(long N) {

        if(N == 0 || N == 1){
            return (int) N;
        }

        long left = 1, right = N, result = 0;

        while (left < right) {
            long mid = left + (right + left) /2;

            if(mid * mid == N){
                return (int) mid;
            } 
            else if(mid * mid < N){
                result =  mid;
                left = mid+1;
            }
            else if(mid * mid > N){
                right = mid -1;
            }
        }
        return (int)  result;
    }

    // static long inversionCount(long arr[], long N) {
    //     long inversions = 0;
    //     for (int i = 0; i < arr.length; i++) {
    //         if(arr[i] < )
    //     }
    // }
    
}
