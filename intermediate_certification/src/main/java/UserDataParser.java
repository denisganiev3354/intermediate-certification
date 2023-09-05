import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserDataParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные в следующем порядке, разделяя их пробелами:");
        System.out.println("Фамилия Имя Отчество Дата_рождения Номер_телефона Пол");

        String input = scanner.nextLine();
        String[] data = input.split(" ");

        if (data.length != 6) {
            System.out.println("Ошибка: Неправильное количество данных. Введите все данные в указанном формате.");
            scanner.close();
            return;
        }

        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String birthDate = data[3];
        String phoneNumber = data[4];
        String gender = data[5];

        try {
            validateData(lastName, firstName, middleName, birthDate, phoneNumber, gender);
            writeToTextFile(lastName, firstName, middleName, birthDate, phoneNumber, gender);
            System.out.println("Данные успешно записаны в файл.");
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void validateData(String lastName, String firstName, String middleName, String birthDate, String phoneNumber, String gender) throws Exception {
        if (!birthDate.matches("\\d{2}.\\d{2}.\\d{4}")) {
            throw new Exception("Неверный формат даты рождения. Используйте формат dd.mm.yyyy.");
        }

        if (!phoneNumber.matches("\\d+")) {
            throw new Exception("Неверный формат номера телефона. Введите только цифры.");
        }

        if (!gender.matches("[fm]")) {
            throw new Exception("Неверное значение пола. Используйте 'f' или 'm'.");
        }
    }

    private static void writeToTextFile(String lastName, String firstName, String middleName, String birthDate, String phoneNumber, String gender) throws IOException {
        String fileName = lastName + ".txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        String userData = lastName + firstName + middleName + birthDate + " " + phoneNumber + gender;
        writer.write(userData);
        writer.newLine();
        writer.close();
    }
}