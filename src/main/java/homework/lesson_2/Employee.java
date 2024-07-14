package homework.lesson_2;

public class Employee {

    private String fullName;
    private String position;
    private String email;
    private long phoneNumber;
    private int salary;
    private short age;

    public Employee(String fullName, String position, String email, long phoneNumber, int salary, short age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String getFirstName() {
        return fullName;
    }

    public void setFirstName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Full name: " + fullName +
                ", Position: " + position +
                ", Email: " + email +
                ", Phone number: " + phoneNumber +
                ", Salary: " + salary +
                ", Age: " + age;
    }

    public void print() {
        System.out.println("Full name: " + fullName + " | " +
                "Position: " + position + " | " +
                "Email: " + email + " | " +
                "Phone number: " + phoneNumber + " | " +
                "Salary: " + salary + " | " +
                "Age: " + age
        );
    }
}
