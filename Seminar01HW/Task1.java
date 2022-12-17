package Seminar01HW;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        int[] array1 = inputArray("first");
        int[] array2 = inputArray("second");
        int [] array3 = subArray(array1, array2);
        printArray(array3);
    }

    private static void printArray(int[] array1) {
        StringBuilder result = new StringBuilder();
        result.append("Result: ");
        result.append(Arrays.toString(array1));
        System.out.println(result);

    }

    private static int[] subArray(int[] array1, int[] array2) {

        if (!isNull(array1, array2)) {
            return null;
        }
        if (!compareLength(array1, array2)) {
            return null;
        }
        for (int i = 0; i < array1.length; i++) {  
            array1[i] -= array2[i];
        }
        return array1;
    }

    /**
    Method prevents exeption - java.lang.ArrayIndexOutOfBoundsException: Index out of bounds for length
     */
    public static boolean compareLength(int[] array1, int[] array2) {

        if (array1.length != array2.length) {
            System.out.println("Error: arrays have different lengths.");  
            return false;
        }

        return true;
    }

    /**
    Method prevents exeption - java.lang.NullPointerException: Cannot read the array length because "array2" is null
     */
    public static boolean isNull(int[] array1, int[] array2) {
        
        if (array1 == null || array2 == null) {
            System.out.println("Error: one of arrays is null");  
            return false;
        }

        return true;
    }

    public static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    /**
    Method prevents exeption - java.lang.NumberFormatException: For input string: ""
     */
    public static int[] inputArray(String name) {
        String temp = prompt("Imput " + name + " array in format 1,2,3: ");
        if (temp == "") {
            System.out.println("Error: Empty array");
            return null;
        }
        String[] strArr = temp.split(",");
        int[] arr = new int [strArr.length];
        for (int i = 0; i < strArr.length; i++) {
             arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
        
    }
}
