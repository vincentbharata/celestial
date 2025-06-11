
public class Main {

    public static void main(String[] args) {
        //  System.out.println("Hello, World!");

        //data type long
        long number = 12345;
        System.out.println("Long: " + number);
        // data type int
        int integerNumber = 11;
        System.out.println("Integer: " + integerNumber);
        //data type double
        double decimalNumber = 19.99f;
        System.out.println("Double: " + decimalNumber);
        //data type char
        char character = 'A';
        System.out.println("Character: " + character);
        //data type boolean
        boolean isTrue = true;
        System.out.println("Boolean: " + isTrue);
        //data type String
        String text = "Hello, World!";
        System.out.println("String: " + text);
        //data type Array
        int[] numbersArray = {1, 2, 3, 4, 5};
        System.out.print("Array: ");
        for (int num : numbersArray) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
