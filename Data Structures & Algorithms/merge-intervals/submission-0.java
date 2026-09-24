class Solution {

    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        // Ordena pelo início do intervalo
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> ans = new ArrayList<>();

        // Primeiro intervalo é o nosso current
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            // Existe overlap
            if (nextStart <= currentEnd) {

                // Estende o intervalo atual
                currentEnd = Math.max(currentEnd, nextEnd);

            } else {

                // Não existe overlap
                ans.add(new int[]{currentStart, currentEnd});

                // Começa um novo intervalo
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }

        // Adiciona o último intervalo
        ans.add(new int[]{currentStart, currentEnd});

        return ans.toArray(new int[ans.size()][]);
    }
}