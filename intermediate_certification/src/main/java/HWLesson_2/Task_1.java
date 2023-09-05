package HWLesson_2;

import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) {
        float input = requestFloatInput("Введите дробное число: ");
        System.out.println("Вы ввели число: " + input);
    }

    public static float requestFloatInput(String message) {
        Scanner scanner = new Scanner(System.in);
        float number;
        System.out.print(message);

        while (!scanner.hasNextFloat()) {
            scanner.nextLine(); // Отбрасываем некорректный ввод
            System.out.print("Некорректный ввод. Повторите попытку: ");
        }

        number = scanner.nextFloat();
        scanner.nextLine(); // Отбрасываем оставшийся символ новой строки

        return number;
    }
}