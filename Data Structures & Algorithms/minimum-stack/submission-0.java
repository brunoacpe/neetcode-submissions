

class MinStack {
    private ArrayList<Integer> stack;
    private ArrayList<Integer> mins;

    public MinStack() {
        stack = new ArrayList<>();
        mins = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);

        if (mins.isEmpty()) {
            mins.add(val);
        } else {
            int menorAteAqui = Math.min(val, mins.get(mins.size() - 1));
            mins.add(menorAteAqui);
        }
    }

    public void pop() {
        stack.remove(stack.size() - 1);
        mins.remove(mins.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return mins.get(mins.size() - 1);
    }
}