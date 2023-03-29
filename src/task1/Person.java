package task1;

import javax.naming.InvalidNameException;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) throws InvalidNameException, InvalidAgeException {
        if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()) {
            throw new InvalidNameException("Invalid name: " + firstName + " " + lastName);
        }

        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Invalid age: " + age);
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws InvalidNameException {
        if (firstName == null || firstName.isEmpty()) {
            throw new InvalidNameException("Invalid first name: " + firstName);
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws InvalidNameException {
        if (lastName == null || lastName.isEmpty()) {
            throw new InvalidNameException("Invalid last name: " + lastName);
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Invalid age: " + age);
        }
        this.age = age;
    }

    public static void main(String[] args) {
        try {
            Person p1 = new Person("John", "Doe", 30);
            Person p2 = new Person("Jane", "", 25); // throws InvalidNameException
            Person p3 = new Person(null, "Smith", 200); // throws InvalidNameException and InvalidAgeException
        } catch (InvalidNameException | InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}