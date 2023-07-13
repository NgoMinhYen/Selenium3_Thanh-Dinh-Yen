package dataobjects;

public class Employee {
    private String firstName;
    private String lastName;
    private String fullName;
    private String ID;

    public Employee(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = id;
    }

    public void setFirstName(){
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }
}
