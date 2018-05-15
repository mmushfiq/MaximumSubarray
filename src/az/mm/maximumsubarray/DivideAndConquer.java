package az.mm.maximumsubarray;

/**
 * Time complexity: O(nlogn)
 *
 * @author MM <mushfiqazeri@gmail.com>
 */
public class DivideAndConquer {

    public static void main(String[] args) {
        int[] arr = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] result = findMaximumSubarray(arr, 0, arr.length-1);
        System.out.printf("Maximum-subarray: [%d.. %d], sum: %d%n", result[0], result[1], result[2]);
    }

    
    private static int[] findMaximumSubarray(int[] a, int low, int high) {
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

    
    private static int[] findMaxCrossingSubarray(int[] a, int low, int mid, int high) {
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
}
