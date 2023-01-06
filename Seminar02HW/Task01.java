package Seminar02HW;

import java.util.Scanner;

// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. 
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

public class Task01 {

    public static void main(String[] args) {
        System.out.printf("Введенное число: %s", floatNumberInput());

    }

    private static float floatNumberInput() {
        float num;
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите число в формате 1,23: ");
            try {
                num = in.nextFloat();
                break;
            } catch (RuntimeException e) {
                System.out.println("Вы ввели не число или использовали точку в качестве разделителя, попробуйте еще раз");
            }
        }
        return num;
    }
}
