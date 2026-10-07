class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int windowSize = s1.length();

        if (windowSize > s2.length()) return false;

        int[] targetCount = countLetters(s1);
        int[] windowCount = new int[26];

        for (int right = 0; right < s2.length(); right++) {
            // 1. Entra na janela
            addLetter(windowCount, s2.charAt(right));

            // 2. Sai da janela (só depois que ela já passou do tamanho)
            int left = right - windowSize;
            if (left >= 0) {
                removeLetter(windowCount, s2.charAt(left));
            }

            // 3. Janela cheia: compara
            boolean windowIsFull = right >= windowSize - 1;
            if (windowIsFull && Arrays.equals(targetCount, windowCount)) {
                return true;
            }
        }

        return false;
    }

    private int[] countLetters(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            addLetter(count, c);
        }
        return count;
    }

    private void addLetter(int[] count, char c) {
        count[c - 'a']++;
    }

    private void removeLetter(int[] count, char c) {
        count[c - 'a']--;
    }
}