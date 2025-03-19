import javax.swing.*;
import java.awt.event.*;

public class librarysystemGUI {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        UserManager.loadUsers();
        JFrame frame = new JFrame("Library System");
        JButton adminButton = new JButton("Admin");
        JButton memberButton = new JButton("Member");
        
        adminButton.addActionListener(e -> new AdminGUI());
        memberButton.addActionListener(e -> new MemberGUI());
        
        JPanel panel = new JPanel();
        panel.add(adminButton);
        panel.add(memberButton);
        
        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
