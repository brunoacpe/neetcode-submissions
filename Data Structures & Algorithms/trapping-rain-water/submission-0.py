class Solution:
    def trap(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1

        left_max = 0
        right_max = 0

        total_water = 0

        while left < right:
            left_height = height[left]
            right_height = height[right]

            if left_height <= right_height:
                # Atualiza a maior parede encontrada pela esquerda.
                left_max = max(left_max, left_height)

                # Se a parede atual for menor que left_max,
                # a diferença representa água armazenada nessa posição.
                total_water += left_max - left_height

                left += 1

            else:
                # Atualiza a maior parede encontrada pela direita.
                right_max = max(right_max, right_height)

                # Se a parede atual for menor que right_max,
                # a diferença representa água armazenada nessa posição.
                total_water += right_max - right_height

                right -= 1

        return total_water
        