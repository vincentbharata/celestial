public class Main {
    public static void main(String[] args) {
        //if-else
        int number = 17;
        if(number > 0) {
            System.out.println ("positive");
        } else {
            System.out.println ("Negative");
        }

        //switch
        int day = 3;
        String dayName;
        switch (day) {
            case 1:
                dayName = "Sunday";
                break;
            case 2:
                dayName = "Monday";
                break;

            case 3:
                dayName = "Tuesday";
                break;
            default:
                dayName = "Invalid day";
                break;
        }

        System.out.println("switch: " + dayName);
    }
}
