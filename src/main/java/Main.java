import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Car[] cars = new Car[3];
        Race race = new Race();

        for (int i = 0; i < cars.length; i++) {
            System.out.printf("— Введите название машины №%d:%n", i + 1);
            String name = scanner.next();

            while (true) {
                System.out.printf("— Введите скорость машины №%d:%n", i + 1);
                int speed = scanner.nextInt();
                if (speed > 0 && speed <= 250) {
                    cars[i] = new Car(name, speed);
                    break;
                }
                System.out.println("— Неправильная скорость");
            }
        }
        race.startRace(cars);
    }
}

class Car {
    String name;
    int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}


class Race {
    private String winner = "";
    private int currentDistance = 0;

    void startRace(Car[] cars) {
        for (Car car : cars) {
            int distance = calculateDistance(car);
            if (distance > currentDistance) {
                currentDistance = distance;
                winner = car.name;
            }
        }

        System.out.println("Самая быстрая машина: " + winner);
    }

    private int calculateDistance(Car car) {
        return car.speed * 24;
    }
}
