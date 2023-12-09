public class Main {
    public static void main (String[] args) {
  /*      System.out.println("*** TEST 2020b ***\n");

        int[] a1 = {2, 5, 10, 20, 50};
        System.out.println("the Q1 result is: " + makeSum(a1, 40, 4));

        // Q2

        System.out.println("\n*** Q2 ***\n");
        int[] b1 = {10, 4, 2, 5, 6, 3, 8, 1, 5, 9};
        int[] b2 = {2, 5, 10, 20, 50};
        int[] b3 = {2, 5, 10, 20, 50};

        minimumSubK(b1, 3);
        minimumSubK(b1, 2);
        minimumSubK(b3, 1);*/

      /*  System.out.println("\n*** Q1 - Moed 84 ***\n");
        char[][] c1 = {
                {'t', 'z', 'x', 'c', 'd'},
                {'s', 'h', 'a', 'z', 'x'},
                {'h', 'w', 'l', 'o', 'm'},
                {'o', 'r', 'n', 't', 'n'},
                {'a', 'b', 'r', 'i', 'n'}
        };
        findWord(c1, "shalom");*/

   /*     System.out.println("for n = 8509 and range 1-200 the answer is: " + isHighFactorInRange(8509, 1, 200));

        System.out.println("\nthe answer for 8509 is: ");
        findFactors(8509);
        System.out.println("\nthe answer for 17*3 is: ");
        findFactors(17*3);*/

        // *** 2020a she'elon 87 ***
/*
        int[][] f1 = createArr(3);
        System.out.println("f1 array is: ");
        printArr(f1);

        System.out.println("\ntotal ways for f1 and k=1 is: " + totalWays(f1, 1));
        System.out.println("\ntotal ways for f1 and k=2 is: " + totalWays(f1, 2));
        System.out.println("\ntotal ways for f1 and k=3 is: " + totalWays(f1, 3));
        System.out.println("\ntotal ways for f1 and k=4 is: " + totalWays(f1, 4));*/

        //   int[] g1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //   printTriplets(g1, 40);

        //   System.out.println("the biggest div is " + findBiggestDiv(g1, 90));
        //     System.out.println("the smallest div is " + findSmallestDiv(g1, 40));

        //*** moed 85 ***
//        int[][] g1 = {
//                {1, 1, -1, 1, 1},
//                {1, 0, 0, -1, 1},
//                {1, 1, 1, 1, -1},
//                {-1, -1, 1, 1, 1},
//                {1, 1, -1, -1, 1}
//        };
//        printArr(g1);
//        System.out.println("the result in findMaximum should be 9 and the answer is: " + findMaximum(g1));

        //Q2
        int[] h1 = {1, 2, 4, 4, 5};
        System.out.println("the longest sequence should be 4 and the answer is: " + strictlyIncreasing(h1));
        //    System.out.println("the longest sequence should be 2 and the answer is: " + longestSequence(h1, 0, h1.length - 1));

    }

    //Q1
    public static int makeSum (int[] lengths, int k, int numOfSegments) {

        return makeSum(lengths, k, numOfSegments, 0);
    }

    public static int makeSum (int[] lengths, int k, int numOfSegments, int i) {

        if (numOfSegments >= 0) {
            if (k == 0) {
                //System.out.println("the number k = " + 0 + " and numOfSegments = " + numOfSegments);
                return 1;
            }
        }

        if (numOfSegments <= 0) return 0;

        if (k < 0) return 0;

        if (i == lengths.length) return 0;

        return makeSum(lengths, k - lengths[i], numOfSegments - 1, i) + makeSum(lengths, k, numOfSegments, i + 1);
    }

    //Q2
    public static void minimumSubK (int[] arr, int k) {

        if (arr.length < k) System.out.println("there can't be a sub array bigger than the array itself");

        if (arr.length == k) System.out.println("minimum sum sub array is: " + "(0," + (arr.length - 1) + ")");

        // array length > k

        int left = 0, right = arr.length - 1;
        int left2 = 0, right2 = 0;
        int sumLeft = 0, sumRight = 0;

        while (left <= right) {

            left2 = left + k - 1;
            right2 = right - k + 1;

            sumLeft = sumSub(arr, left, left2);
            sumRight = sumSub(arr, right2, right);

            if (sumLeft < sumRight) {
                right--;
            } else {
                left++;
            }
        }
        if (sumLeft < sumRight) System.out.println("minimum sum sub array is: " + "(" + left + "," + left2 + ")");
        System.out.println("minimum sum sub array is: " + "(" + right2 + "," + right + ")");
    }

    // helping method
    public static int sumSub (int[] arr, int i, int k) {
        int sum = 0;
        while (i <= k) {
            sum += arr[i];
            i++;
        }
        return sum;
    }
    // end of Q2

    // *** MOED 84 ***
    //Q1

    public static void findWord (char[][] arr, String word) {
        int[][] ansArr = createArr(arr.length);

        findWord(arr, word, 0, 0, 0, ansArr);
    }

    private static void findWord (char[][] arr, String word, int i, int j, int wordIdx, int[][] ansArr) {

        if (wordIdx == word.length()) {
            printArr(ansArr);
            return;
        }

        if (i == arr.length - 1 && j == arr.length - 1) {
            System.out.println("No Such Word");
            return;
        }

        //up
        if (i > 0) {
            if (word.charAt(wordIdx) == arr[i - 1][j] && wordFound(arr, i, j, word, wordIdx)) {
                ansArr[i - 1][j] = wordIdx + 1;
                findWord(arr, word, i - 1, j, wordIdx + 1, ansArr);
            }
        }

        //down
        if (i < arr.length - 1) {
            if (word.charAt(wordIdx) == arr[i + 1][j] && wordFound(arr, i, j, word, wordIdx)) {
                ansArr[i + 1][j] = wordIdx + 1;
                findWord(arr, word, i + 1, j, wordIdx + 1, ansArr);
            }
        }

        //left
        if (j > 0) {
            if (word.charAt(wordIdx) == arr[i][j - 1] && wordFound(arr, i, j, word, wordIdx)) {
                ansArr[i][j - 1] = wordIdx + 1;
                findWord(arr, word, i, j - 1, wordIdx + 1, ansArr);
            }

        }

        //right
        if (j < arr.length - 1) {
            if (word.charAt(wordIdx) == arr[i][j + 1] && wordFound(arr, i, j, word, wordIdx)) {
                ansArr[i][j + 1] = wordIdx + 1;
                findWord(arr, word, i, j + 1, wordIdx + 1, ansArr);
            }
        }

        //   if (right == 1 && down == 1 && up == 1 && left == 1) { // no path
        //  System.out.println("No Such Word");
        // return;
        // }
        //      if (wordFound(arr, i, j, word, wordIdx)){
        //   findWord(arr, word, i, j, wordIdx, ansArr);}
        //    return;

    }

    private static boolean wordFound (char[][] arr, int i, int j, String word, int wordIdx) {

        if (wordIdx <= word.length()) {
            return true;
        }

        if (i == arr.length - 1 && j == arr.length - 1) {
            if (arr[i][j] == word.charAt(wordIdx) && wordIdx == word.length() - 1) {

                return true;
            }
            return false;
        }

        boolean goUp, goDown, goRight, goLeft;
        //up boolean
        if (i > 0) {
            if (word.charAt(wordIdx) == arr[i - 1][j]) {
                return wordFound(arr, i - 1, j, word, wordIdx + 1);
            }
        }

        //down boolean
        if (i < arr.length - 1) {
            if (word.charAt(wordIdx) == arr[i + 1][j]) {
                return wordFound(arr, i + 1, j, word, wordIdx + 1);
            }
        }

        //left boolean
        if (j > 0) {
            if (word.charAt(wordIdx) == arr[i][j - 1]) {
                return wordFound(arr, i, j - 1, word, wordIdx + 1);
            }
        }

        //right boolean
        if (j < arr.length - 1) {
            if (word.charAt(wordIdx) == arr[i][j + 1]) {
                return wordFound(arr, i, j + 1, word, wordIdx + 1);
            }
        }

        goUp = wordFound(arr, i - 1, j, word, wordIdx);
        goDown = wordFound(arr, i + 1, j, word, wordIdx);
        goRight = wordFound(arr, i, j + 1, word, wordIdx);
        goLeft = wordFound(arr, i, j - 1, word, wordIdx);

        if (goLeft || goDown || goRight || goUp) return true;
        return false;

        //      return wordFound(arr, i, j + 1, word, wordIdx) || wordFound(arr, i + 1, j, word, wordIdx) ||
        //            wordFound(arr, i - 1, j, word, wordIdx + 1) || wordFound(arr, i, j - 1, word, wordIdx);
    }

    // helping method
    public static void printArr (int[][] arr) {
        printArrRecursive(arr, 0, 0);
    }

    private static void printArrRecursive (int[][] arr, int row, int col) { //    print array
        // Base case: If we reach the end of the array, return
        if (row == arr.length) {
            return;
        }
        // Print the current element
        System.out.print(arr[row][col] + " ");
        // Move to the next column
        if (col < arr[row].length - 1) {
            printArrRecursive(arr, row, col + 1);
        }
        // Move to the next row
        else {
            System.out.println();
            printArrRecursive(arr, row + 1, 0);
        }
    }

    public static int[][] createArr (int n) { // create new array with 0 values
        int[][] arr = new int[n][n];
        return createArr(arr, n, 0, 0);
    }

    private static int[][] createArr (int[][] arr, int n, int i, int j) {
        if (i == n && j == n) {
            return arr;
        }
        arr[i][j] = 0;
        if (j + 1 <= n - 1) {
            createArr(arr, n, i, j + 1);
        }
        if (i + 1 <= n - 1) {
            createArr(arr, n, i + 1, j);
        }
        return arr;
    }

    //*** Q2 ***
    //Q2

    public static void findFactors (int n) {

        int p, q = 0; // p = the small factor, q = the big factor

        if (n % 2 == 0) {
            p = 2;
            q = n / p;
            System.out.println("the small factor is: " + p + " and the big factor is: " + q);
            return;
        }

        int left = 5, right = n, middle;

        while (left <= right) {

            middle = (left + right) / 2;

            if (isHighFactorInRange(n, left, middle)) {
                if (!isHighFactorInRange(n, left, middle - 1)) {
                    q = middle;
                    break;
                }
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        p = n / q;
        System.out.println("the small factor is: " + p + " and the big factor is: " + q);
    }


    public static boolean isHighFactorInRange (int n, int low, int high) {
        int largestPrimeFactor = findLargestPrimeFactor(n);
        return largestPrimeFactor >= low && largestPrimeFactor <= high;
    }

    // Helper method to find the largest prime factor of a number
    private static int findLargestPrimeFactor (int n) {
        int largestFactor = 1;

        // Check for divisibility by 2
        while (n % 2 == 0) {
            largestFactor = 2;
            n /= 2;
        }

        // Check for divisibility by odd numbers starting from 3
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                largestFactor = i;
                n /= i;
            }
        }

        // If n is still greater than 2, it is a prime number itself
        if (n > 2) {
            largestFactor = n;
        }

        return largestFactor;
    }

    // *** 2020a : S-87 ***
    //Q1
    public static int totalWays (int[][] mat, int k) {
        if (k <= 0) return 0;
        return totalWays(mat, k, 0, 0, false, false);
    }

    private static int totalWays (int[][] mat, int k, int i, int j, boolean turnedDown, boolean turnedRight) {

        if (i > mat.length - 1 || i < 0 || j > mat[0].length - 1 || j < 0) return 0;

        if (i == mat.length - 1 && j == mat[0].length - 1) {
            if (k == 0) {
                return 1;
            }
            return 0;
        }

        int total = 0;

        //right turn now
        if (j + 1 <= mat[0].length - 1) {
            if (turnedDown) {
                total += totalWays(mat, k - 1, i, j + 1, false, true);
            } else {
                total += totalWays(mat, k, i, j + 1, false, true);
            }
        }
        //down turn now
        if (i + 1 <= mat.length - 1) {
            if (turnedRight) {
                total += totalWays(mat, k - 1, i + 1, j, true, false);
            } else {
                total += totalWays(mat, k, i + 1, j, true, false); // to cancel
            }
        }
        return total;
    }

    public static void printTriplets (int[] arr, int num) {

        if (arr.length < 3) return;
        if (num < arr[0]) return;

        if (findBiggestDiv(arr, num) == -1) {
            return;
        }

        int tempNum1 = num;
        int bigDiv = 0, midDiv = 0, smallDiv = 0;

        boolean was1 = true;

        while (tempNum1 >= 1 && was1) {

            was1 = true;

            System.out.println("1. big div = " + bigDiv + " mid div = " + midDiv + " small div = " + smallDiv);
            if (findBiggestDiv(arr, tempNum1) == -1) {
                return;
            }
            bigDiv = findBiggestDiv(arr, tempNum1);     //def the big div
            System.out.println("big div ==== " + bigDiv);
            tempNum1 = tempNum1 / bigDiv;            // finding the middle div - tempNum = num/div1
            System.out.println("2. big div = " + bigDiv + " mid div = " + midDiv + " small div = " + smallDiv);

            if (findBiggestDiv(arr, tempNum1) == -1) {
                return;
            }
            midDiv = findBiggestDiv(arr, tempNum1); // def the mid div
            tempNum1 = tempNum1 / midDiv; // finding the small div - tempNum = num/div1/div2
            System.out.println("3. big div = " + bigDiv + " mid div = " + midDiv + " small div = " + smallDiv + " tempnum = " + tempNum1);

            if (findBiggestDiv(arr, tempNum1) == -1) {
                System.out.println("findbiggest with tempnum =1 is: " + findBiggestDiv(arr, tempNum1));
                return;
            }
            //   smallDiv = findBiggestDiv(arr, tempNum1); // def the small div

            if (tempNum1 == 1) smallDiv = tempNum1;
            System.out.println(bigDiv + "\t" + midDiv + "\t" + smallDiv); // print
            System.out.println("4. big div = " + bigDiv + " mid div = " + midDiv + " small div = " + smallDiv);

            System.out.println("\n5. tempNum1 = num / findSmallestDiv(arr, tempNum1) = " + num / findSmallestDiv(arr, tempNum1) + " and tempNum is: " + tempNum1);

            tempNum1 = num / findSmallestDiv(arr, num); // def the next round num - tempNum = num/div1
        }

    }

    //helper
    private static boolean isAdivider (int a, int b) { // return true if b is a divider of a when a >= b
        return a % b == 0;
    }

    //helper2
    public static int findBiggestDiv (int[] arr, int num) { // return -1 if not founded

        int right = arr.length - 1, left = 0, middle = 0;
        int bigDiv = -1;

        if (arr[left] % num == 0) bigDiv = arr[left];
        if (arr[right] % num == 0) bigDiv = arr[right];

        while (left <= right) {

            middle = (left + right) / 2;

            if (isAdivider(num, arr[middle])) {
                bigDiv = arr[middle];
            }
            left = middle + 1;

            if (arr[middle] > num) {
                right = middle - 1;
            }
        } // if the biggest divider has not been found return -1;
        return bigDiv;
    }

    public static int findSmallestDiv (int[] arr, int num) { // return -1 if not founded

        int right = arr.length - 1, left = 0, middle = 0;
        int smallDiv = -1;


        while (left <= right) {

            middle = (left + right) / 2;

            if (num % arr[middle] == 0) {
                if (arr[middle] != 1) {
                    smallDiv = arr[middle];
                }
                right = middle - 1;
            }
            if (arr[middle] > num) {
                right = middle - 1;
            }
        }
        return smallDiv; // if the smallest divider has not been found return -1;
    }

    // **** moed 85 ****
    //Q1
    public static int findMaximum (int[][] mat) {
        if (mat[0][0] < 0) return -1;
        return findMaximum(mat, 0, 0);
    }

    private static int findMaximum (int[][] mat, int i, int j) {

        int sumOfPoints = 0;
        if (mat[i][j] == 1) sumOfPoints += 1;

       /* if (i < 0 || i >= mat.length - 1 || j >= mat.length - 1)
            return sumOfPoints;*/

        // turn right or down if i is odd && next is not -1
        if (i % 2 == 0) {
            if (j < mat[0].length - 1 && mat[i][j + 1] != -1) {
                sumOfPoints += findMaximum(mat, i, j + 1);   // go right
            } else {
                if (i < mat.length - 1 && mat[i + 1][j] != -1) {
                    sumOfPoints += findMaximum(mat, i + 1, j);   // go down
                }
            }
        }

        // turn left or down if i is odd && next is not -1
        if (i % 2 != 0) {
            if (j > 0 && mat[i][j - 1] != -1) {
                sumOfPoints += findMaximum(mat, i, j - 1);   // go left
            } else {
                if (i < mat.length - 1 && mat[i + 1][j] != -1) {
                    sumOfPoints += findMaximum(mat, i + 1, j);   // go down
                }
            }
        }

        return sumOfPoints;
    }

    //Q2
    public static int strictlyIncreasing (int[] a) {

        int counter = 0;
        if (a.length < 2) return counter;

        int j = a.length - 1;
        int longSeq = 0;

        for (int i = 0; i < a.length - 1; ) {

            longSeq = longestSequence(a, i, j);
            if (longSeq != -1) { // there is a sequence!!
                counter += (longSeq - i);
                i++; // +1
            } else {
                i++;
            }
        }
        return counter;
    }

    //helper
    private static int longestSequence (int[] a, int i,
                                        int j) { // return the index of the biggest j that make a sequence of '<'

        int counter = i;
        int firstI = i;

        for (i = i; i < j; ) {
            if (a[i] < a[i + 1]) {
                counter++;
                i++;
            } else if (firstI == i) {
                return -1;
            } else {
                return i;
            }
        }
        return counter;
    }
}
