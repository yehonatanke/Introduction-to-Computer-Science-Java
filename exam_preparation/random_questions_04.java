public class Main {

    public static void main (String[] args) {

        int num = 3; // start of Q1
        int result = 36;
        int maxOp = 4;
        int test = calc(num, result, maxOp);
        System.out.println("Q1: \nNumber of expressions: " + test); // end of Q1


        int[] a = new int[]{0, 40, 31, 0, 0, 20, 19, 0, 15, 11, 0, 0, 0, 0, 9, 7, 4, 0, 0, 3};
        int[] a2 = new int[]{3, 0, 0, 4, 7, 9, 0, 0, 0, 0, 11, 15, 0, 19, 20, 0, 0, 31, 40, 0};
        System.out.println("Q2: \n The answer is: " + kAlmostSearch(a2, 3));

        System.out.println("expected 11: " + kAlmostSearch(new int[]{1, 0, 0, 2, 3, 4, 0, 0, 0, 0, 0, 5, 6}, 5));

        System.out.println("expected 5: " + kAlmostSearch(new int[]{1, 0, 0, 2, 3, 4, 0, 0, 0, 0, 0, 5, 6}, 4));

        System.out.println("expected 0: " + kAlmostSearch(new int[]{1, 0, 0, 2, 3, 4, 0, 0, 0, 0, 0, 5, 6}, 1));

        System.out.println("expected 12: " + kAlmostSearch(new int[]{1, 0, 0, 2, 3, 4, 0, 0, 0, 0, 0, 5, 6}, 6));

        System.out.println("expected 3: " + kAlmostSearch(new int[]{1, 0, 0, 2, 3, 4, 0, 0, 0, 0, 0, 5, 6}, 2));
    }

    // *** START OF Q1 ***
    public static int calc (int num, int result, int maxOp) {
        if (num == 0 || maxOp == 0)
            return 0;
        return calc(num, result, maxOp, num, num + "", 0);
    }

    private static int calc (int num, int result, int maxOp, int curNum, String str, int counter) {

        if (maxOp < 0)
            return counter;

        if (curNum == result) {
            System.out.println(str + " = " + result);
            counter++;
            return counter;
        }
        int a1 = calc(num, result, maxOp - 1, curNum + num, str + " + " + num, counter); // sum
        int a2 = calc(num, result, maxOp - 1, curNum - num, str + " - " + num, counter); // sub
        int a3 = calc(num, result, maxOp - 1, curNum * num, str + " * " + num, counter);// mul
        int a4 = calc(num, result, maxOp - 1, curNum / num, str + " / " + num, counter); // div
        return a1 + a2 + a3 + a4;
    }
    // *** END OF Q1 ***

    // Time complexity: O(log n) [ <-- O(k*log n), but k is constant ]
    // Space complexity: O(1)

    /*
    NOTE: Time complexity is O(log n).
    WORST CASE is that in every (log n) iteration, we would get exactly k zeros,
    therefore, the time complexity would be O(k*log n).
    k is constant --> O(k*log n) = O(log n)
     */
    public static int kAlmostSearch (int[] a, int num) {

        int low = 0, high = a.length - 1;

        // I used '<=' instead of '<' in 'low <= high'
        // So the last loop will check the last number when low == high.
        // Checking after the while loop if 'a[low] == num' is good as well.
        while (low <= high) {

            int mid = (low + high) / 2;

            // First check if the middle number is the requested number.
            if (a[mid] == num)
                return mid;

            while (mid > low && a[mid] == 0)
                // Time complexity: O(1).
                // O(k) but k is constant.
                mid -= 1;

            // Second check is necessary, we moved to another index, maybe thats our number.
            if (a[mid] == num)
                return mid;

            // The number in mid-index is not our number,
            // moves to the right or left half of the as requested.
            if (a[mid] < num)
                low = mid + 1;

            else
                high = mid - 1;

        }
        // num is not within the array.
        return -1;
    }
