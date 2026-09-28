class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hmap = new HashMap<>();

        for (String s: strs) {
            int[] chars = new int[26];

            for (char c : s.toCharArray()) {
                chars[c - 'a']++;
            }

            String key = Arrays.toString(chars);

            hmap.computeIfAbsent(key, k -> new ArrayList<>())
                .add(s);
        }

        List<List<String>> output = new ArrayList<>();

        for (List<String> s: hmap.values()) {
            output.add(s);
        }

        return output;
    }
}
