import java.util.HashMap;
import java.io.*;

public class User implements Authentication , Serializable {
    private static final long serialVersionUID = 1L;
    private static int idCounter = 0;
    protected int Id ;
    protected String name;
    protected String email;
    protected String phoneNumber;
    protected String password; 

    static HashMap<String, User> User = new HashMap<>();
    public static Object users;
    public User( String name, String email, String phoneNumber, String password) {
        this.Id = ++idCounter;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    
    @Override
    public void login() {
        User user = User.get(email);

        if (user != null && user.verifyPassword(password)) {
            System.out.println("Login successful! Welcome, " + user.name);
            
        } else {
            System.out.println("Invalid email or password.");
        }
        
    }

    @Override
    public void register() {
        if (User.containsKey(email)) {
            System.out.println("Registration failed! Email is already registered.");
            return;
        }
        User.put(this.email, this);
        UserManager.saveUser(this);
        System.out.println("Registration successful! You can now log in.");
        
    }
    
    public boolean verifyPassword(String password){
        return this.password.equals(password);
    }

}
