import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String args[]) {
        int option = JOptionPane.showConfirmDialog(null, 
                                "Do you want to change to the first class ticket","Class choice", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, "You've chosen: " 
                                + (option==JOptionPane.YES_OPTION?"Yes":"No"));
        
        System.exit(0);
    }
}

/* -	What happens if users choose “Cancel”?
 * -	How to customize the options to users, e.g. only two options: “Yes” and “No”, OR “I do” and “I don’t” (Suggestion: Use Javadocs or using Eclipse/Netbean IDE help). 
 */

 /* Answer: 
  * - Show up message: "You've chosen: No"
  * - Using YES_NO_OPTION
  */