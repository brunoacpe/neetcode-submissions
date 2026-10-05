class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        for (char character: s.toCharArray()) {
            
            if (isOpeningChar(character)) {
                stack.push(character);
            } else {
                //closing
                if (stack.isEmpty()) return false;
                
                Character pop = stack.pop();
                if (map.get(pop) != character) {
                    // nao ta certo
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpeningChar(char c) {
        return c == '{' || c == '[' || c == '(';
    }
}
