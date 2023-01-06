package Seminar02HW;

import java.util.Scanner;

// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

public class Task04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число или текст: ");
        String str = in.nextLine();
        if (str.equals("")) {
            throw new RuntimeException("Вы ввели пустую строку, пустые строки вводить нельзя!");
        } else {
            System.out.print("Введенный тест: " + str);
        }
    }
}
