package Week10Homework;

public class PersonNameOnly {
    private final String firstName;
    private final String lastName;

    public PersonNameOnly(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
}