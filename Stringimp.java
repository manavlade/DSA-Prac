public class Stringimp {
    /*
     * Question
     * You are given a string STR representing the column title in an Excel Sheet.
     * You need to find its corresponding column number.
     * For example: A corresponds to 1, B to 2, C to 3, … , Z to 26, AA to 27, ..
     * and so on.
     */
    public static long titleToNumber(String str) {
        long result = 0;

        for (char c : str.toCharArray()) {
            int value = c - 'A' +1;

            result = result * 26 + value;
     
        }
        return result;
    }
}
