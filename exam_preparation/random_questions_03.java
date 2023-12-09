public class Main {
    public static void main (String[] args) {
        System.out.println("*** 2022b ***");

        int[] a1 = {8, 4, 7, 1, 2, 3, 5};
        System.out.println("The result of split3 for the array is (need to be true): " + split3(a1));
        int[] a2 = {4, 7, 1, 2, 3, 5};
        System.out.println("The result of split3 for the array is (need to be false): " + split3(a2));
        int[] a3 = {4, 7, 1, 2, 3, 5, 8, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        System.out.println("The result of split3 for the array is (need to be true): " + split3(a3));

        System.out.println("*** Q2 ***");

        int[] a4 = {4, 7, 1, 2, 3, 5, 8, 2, 2, 2, 3, 3, 3, 4, 4, 4};

        System.out.println("The result of sumOfArray for the array is (??): " + sumOfArray(a4));
        System.out.println("The result of smallestSub for the array is (need to be 2): " + smallestSub(a4, 57));

        //*************************

        System.out.println("\n\n*** 2022b moed 62 ***");

        int[] a5 = {-3, 5, 12, 14, -9, 13};
        int[] a6 = {-3, 5, -12, 14, -9, 13};
        int[] aTESTER = {1, 2, 1, 2};

        System.out.println("The result of equalSplit for the array aTESTER is (need to be true): " + equalSplit(aTESTER));
        System.out.println("The result of equalSplit for the array a5 is (need to be true): " + equalSplit(a5));
        System.out.println("The result of equalSplit for the array a6 is (need to be false): " + equalSplit(a6));


    }

    //*** 2022b ***
    public static int sumOfArray (int[] arr) {
        return sumOfArray(arr, 0);
    }

    public static int sumOfArray (int[] arr, int i) {
        if (i == arr.length - 1)
            return arr[i];
        return arr[i] + sumOfArray(arr, i + 1);

    }

    // Q1
    public static boolean split3 (int[] arr) {
        return split3(arr, 0, 0, 0, 0, arr.length);
    }

    public static boolean split3 (int[] arr, int i, int sum1, int sum2, int sum3, int remainRounds) {

        // i - the index of the array at the current place - if do not use all need to return false
        // remainRounds - the number of remain calls in the array - when reaches 0 need to end method

        if (remainRounds == 0) {
            return ((sum1 == sum2) && (sum2 == sum3) && (i == arr.length));
        }

        if (split3(arr, i + 1, sum1 + arr[i], sum2, sum3, remainRounds - 1))
            return true;

        if (split3(arr, i + 1, sum1, sum2 + arr[i], sum3, remainRounds - 1))
            return true;

        if (split3(arr, i + 1, sum1, sum2, sum3 + arr[i], remainRounds - 1))
            return true;
        return false;
    }//end of Q1

    //Q2
    public static int smallestSub (int[] arr, int k) {

        if (arr.length == 0)
            return 0;
        if (arr.length == 1) {
            if (arr[0] > k) {
                return 1;
            }
            return 2;
        }

        int sumLength1 = 0, sumLength2 = 0, sum1 = 0, sum2 = 0;

        for (int i = 0; i < arr.length; i++) {

            if (k < arr[i]) // sub array is only 1 index long
                return 1;

            if (sum1 == sum2 && (sum1 != 0 || sum2 != 0)) { // if 2 sums equal remove longer subarray
                if (sumLength1 > sumLength2) {
                    sum1 = 0;
                    sumLength1 = 0;
                } else {
                    sum2 = 0;
                    sumLength2 = 0;
                }
            }

            if (sum1 + arr[i] > k) {   // if sum1 + arr[i] is bigger than k than add arr[i] to sum2
                sum2 += arr[i];         // add to sum2
                sumLength2++;
            } else {
                sum1 += arr[i];
                sumLength1++;
            }
        }
        if (sumLength2 == 0) {
            if (sumLength1 == 0) {
                return arr.length + 1;
            }
            return sumLength1;
        }
        return Math.min(sumLength1, sumLength2);
    }


    public static void quickSort (int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort (int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }


    private static int partition (int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // *** end of 2022b moed 60 ***

    // *** start of 2022b moed 62 ***
    //Q1
    public static boolean equalSplit (int[] arr) {
        if (arr.length % 2 != 0)
            return false;
        return equalSplit(arr, 0, 0, 0, 0);
        //  return equalSplit(arr, 0, 0, 0, arr.length/2, arr.length-1);
    }

    public static boolean equalSplit (int[] arr, int i, int sum1, int sum2, int halfArr) {

        if (i == arr.length) {
            System.out.print("new call:\nhalfArr = " + halfArr + "\ni = " + i + "\nsum1 = " + sum1 + " sum2 = " + sum2 + "\n\n");
            return sum1 == sum2 && (halfArr == arr.length / 2);
        }
        return equalSplit(arr, i + 1, sum1 + arr[i], sum2, halfArr + 1) ||
                equalSplit(arr, i + 1, sum1, sum2 + arr[i], halfArr);

    }// end of Q1

    // start of Q2
 /*   public static boolean search(int[][] arr, int num) {


        int endRow = arr.length, endCol = arr[0].length, startRow = 0, startCol = 0, row, col;

        while () {

            row = (startRow + endRow) / 2;
            col = (startCol + endCol) / 2;

            // turn up
            if (arr[row][col] > num && row > 0) {
                row--;
            }

            if (arr[row][col] == num) {
                System.out.println("row = " + row + "\ncol = " + col);
                return true;
            }

            if (arr[row][col] > num && col > 0) {
                col--;
            }
*/


    public static boolean search (int[][] arr, int num) { // not good but clever

        int n = arr.length;
        if (num > arr[n - 1][0] || num < arr[0][0])
            return false;

        int i = 0, j = 0;

        while (n > 1) {

            int minS1 = arr[i][j];
            int maxS1 = arr[1 + i][1 + j];
            int minS2 = arr[(n / 2) - 1 + i][j];
            int maxS2 = arr[i][(n / 2) + j];
            int minS3 = arr[(n / 2) + i][(n / 2) + j];
            int maxS3 = arr[(n - 1)][(n / 2) + j];
            int minS4 = arr[(n / 2) + i][j];
            int maxS4 = arr[n - 1 + i][j];

            if (num > maxS2) {
                if (num > maxS3) {
                    i += n / 2;
                } else {
                    i += n / 2;
                    j += n / 2;
                }
            } else if (num > maxS1) {
                j += n / 2;
            }
            n = n / 2;
        }
        if (num == arr[i][j]) {
            System.out.println("row = " + i + "\ncol = " + j);
            return true;
        }
        return false;
    }
