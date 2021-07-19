package DSA.ARRAY;



import java.util.Arrays;

public class next_permutation {

    public static int[] nextpermutation(int[] nums) {
        boolean switcher = true;
        int start = 0;

        for (int i = nums.length - 1; i >= 1; i--) {
            // finding a number which is greater than its previous number
            if (nums[i] > nums[i - 1]) {
                // if the number is found than confirm to find the smallest number sorting needs to be done
                switcher = false;

                // taking minimum of the number
                int min = nums[i] - nums[i - 1];

                // ppoint from where sorting neeeds to be done
                start = i;
                int diff;
                int exchange = i;
                // finding the smallest number from where sorting needs to be done
                for (int j = i + 1; j < nums.length; j++) {
                    diff = nums[j] - nums[i - 1];
                    if (diff < min && diff>0) {
                        min = diff;
                        exchange = j;
                    }
                }
                // exchange the smallest  number
                nums[i - 1] = nums[exchange] + nums[i - 1] - (nums[exchange] = nums[i - 1]);
                break;
            }
        }

        if (switcher) {
            // sort if final permtation
            Arrays.sort(nums);
        } else {
            // sort if exchange number is found
            Arrays.sort(nums, start , nums.length);
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 0, 2, 3, 2, 0 };
        nums = nextpermutation(nums);
        for (int x : nums)
            System.out.print(x + " ");
    }
}