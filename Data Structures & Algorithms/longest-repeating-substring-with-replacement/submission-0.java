class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int longest = 0;
        int[] chars = new int[26];

        for (int right = 0; right < s.length(); right++) {
            // 1. Adiciona o caractere da direita na janela
            chars[s.charAt(right) - 'A']++;

            // 2. Enquanto a janela for inválida, encolhe pela esquerda
            while ((right - left + 1) - findMaxValueArr(chars) > k) {
                chars[s.charAt(left) - 'A']--;
                left++;
            }

            // 3. Atualiza a melhor resposta
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }

    private int findMaxValueArr(int[] chars) {
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            max = Math.max(max, chars[i]);
        }
        return max;
    }
}