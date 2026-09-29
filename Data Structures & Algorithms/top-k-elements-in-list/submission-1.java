class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        // min-heap frequency based;
        PriorityQueue<Entry> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(Entry::frequency)
        );
        
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int num: nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            
            Entry input = new Entry(key, value);

            minHeap.offer(input);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[minHeap.size()];

        for (int i = 0; i < result.length; i ++) {
            result[i] = minHeap.poll().value;
        }

        return result;

    }
}
public record Entry(int value, int frequency){}
