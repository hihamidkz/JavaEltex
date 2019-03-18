package collections;

public class User implements Comparable<User> {

    private String firstName;
    private int age;

    public User() {
        firstName = "user" + (int)(Math.random() * 1000000);
        age = (int)(Math.random() * 100);
    }

    public int compareTo(User obj) {
        return this.firstName.compareTo(obj.firstName);
    }
}