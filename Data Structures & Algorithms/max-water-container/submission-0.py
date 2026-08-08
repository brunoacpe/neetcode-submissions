class Solution:
    def maxArea(self, height: List[int]) -> int:
        l, r = 0, len(height) - 1
        max_area = 0

        while l < r:
            height_l = height[l]
            height_r = height[r]
            min_height = min(height_l, height_r)
            current_width = r - l
            current_area = min_height * current_width
            max_area = max(max_area, current_area)

            if min_height  == height_l:
                l+=1
            else:
                r-=1
        return max_area

        
        