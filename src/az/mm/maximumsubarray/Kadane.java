
package az.mm.maximumsubarray;

/**
 * Time complexity: O(n)
 *
 * @author MM <mushfiqazeri@gmail.com>
 */
public class Kadane {

    public static void main(String[] args) {
        int[] arr = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
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
        
        System.out.printf("Maximum-subarray: [%d.. %d], sum: %d%n", left, right, maxSum);
    }
}
