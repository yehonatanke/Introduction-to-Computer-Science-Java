/**
 * Complexity and recursion problems
 */

import java.util.stream.*;

public class Ex13Rec {
    // Q1:

    /**
     * Finding the shortest travel segment between two given segments when it is possible to switch to another segment only once.
     *
     * @param a Array of positive integer numbers.
     * @return The maximum difference between 2 numbers in the array (the bigger number is located first).
     * <p>
     * Time Complexity: O(n) - iterating over the array only once.
     * Space Complexity: O(1) - constant number of variables.
     */
    public static int sumArrayToN (int[] arr, int n) {  // return the sum of n array values fron 0 to n
        if (n == 0) {
            return arr[n];
        }
        return arr[n] + sumArrayToN(arr, n - 1);
    }

    public static int sumArrayFromNToEnd (int[] arr, int n) {  // return the sum of n array values fron n to end of array
        if (arr.length - 1 < n)
            return 0;
        if (n == arr.length - 1) {
            return arr[n];
        }
        return arr[n] + sumArrayFromNToEnd(arr, n + 1);
    }

    public static int shortestRoad (int[] road1, int[] road2) {
        return Math.min(shortestRoad(road1, road2, 0), shortestRoad(road2, road1, 0));
    }

    private static int shortestRoad (int[] road1, int[] road2, int i) {
        if (i == road1.length - 1)
            return sumArrayToN(road1, i);

        return Math.min(sumArrayToN(road1, i) + sumArrayFromNToEnd(road2, i + 1),
                shortestRoad(road1, road2, i + 1));

    }

    public static void main (String[] args) {
        int[] road1 = {5, 4, 5, 8, 12, 9, 9, 3};
        int[] road2 = {7, 3, 3, 12, 10, 2, 10, 7};

        int[] road3 = {1, 1, 1};
        int[] road4 = {1, 0, 0};

        System.out.println(sumArrayToN(road1, road1.length - 1));
        System.out.println(sumArrayFromNToEnd(road2, 0));

        int sum = shortestRoad(road3, road4);
        System.out.println("The shortest road is " + sum);

    }
}
 // Q1:

    /**
     * Finds the maximal drop between 2 numbers in a given array, such that the larger number is located before the lower.
     *
     * @param a Array of positive integer numbers.
     * @return The maximum difference between 2 numbers in the array (the bigger number is located first).
     * <p>
     * Time Complexity: O(n) - iterating over the array only once.
     * Space Complexity: O(1) - constant number of variables.
     */
    public static int maximalDrop (int[] a) {
        final int DEFAULT_VAL = 0;

        if (a.length < 2)
            return DEFAULT_VAL;

        int maxDrop = Math.max(DEFAULT_VAL, a[0] - a[1]), maxNum = a[0];
        // iterating n-2 times and setting the max drop as the max difference between the maximum number (before the lower) to the next number.
        for (int i = 1; i < a.length - 1; ) {
            maxNum = Math.max(a[i], maxNum);
            maxDrop = Math.max(maxDrop, maxNum - a[++i]); // ++i here, instead of a[i + 1] and i++ at the loop increment statement.
        }

        return Math.max(DEFAULT_VAL, maxDrop);
    }// end of Q1.

    // Q2:

    /**
     * Finds the row/column number of the sink or -1 if no sink was found.
     *
     * @param mat 2-Dimensional array of 2 values (1 or 0)
     * @return The row/column number of the sink
     * <p>
     * Time Complexity: O(2n + n)  = O(n)  - no nested loops.
     * Space Complexity: O(1)  - constant number of variables.
     * There is only 1 sink at most and n options for the sink.
     * At first, traversing the matrix diagonally to invalidate the row / column. if we invalidated the last row, we can assume that there is no sink.
     * Otherwise - the last row that was reached, might be the sink, so we can check it with the corresponding column.
     */
    public static int isSink (int[][] mat) {
        final int NO_SINK = -1, ROW_VAL = 0, COL_VAL = 1;

        // The number of rows is equal to the number of columns, so if there's only 1 row, we can assume that there is no sink if the value is not 0.
        if (mat.length == 1) {
            if (mat[0][0] == ROW_VAL)
                return 0;
            return NO_SINK;
        }

        int row = 0;
        // Moving to the next row if the value is 1 and moving to the next column if 0. in the worst case - iterating 2n times.
        for (int val, col = 0; row < mat.length && col < mat.length; row += val, col -= val)
            // "val" is the value of the current cell (1 or 0)
            val = mat[row][col++]; // col++ here, in order to move to the next column if val is 0 (col -= val at the loop increment statement)

        // if traversed over all the rows, it means that the value 1 was found n times, so there is no sink in the given matrix */
        if (row == mat.length)
            return NO_SINK;

        // here, "row" is the suspected row/column number of the sink (because the last condition wasn't met)
        int sink = row;

        // traversing over the suspected column and row of the sink simultaneously to check if the sink is there. (in the worst case, iterating n times).
        for (int i = 0; i < mat.length; i++)
            if (mat[sink][i] == COL_VAL || (mat[i][sink] == ROW_VAL && i != sink))
                return NO_SINK;

        return sink;
    } // end of Q2.

    // Q3:

    /**
     * Calculates the size of the "stain" in the given cell. (returns 0 if no stain was found)
     *
     * @param mat 2-Dimensional array of boolean values (true / false)
     * @param x   The row number of the given cell.
     * @param y   The column number of the given cell.
     * @return The size of the "stain" of the given cell.
     */
    public static int size (boolean[][] mat, int x, int y) {
        final int DEFAULT_VAL = 0;

        // checking if the given place is valid and not empty (false value)
        if (isInvalid(mat, x, y) || !mat[x][y])
            return DEFAULT_VAL;

        // creating a new matrix for the visited places and calling to the overloaded recursive method.
        boolean[][] visited = new boolean[mat.length][mat[0].length]; // all values are "false" by default.
        return size(mat, visited, x, y);
    }

    private static int size (boolean[][] mat, boolean[][] visited, int row, int col) {
        // base case - checking if the current place is out of range or empty (false) or visited already.
        if (isInvalid(mat, row, col) || !mat[row][col] || visited[row][col])
            return 0;

        // here it's true and hasn't been visited yet, so we can mark this as visited now.
        visited[row][col] = true;

        // making recursive calls for all the adjacent cells.
        int up = size(mat, visited, row - 1, col), down = size(mat, visited, row + 1, col),
                left = size(mat, visited, row, col - 1), right = size(mat, visited, row, col + 1);

        // diagonals
        int upLeft = size(mat, visited, row - 1, col - 1), downLeft = size(mat, visited, row + 1, col - 1),
                upRight = size(mat, visited, row - 1, col + 1), downRight = size(mat, visited, row + 1, col + 1);

        return 1 + up + down + left + right + upLeft + downLeft + upRight + downRight;
    }

    private static boolean isInvalid (boolean[][] mat, int row, int col) {
        // checking if the current row and col are invalid (out of range).
        return row < 0 || col < 0 || row >= mat.length || col >= mat[0].length;
    }// end of Q3.

    // Q4:

    /**
     * Receives 2 arrays to check if they are permutations of each other.
     *
     * @param a The first array of integer numbers.
     * @param b The array to check if it's a permutation of the other.
     * @return true iff the first array is a permutation of the other.
     */
    public static boolean isPermutation (int[] a, int[] b) {
        final int STARTING_INDEX = 0;

        // returns false if the arrays are invalid or they don't have the same length.
        if (a == null || b == null || a.length != b.length)
            return false;
        // here, the arrays are valid and have the same length.

        if (a.length == 0)
            return true;

        // if the arrays contain only 1 number, we can compare it and return the result.
        if (a.length == 1)
            return a[0] == b[0];

        // creating an array of boolean values for the visited indexes, and sending it to the overloaded recursive method.
        boolean[] visited = new boolean[a.length]; // all values are "false" by default.
        return isPermutation(a, b, visited, STARTING_INDEX, STARTING_INDEX);
    }

    private static boolean isPermutation (int[] a, int[] b, boolean[] visited, int aIdx, int bIdx) {
        // base case - if checked all numbers in the first array without returning false, then it should return true.
        if (aIdx == a.length)
            return true;

        // returns false if a matching number wasn't found.
        if (bIdx == a.length)
            return false;

        // checking if the current numbers are equal and haven't been visited yet
        if (a[aIdx] == b[bIdx] && !visited[bIdx]) {
            visited[bIdx] = true;
            return isPermutation(a, b, visited, aIdx + 1, 0);
        }

        // here, the numbers are not equal (or visited already) so it should check the next number.
        return isPermutation(a, b, visited, aIdx, bIdx + 1);
    } // end of Q4.

   /**
     * -Q1
     *
     * Time complexity: O(n) Space complexity: O(1)
     *
     * Algorithm steps:
     *
     * 1) get sum of one of the arrays
     *
     * 2) remove first val from the first sum and add the val for the another
     * array to sum
     *
     * 3) check if there is shorter road than before.
     *
     * 4) keep doing the process until last value of the second array.
     *
     * 5) return min val.
     *
     * @param road1 array1 that represent the road
     * @param road2 array2 that represent the road
     * @return shortest road possible
     */
    public static int shortestRoad(int[] road1, int[] road2) {

        int sumRoad1 = 0, sumRoad2 = 0, n = road1.length;

        for (int i = 0; i < n; i++) {
            sumRoad1 += road1[i];
            sumRoad2 += road2[i];
        }

        int minPath1 = sumRoad1, minPath2 = sumRoad2;
        for (int i = 0; i < n; i++) {
            sumRoad1 = sumRoad1 - road1[i] + road2[i];
            sumRoad2 = sumRoad2 - road2[i] + road1[i];
            minPath1 = Math.min(minPath1, sumRoad1);
            minPath2 = Math.min(minPath2, sumRoad2);
        }

        int minPath = Math.min(minPath1, minPath2);

        return minPath;

    }

    /**
     * -Q2
     *
     * Time complexity: O(logn) Space complexity: O(1)
     *
     * Algorithm Steps:
     *
     * 1) Find the sequence difference
     *
     * 2) use the equation An = A1 + (n-1)d in order to find specific value.
     *
     * 3) Do binary search on the sequence:
     *
     * 3.1) Let val be := a[0] + (mid*d) , d := sequence difference
     *
     * 3.2) if a[mid] = val, go search right
     *
     * 3.3) if a[mid] != val, save val and go search left
     *
     * 3.4) stop when low = high and return val.
     *
     * @param arr represents sequence
     * @return missing value in the sequence
     */
    public static int missingValue(int[] arr) {
        
        if (arr.length == 2) {
            int avg = (arr[0] + arr[1]) / 2;
            return avg;
        }

        int low, mid, high, missingValue;

        missingValue = 0;
        high = arr.length - 1;
        low = 0;

        int d = Math.min((arr[1] - arr[0]), (arr[2] - arr[1]));

        while (low < high) {

            mid = (low + high) / 2;

            int eq = arr[0] + (mid * d);

            if (eq == arr[mid]) {
                low = mid + 1;
            } else {
                missingValue = eq;
                high = mid;
            }
        }
        return missingValue;
    }

    /**
     * -Q3
     *
     * Algorithm steps:
     *
     * 1) use 2 pointers. i = 0, j = a.length - 1
     *
     * 2) use counter (c) that keep count of the longest palindrom
     *
     * 3) stop recursion when: i > j and return c.
     *
     * 4) if i = j , return count + 1
     *
     * 5) if a[i] == a[j], add 2 to count and make i = i+1 , and j = j-1
     *
     * 6) try 2 options:
     *
     * 6.1) make i = i+1 and check if there is palindrom
     *
     * 6.2) make j = i-1 and check if there is palindrom
     *
     * 7) return the max value possible found from the mix of option 1 and 2.
     *
     * @param a array that represents the Palindrome.
     * @return longest palindrome
     */
    public static int longestPalindrome(int[] a) {
        return longestPalindrome(a, 0, a.length - 1, 0);
    }

    private static int longestPalindrome(int[] arr, int i, int j, int count) {

        if (i > j) {
            return count;
        }

        if (i == j) {
            return count + 1;
        }

        int skipLeft, skipRight, add;

        if (arr[i] == arr[j]) {

            add = longestPalindrome(arr, i + 1, j - 1, count + 2);
            skipRight = longestPalindrome(arr, i, j - 1, 0);
            skipLeft = longestPalindrome(arr, i + 1, j, 0);

            return Math.max(add, Math.max(skipLeft, skipRight));

        }

        skipLeft = longestPalindrome(arr, i, j - 1, 0);
        skipRight = longestPalindrome(arr, i + 1, j, 0);

        return Math.max(skipLeft, skipRight);

    }

    /**
     * -Q4
     *
     * Algorithm Steps:
     *
     * 1) two steps: add numbers or skip number
     *
     * 2) stop adding number if: sum > num or sum is of 3 values in a row.
     *
     * 3) if sum = num return true
     *
     * 4) if we tried all options of add or skip and there is no sum that equals
     * num, return false.
     *
     * @param a numbers you can add to get to num
     * @param num check if num in array by adding its values.
     * @return true if there is sum of num in array, false if not (max sum of 2
     * in a row)
     */
    public static boolean isSum(int[] a, int num) {

        if (num == 0) {
            return true;
        }

        return isSum(a, num, 0, 0, 0);

    }

    private static boolean isSum(int[] a, int num, int sum, int maxSequence, int i) {

        if (sum > num || maxSequence > 2) {
            return false;
        }

        if (sum == num) {
            return true;
        }

        if (i == a.length) {
            return false;
        }

        boolean add = isSum(a, num, a[i] + sum, maxSequence + 1, i + 1);
        boolean skip = isSum(a, num, sum, 0, i + 1);

        return add || skip;
    }
