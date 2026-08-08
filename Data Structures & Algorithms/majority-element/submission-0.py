class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        threshold = len(nums) // 2
        nums_map = {}

        for num in nums:
            if num in nums_map:
                nums_map[num] += 1
            else:
                nums_map[num] = 1

            if nums_map[num] > threshold:
                return num