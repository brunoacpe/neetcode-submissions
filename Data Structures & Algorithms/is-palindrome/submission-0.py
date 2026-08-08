class Solution:
    def isPalindrome(self, s: str) -> bool:
        l, r  = 0, len(s) - 1

        while l < r:
            l_char = s[l]
            r_char = s[r]
            if not l_char.isalnum():
                l+=1
                continue
            
            if not r_char.isalnum():
                r-=1
                continue

            if l_char.lower() != r_char.lower():
                return False

            l+=1
            r-=1
        
        return True

    