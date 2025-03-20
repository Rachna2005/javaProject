import javax.swing.*;
import java.util.ArrayList;

public class MemberGUI {
    private ArrayList<String> requestHistory = new ArrayList<>();

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
            memberMenu();
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

    private void memberMenu() {
        JFrame menuFrame = new JFrame("Member Menu");
        JButton viewBooksButton = new JButton("View Books");
        JButton searchBookButton = new JButton("Search Book");
        JButton viewHistoryButton = new JButton("View Request History");

        viewBooksButton.addActionListener(e -> viewBooks());
        searchBookButton.addActionListener(e -> searchBook());
        viewHistoryButton.addActionListener(e -> viewRequestHistory());

        JPanel panel = new JPanel();
        panel.add(viewBooksButton);
        panel.add(searchBookButton);
        panel.add(viewHistoryButton);

        menuFrame.add(panel);
        menuFrame.setSize(400, 200);
        menuFrame.setVisible(true);
    }

    private void viewBooks() {
        StringBuilder books = new StringBuilder();
        for (Book book : BookManagers.getBooks()) {
            books.append(book.getTitle()).append(" by ").append(book.getAuthor()).append("\n");
        }
        JOptionPane.showMessageDialog(null, books.toString());
    }

    private void searchBook() {
        String searchTitle = JOptionPane.showInputDialog("Enter book title to search:");
        boolean found = false;
        for (Book book : BookManagers.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                JOptionPane.showMessageDialog(null, "Found: " + book.getTitle() + " by " + book.getAuthor());
                requestHistory.add(book.getTitle());
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Book not found.");
        }
    }

    private void viewRequestHistory() {
        if (requestHistory.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No request history.");
        } else {
            StringBuilder history = new StringBuilder("Request History:\n");
            for (String title : requestHistory) {
                history.append(title).append("\n");
            }
            JOptionPane.showMessageDialog(null, history.toString());
        }
    }
}
