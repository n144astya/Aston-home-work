package taskTwo;

public class Subscriber {

    private String secondName;
    private String phoneNumber;

    public Subscriber(String secondName, String phoneNumber) {
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;

    }
}
