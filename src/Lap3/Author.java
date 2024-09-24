package Lap3;

public class Author {
    // Private instance variables
    private String name;
    private String email;
    private char gender;

    // Constructor to initialize all instance variables
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    // Getters for name, email, and gender
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    // toString() method to display author's details
    @Override
    public String toString() {
        return name + " (" + gender + ") at " + email;
    }
}
