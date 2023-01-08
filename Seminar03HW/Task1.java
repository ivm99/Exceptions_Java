package Seminar03HW;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        while (true) {
            String data = inputData();
            String[] splittedData = data.split(" ");
            int checkData = dataVolumeValidation(splittedData);
            int[] fio = fioValidation(splittedData);
            if (isFIO(fio)) {
                System.out.printf("ФИО: %s %s %s\n", splittedData[fio[0]], splittedData[fio[1]], splittedData[fio[2]]);
            }
            int dateIndex = dateFormatValidation(splittedData);
            if (dateIndex != -1) {
                System.out.printf("Дата: %s\n", splittedData[dateIndex]);
            }
            int phoneNumberIndex = phoneNumberValidation(splittedData);
            if (phoneNumberIndex != -1) {
                System.out.printf("Телефон: %s\n", splittedData[phoneNumberIndex]);
            }
            int genderIndex = genderValidation(splittedData);
            if (genderIndex != -1) {
                System.out.printf("Пол: %s\n", splittedData[genderIndex]);
            }
            if (checkData == 6 && isFIO(fio) && dateIndex != -1 && phoneNumberIndex != -1 && genderIndex != -1) {
                saveToFile(splittedData, fio, dateIndex, phoneNumberIndex, genderIndex);
                System.out.println("Данные записаны в файл");
            } else {
                System.out.println("Данные не соответствуют требованиям. Запись в файл не произведена");
            }
            if (!userChoice()) {
                break;
            }
        }
    }

    public static String inputData() {
        Scanner in = new Scanner(System.in, "cp866");
        System.out.println("Введите данные в формате (Фамилия Имя Отчество датарождения номертелефона пол): ");
        return in.nextLine();
    }

    public static boolean userChoice() {
        Scanner in = new Scanner(System.in, "cp866");
        System.out.println("Введите 1, чтобы продолжить, или любую кнопку, чтобы завершить работу: ");
        String userChoice = in.nextLine();
        if (userChoice.equals("1")) {
            return true;
        }
        return false;
    }

    private static void saveToFile(String[] splittedData, int[] fio, int dateIndex, int phoneNumberIndex,
            int genderIndex) {
        try (FileWriter writer = new FileWriter("Seminar03HW/" + splittedData[fio[0]] + ".txt", true)) {
            writer.append(splittedData[fio[0]] + " " + splittedData[fio[1]] + " " + splittedData[fio[2]] + " "
                    + splittedData[dateIndex] + " " + splittedData[phoneNumberIndex] + " " + splittedData[genderIndex]
                    + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int dataVolumeValidation(String[] splittedData) {
        if (splittedData.length < 6) {
            System.out.println("Ошибка: Количество данных меньше, чем требуется");
            return -1;
        }
        if (splittedData.length > 6) {
            System.out.println("Ошибка: Количество данных больше, чем требуется");
            return -2;
        }
        return splittedData.length;
    }

    public static int[] fioValidation(String[] splittedData) {
        int[] fio = { -1, -1, -1 };
        int i = 0;
        for (String item : splittedData) {
            if (Character.isUpperCase(item.charAt(0)) && item.length() > 1) {
                if (fio[0] == -1) {
                    fio[0] = i;
                } else {
                    if (fio[1] == -1) {
                        fio[1] = i;
                    } else {
                        if (fio[2] == -1) {
                            fio[2] = i;
                        }
                    }
                }
            }
            i += 1;
        }
        if (fio[0] == -1 || fio[1] == -1 || fio[2] == -1) {
            System.out.println("Ошибка: Фамилия, Имя и Отчество не введены или введены не полностью");
        }
        return fio;
    }

    public static boolean isFIO(int[] fio) {
        for (int item : fio) {
            if (item == -1) {
                return false;
            }
        }
        return true;
    }

    public static int dateFormatValidation(String[] splittedData) {
        int dateIndex = -1;
        int i = 0;
        for (String item : splittedData) {
            if (item.matches("\\d{2}\\.\\d{2}\\.\\d{4}") && dateIndex == -1) {
                dateIndex = i;
                String[] fullDate = item.split("\\.");
                if (Integer.parseInt(fullDate[0]) < 1 || Integer.parseInt(fullDate[0]) > 31
                        || Integer.parseInt(fullDate[1]) < 1 || Integer.parseInt(fullDate[1]) > 12) {
                    System.out.println("Введеной даты не существует");
                    return -3;
                }
            }
            i += 1;
        }
        if (dateIndex == -1) {
            System.out.println("Ошибка: Дата не введена или формат даты не соответствует требованиям");
            return -1;
        }
        return dateIndex;
    }

    public static int phoneNumberValidation(String[] splittedData) {
        int phoneNumberIndex = -1;
        int i = 0;
        for (String item : splittedData) {
            if (isStringDbl(item) && item.length() > 6 && phoneNumberIndex == -1) {
                phoneNumberIndex = i;
            }
            i += 1;
        }
        if (phoneNumberIndex == -1) {
            System.out.println("Ошибка: Телефон не введен или введен в неверном формате (допускаются только цифры)");
            return -1;
        }
        return phoneNumberIndex;
    }

    public static boolean isStringDbl(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static int genderValidation(String[] splittedData) {
        int genderIndex = -1;
        int i = 0;
        for (String item : splittedData) {
            if (item.equals("m") || item.equals("f")) {
                genderIndex = i;
            }
            i += 1;
        }
        if (genderIndex == -1) {
            System.out.println("Ошибка: Пол не введен или введен с ошибкой (должен быть 'm' или 'f')");
            return -1;
        }
        return genderIndex;
    }

}
