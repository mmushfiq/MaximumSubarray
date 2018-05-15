package az.mm.maximumsubarray;

/**
 * Time complexity: O(n^2) 
 *
 * @author MM <mushfiqazeri@gmail.com>
 */
public class BruteForce {

    public static void main(String[] args) {
        int[] arr = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
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
        
        System.out.printf("Maximum-subarray: [%d.. %d], sum: %d%n", left, right, maxSum);
    }
}
