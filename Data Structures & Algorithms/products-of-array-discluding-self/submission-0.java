class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] postfix = new int[n];

        int[] result = new int[n];
        prefix[0] = 1; // nao tem nada a esquerda
        postfix[n - 1] = 1;// nao tem nada a direita


        //Build prefix;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }

        //Build postfix
        for (int i = nums.length - 2; i >=0; i --) {
            postfix[i] = nums [i + 1] * postfix[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * postfix[i];
        }

        return result;
    }
}  
