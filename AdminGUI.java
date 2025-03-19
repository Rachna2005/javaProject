import javax.swing.*;
import java.awt.event.*;

public class AdminGUI {
    public AdminGUI() {
        String email = "admin@gmail.com";
        String password = "admin123";
        
        String inputEmail = JOptionPane.showInputDialog("Enter Admin Email:");
        String inputPassword = JOptionPane.showInputDialog("Enter Admin Password:");
        
        if (inputEmail.equals(email) && inputPassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Admin Login Successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Admin Credentials!");
        }
    }
}
