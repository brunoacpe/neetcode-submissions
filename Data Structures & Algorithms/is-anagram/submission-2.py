class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        if len(s) != len(t):
            return False
        
        seen_s = {}
        seen_t = {}

        for char in s:
            if char in seen_s:
                curr = seen_s[char]
                seen_s[char] = curr + 1
                continue
            seen_s[char] = 1
        
        for char in t:
            if char in seen_t:
                curr = seen_t[char]
                seen_t[char] = curr + 1
                continue
            seen_t[char] = 1
        
        return seen_s == seen_t
        

        