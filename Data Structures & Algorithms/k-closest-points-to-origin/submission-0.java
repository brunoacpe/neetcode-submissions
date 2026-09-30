class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // max-heap: maior distância no topo
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> b[2] - a[2]
        );

        for (int[] point : points) {
            int distance = calculateDistance(point);
            heap.offer(new int[]{point[0], point[1], distance});

            if (heap.size() > k) {
                heap.poll(); // remove o mais distante
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] current = heap.poll();
            result[i][0] = current[0];
            result[i][1] = current[1];
        }
        return result;
    }

    private int calculateDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}