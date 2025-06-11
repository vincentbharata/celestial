
public class Main {

    public static void main(String[] args) {
        //if-else
        // int number = 17;
        // if(number > 0) {
        //     System.out.println ("positive");
        // } else {
        //     System.out.println ("Negative");
        // }

        // //switch
        // int day = 3;
        // String dayName;
        // switch (day) {
        //     case 1:
        //         dayName = "Sunday";
        //         break;
        //     case 2:
        //         dayName = "Monday";
        //         break;
        //     case 3:
        //         dayName = "Tuesday";
        //         break;
        //     default:
        //         dayName = "Invalid day";
        //         break;
        // }
        // System.out.println("switch: " + dayName);

        // contoh do while
//        int i = 0;
//        do {
//            System.out.println("do while: " + i);
//            i++;
//        } while (i < 5);
//        // contoh while
//        int j = 0;
//        while (j < 5) {
//            System.out.println("while: " + j);
//            j++;
//        }
//        // contoh for
//        for (int k = 0; k < 5; k++) {
//            System.out.println("for: " + k);
//        }
        //odd-even number
        for (int num = 1; num <= 20; num++) {
            if (num % 2 != 0) {
                System.out.println("odd number: " + num);
            } else {
                System.err.println("Even number: " + num);
            }
        }
        //factorial
        int factorial = 1;
        int number = 7;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("Factorial dari " + number + " adalah: " + factorial);

    }

}
