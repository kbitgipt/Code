import java.util.*;

public class Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // ask size of array
        System.out.println("Please enter the size of array: ");
        int size = sc.nextInt();

        int my_array[] = new int[size];

        // ask for elements in array
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element #" + (i+1) + ": ");
            my_array[i] = sc.nextInt();
        }

        // sort the array in ascending order
        Arrays.sort(my_array);

        // calculate sum of array
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += my_array[i];
        }

        // cal average
        double average = (double) sum / my_array.length;

        // print sorted array, sum and average
        System.out.print("Sorted array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(my_array[i] + " ");
        }
        System.out.println("");
        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average value of array elements: " + average);
        sc.close();
    }    
}
