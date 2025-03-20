import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AdminGUI {
    private JFrame frame;
    private ArrayList<String> books = new ArrayList<>();
    private ArrayList<String> bookingRequests = new ArrayList<>();

    public AdminGUI() {
        String email = "admin@gmail.com";
        String password = "admin123";
        
        String inputEmail = JOptionPane.showInputDialog("Enter Admin Email:");
        String inputPassword = JOptionPane.showInputDialog("Enter Admin Password:");
        
        if (inputEmail.equals(email) && inputPassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Admin Login Successful!");
            showAdminMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Admin Credentials!");
        }
    }

    private void showAdminMenu() {
        frame = new JFrame("Admin Panel");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton manageUserButton = new JButton("Manage Users");
        JButton manageBooksButton = new JButton("Manage Books");
        JButton viewRequestsButton = new JButton("View Booking Requests");

        manageUserButton.addActionListener(e -> manageUsers());
        manageBooksButton.addActionListener(e -> manageBooks());
        viewRequestsButton.addActionListener(e -> viewBookingRequests());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.add(manageUserButton);
        panel.add(manageBooksButton);
        panel.add(viewRequestsButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void manageUsers() {
        JOptionPane.showMessageDialog(frame, "User Management - Feature Placeholder");
    }

    private void manageBooks() {
        JFrame bookFrame = new JFrame("Manage Books");
        bookFrame.setSize(400, 300);

        JButton viewButton = new JButton("View Books");
        JButton addButton = new JButton("Add Book");
        JButton deleteButton = new JButton("Delete Book");

        viewButton.addActionListener(e -> viewBooks());
        addButton.addActionListener(e -> addBook());
        deleteButton.addActionListener(e -> deleteBook());

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.add(viewButton);
        panel.add(addButton);
        panel.add(deleteButton);

        bookFrame.add(panel);
        bookFrame.setVisible(true);
    }

    private void viewBooks() {
        if (books.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No books available.");
        } else {
            StringBuilder bookList = new StringBuilder("Books:\n");
            for (String book : books) {
                bookList.append("- ").append(book).append("\n");
            }
            JOptionPane.showMessageDialog(frame, bookList.toString());
        }
    }

    private void addBook() {
        String title = JOptionPane.showInputDialog("Enter Book Title:");
        if (title != null && !title.trim().isEmpty()) {
            books.add(title);
            JOptionPane.showMessageDialog(frame, "Book added successfully.");
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid title.");
        }
    }

    private void deleteBook() {
        String title = JOptionPane.showInputDialog("Enter Book Title to Delete:");
        if (books.remove(title)) {
            JOptionPane.showMessageDialog(frame, "Book deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(frame, "Book not found.");
        }
    }

    private void viewBookingRequests() {
        if (bookingRequests.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No booking requests.");
        } else {
            StringBuilder requestList = new StringBuilder("Booking Requests:\n");
            for (String request : bookingRequests) {
                requestList.append("- ").append(request).append("\n");
            }
            JOptionPane.showMessageDialog(frame, requestList.toString());
        }
    }
}
