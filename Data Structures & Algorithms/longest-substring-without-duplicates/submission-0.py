class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # Stores the characters currently inside the sliding window.
        characters_in_window = set()

        # Left and right pointers define the current window.
        left_pointer = 0
        right_pointer = 0

        # Stores the longest valid window found so far.
        longest_length = 0

        while right_pointer < len(s):
            # Character that we are trying to add to the window.
            right_character = s[right_pointer]

            # If the character already exists in the window,
            # move the left pointer until the duplicate is removed.
            while right_character in characters_in_window:
                left_character = s[left_pointer]
                characters_in_window.remove(left_character)
                left_pointer += 1

            # The window is now valid, so add the new character.
            characters_in_window.add(right_character)

            # Calculate the size of the current window.
            current_window_length = right_pointer - left_pointer + 1

            # Keep the largest window found so far.
            longest_length = max(
                longest_length,
                current_window_length
            )

            # Expand the window to the right.
            right_pointer += 1

        return longest_length