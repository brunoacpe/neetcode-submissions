import heapq

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        seen = {}
        heap = []
        output = []
        for number in nums:
            seen[number] = seen.get(number, 0) + 1
        
        for number, frequency in seen.items():
            heapq.heappush(heap, (-frequency, number))
        
        for _ in range(k):
            freq, number = heapq.heappop(heap)
            output.append(number)
        
        return output