import java.util.*;

public class DaysOfMonth {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int month = 0;
        int leap_year = 2;
        // month input
        while (month == 0) {
            System.out.println("Please enter a month: ");
            String userInput = sc.nextLine().toLowerCase();
            
            switch (userInput) {
                case "january":
                case "jan":
                case "1":
                    month = 1;
                    break;
                case "february":
                case "feb":
                case "2":
                    month = 2;
                    break;
                case "march":
                case "mar":
                case "3":
                    month = 3;
                    break;
                case "april":
                case "apr":
                case "4":
                    month = 4;
                    break;
                case "may":
                case "5":
                    month = 5;
                    break;
                case "june":
                case "jun":
                case "6":
                    month = 6;
                    break;
                case "july":
                case "jul":
                case "7":
                    month = 7;
                    break;
                case "august":
                case "aug":
                case "8":
                    month = 8;
                    break;
                case "september":
                case "sep":
                case "sept":
                case "9":
                    month = 9;
                    break;
                case "october":
                case "oct":
                case "10":
                    month = 10;
                    break;
                case "november":
                case "nov":
                case "11":
                    month = 11;
                    break;
                case "december":
                case "dec":
                case "12":
                    month = 12;
                    break;
                default: 
                    System.out.print("Invalid month input.");
                    return; // terminate program if input is invalid
            }
        }
        // year input
        while (leap_year == 2) {
            System.out.println("Please enter a year: ");
            int year = sc.nextInt();

            if (year <= 0) {
                System.out.println("Invalid year input, please try again.");
                continue;
            } 
            else if (year % 400 == 0 && year % 100 == 0) {
                leap_year = 1;
            } 
            else if (year % 4 == 0 && year % 100 != 0) {
                leap_year = 1;
            } 
            else {
                leap_year = 0;
            }
        }
        // print out days of month
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            System.out.println("Month " + month + " has 31 days.");
        } 
        else if (month == 4 || month == 6 || month == 9 || month == 11) {
            System.out.println("Month " + month + " has 30 days.");
        } 
        else if (month == 2 && leap_year == 1) {
            System.out.println("Month 2 of leap year has 29 days.");
        } 
        else 
            System.out.println("Month 2 of non-leap year has 28 days.");

        sc.close();
    }
}
