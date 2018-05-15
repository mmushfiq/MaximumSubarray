package az.mm.maximumsubarray;

import java.util.Arrays;
import java.util.Random;

/**
 * Array length = [1000]
 * Duration: 
 * Brute Force        - 13 ms
 * Divide and Conquer -  2 ms
 * Kadane's Algorithm -  1 ms
 *
 * Array length = [1_000_000]
 * Duration: 
 * Brute Force        - 646535 ms
 * Divide and Conquer -    115 ms
 * Kadane's Algorithm -      9 ms
 *
 * @author MM <mushfiqazeri@gmail.com>
 */
public class CompareThreeWays {

    private long start, duration;

    public static void main(String[] args) {

        CompareThreeWays c = new CompareThreeWays();

        System.out.println("\n*** Array length: 1000 ***\n");
        c.maximumSubarray(1_000, 500, -500);
        
        System.out.println("\n*** Array length: 1_000_000 ***\n");
        c.maximumSubarray(1_000_000, 5000, -5000);
    }
    
    
    private void maximumSubarray(int arrLength, int maxValue, int minValue){
        int[] arr = createArray(arrLength, maxValue, minValue);

        System.out.println("Brute Force:");
        start();
        print(findMaximumSubarrayWithSimpleWay(arr));
        end();

        System.out.println("Divide and Conquer:");
        start();
        print(findMaximumSubarray(arr, 0, arr.length - 1));
        end();

        System.out.println("Kadane's Algorithm:");
        start();
        print(findMaximumSubarrayWithKadane(arr));
        end();
    }
    

    // 1st way - brute force, time complexity: O(n^2) 
    private int[] findMaximumSubarrayWithSimpleWay(int[] arr) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        int left = 0, right = 0;
        for (int i = 0, length = arr.length; i < length; i++) {
            sum = 0;
            for (int j = i; j < length; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    left = i;
                    right = j;
                }
            }
        }

        return new int[]{left, right, maxSum};
    }

    
    // 2nd way - divide and conquer, time complexity: O(nlogn)
    private int[] findMaximumSubarray(int[] a, int low, int high) {
        if (low == high) return new int[]{low, high, a[low]};
        
        int mid = (low + high) / 2;
        int[] left = findMaximumSubarray(a, low, mid);
        int[] right = findMaximumSubarray(a, mid + 1, high);
        int[] cross = findMaxCrossingSubarray(a, low, mid, high);

        if (left[2] >= right[2] && left[2] >= cross[2])
            return left;
        else if (right[2] >= cross[2]) 
            return right;
        else 
            return cross;
    }

    private int[] findMaxCrossingSubarray(int[] a, int low, int mid, int high) {
        int sum = 0, leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        int maxLeft = -1, maxRight = -1;

        for (int i = mid; i >= low; i--) {
            sum += a[i];
            if (leftSum < sum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += a[j];
            if (rightSum < sum) {
                rightSum = sum;
                maxRight = j;
            }
        }

        return new int[]{maxLeft, maxRight, (leftSum + rightSum)};
    }

    // 3rd way - Kadane's Algorithm, time complexity: O(n)
    private int[] findMaximumSubarrayWithKadane(int arr[]) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        int left = 0, right = 0, next = 0;

        for (int i = 0, length = arr.length; i < length; i++) {
            
            sum += arr[i];

            if (maxSum < sum) {
                maxSum = sum;
                left = next;
                right = i;
            }
            
            if (sum < 0) {
                sum = 0;
                next = i + 1;
            }
        }
        
        return new int[]{left, right, maxSum};
    }

    
    private int[] createArray(int length, int maxValue, int minValue) {
        int[] arr = new int[length];
        for(int i=0; i < length; i++)
            arr[i] = new Random().nextInt((maxValue - minValue) + 1) + minValue;
        
        System.out.printf("Given array: \n%s\n\n", Arrays.toString(arr));

        return arr;
    }

    
    private void print(int[] arr) {
        System.out.printf("Maximum-subarray: [%d.. %d], sum: %d%n", arr[0], arr[1], arr[2]);
    }
    

    private void start() {
        start = System.currentTimeMillis();
    }

    private void end() {
        duration = System.currentTimeMillis() - start;
        System.out.println("Duration: " + duration + "ms\n");
    }

}

