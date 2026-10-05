class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>(); // guarda índices
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int current = temperatures[i];

            // Enquanto o dia atual for mais quente que o dia do topo, resolve o topo
            while (!stack.isEmpty() && current > temperatures[stack.peek()]) {
                int top = stack.pop();
                result[top] = i - top;
            }

            stack.push(i);
        }

        return result;
    }
}