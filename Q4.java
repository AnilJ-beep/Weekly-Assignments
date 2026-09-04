import java.util.HashMap;
import java.util.Scanner;

public class Q4 {

    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSums = new HashMap<>();

        // Empty prefix
        prefixSums.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            currentSum = currentSum + nums[i];

            int requiredSum = currentSum - k;

            if (prefixSums.containsKey(requiredSum)) {

                count = count + prefixSums.get(requiredSum);
            }

            // Store/update current prefix sum
            if (prefixSums.containsKey(currentSum)) {

                prefixSums.put(
                        currentSum,
                        prefixSums.get(currentSum) + 1
                );

            } else {

                prefixSums.put(currentSum, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = subarraySum(nums, k);

        System.out.println(
                "Number of Subarrays: " + result
        );

        sc.close();
    }
}