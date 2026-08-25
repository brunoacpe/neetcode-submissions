class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        has_appeared = set()

        for number in nums:
            if number not in has_appeared:
                has_appeared.add(number)
            else:
                return True
        
        return False