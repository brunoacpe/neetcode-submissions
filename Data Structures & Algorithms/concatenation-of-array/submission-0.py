class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        output = [0] * (2 * len(nums))
        for i, num in enumerate(nums):
            idx = len(nums) + i
            output[i] = num
            output[idx] = num
        return output
