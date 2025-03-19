import javax.swing.*;
import java.awt.event.*;

public class MemberGUI {
    public MemberGUI() {
        JFrame frame = new JFrame("Member Login/Register");
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        
        loginButton.addActionListener(e -> login());
        registerButton.addActionListener(e -> register());
        
        JPanel panel = new JPanel();
        panel.add(loginButton);
        panel.add(registerButton);
        
        frame.add(panel);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }
    private void login() {
        String email = JOptionPane.showInputDialog("Enter Email:");
        String password = JOptionPane.showInputDialog("Enter Password:");
        User user = User.User.get(email);
        if (user != null && user.verifyPassword(password)) {
            JOptionPane.showMessageDialog(null, "Login Successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Credentials!");
        }
    }
    private void register() {
        String name = JOptionPane.showInputDialog("Enter Name:");
        String email = JOptionPane.showInputDialog("Enter Email:");
        String phone = JOptionPane.showInputDialog("Enter Phone Number:");
        String password = JOptionPane.showInputDialog("Enter Password:");
        User newUser = new Member(name, email, phone, password);
        newUser.register();
        UserManager.saveUser(newUser);
    }
}
