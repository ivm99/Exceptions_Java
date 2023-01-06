package Seminar02HW;

public class Task02 {
    public static void main(String[] args) {
        // Если необходимо, исправьте данный код (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
        int [] intArray = {1,2,3,4,5,6,7,8,9};
        int d = 0;
        int index = 8;
        
        if (d == 0) {
            throw new ArithmeticException("Catching exception: division by zero");
        }
        if (index >= intArray.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        } 
            double catchedRes1 = intArray[index] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
         
    
    }
}
