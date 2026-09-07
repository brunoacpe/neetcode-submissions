class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy_value = prices[0]
        max_profit = 0

        for price in prices:
            if price < buy_value:
                buy_value = price
            else:
                max_profit = max(max_profit, price - buy_value)

        return max_profit