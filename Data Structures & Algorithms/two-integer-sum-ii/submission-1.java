class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;


        while (l < r) {
            int leftInt = numbers[l];
            int rightInt = numbers[r];

            if (leftInt + rightInt == target) {
                if (l < r) return new int[]{l + 1, r + 1};
                l++;
            } else if (leftInt + rightInt > target) {
                r--;
            } else {
                l++;
            }
        }

        return new int[]{0};
    }
}
