class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longestSequence = 0;

        for (int current : set) {

            // Só começa a contar se for o início da sequência
            if (!set.contains(current - 1)) {

                int currentLongest = 1;

                while (set.contains(current + 1)) {
                    current++;
                    currentLongest++;
                }

                longestSequence = Math.max(
                    longestSequence,
                    currentLongest
                );
            }
        }

        return longestSequence;
    }
}