class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    int currentStart = nums[start];
                    int currentEnd = nums[end];
                    output.add(List.of(nums[i], currentStart, currentEnd));
                    start++;
                    end--;
                    while (currentStart == nums[start] && start < end) {
                        start++;
                    }
                    while (currentEnd == nums[end] && end > start) {
                        end--;
                    }
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }   
            }
        }

        return output;
    }
}
