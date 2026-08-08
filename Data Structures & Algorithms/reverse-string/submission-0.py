class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        l, r = 0, len(s) - 1

        while l < r:
            left = s[l]
            right = s[r]
            s[l] = right
            s[r] = left
            l+=1
            r-=1
        