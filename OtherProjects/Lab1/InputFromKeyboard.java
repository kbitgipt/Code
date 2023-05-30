import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
    
        System.out.println("Enter the height of pyramid: ");
        int rows = keyboard.nextInt();
        int space, k = 0;
        for (int i = 1; i <= rows; ++i, k = 0) {
            for (space = 1; space <= rows - i; ++space){
                System.out.print(" ");
            }
            while (k != 2*i - 1) {
                System.out.print("*");
                ++k;
            }
            System.out.println();
        } 
        keyboard.close(); 
    }

}
