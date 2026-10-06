class Solution {
    public record Car(
        int position,
        int speed,
        double timeToTarget
    ) {}

    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        Deque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < position.length; i++) {
            double time = calculateTimeToTarget(position[i], speed[i], target);
            cars.add(new Car(position[i], speed[i], time));
        }

        // Do mais próximo do destino (maior posição) para o mais distante
        cars.sort(Comparator.comparingInt(Car::position).reversed());

        for (Car car : cars) {
            if (stack.isEmpty() || car.timeToTarget() > stack.peek()) {
                stack.push(car.timeToTarget());
            }
            // senão: o carro é engolido pelo fleet da frente, não faz nada
        }

        return stack.size();
    }

    private double calculateTimeToTarget(int position, int speed, int target) {
        double distanceLeft = target - position;
        return distanceLeft / speed;
    }
}