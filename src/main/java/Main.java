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
                String speedLine = scanner.next();
                if (isDigits(speedLine)) {
                    int speed = Integer.parseInt(speedLine);
                    if (speed > 0 && speed <= 250) {
                        cars[i] = new Car(name, speed);
                        break;
                    }
                }
                System.out.println("— Неправильная скорость");
            }
        }
        race.startRace(cars);
    }


    //Так как в курсе ещё не знакомы с regexp и исключениями, метод для определения является ли строка трехзначным числом и менее
    public static boolean isDigits(String line) {
        String numbers = "0123456789";
        if (line.length() > 3) {
            return false;
        } else {
            boolean allContains = true;
            for (int i = 0; i < line.length(); i++) {
                if (!numbers.contains(String.valueOf(line.charAt(i)))) {
                    allContains = false;
                    break;
                }
            }
            return allContains;
        }
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
