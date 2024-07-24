package taskTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBook {

    private List<Subscriber> phoneBook;

    public PhoneBook() {
        phoneBook = new ArrayList<>();
    }

    public void add(Subscriber subscriber) {
        phoneBook.add(subscriber);
    }

    public List<String> get(String secondName) {
        return phoneBook.stream().filter(subscriber -> subscriber.getSecondName().equals(secondName)).map(Subscriber::getPhoneNumber).collect(Collectors.toList());
    }
}
