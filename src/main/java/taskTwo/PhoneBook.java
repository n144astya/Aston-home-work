package taskTwo;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {

//    private List<Subscriber> phoneBook;
    private Map<String, Object> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        Object number = phoneBook.get(lastName);
        if (number != null) {
           if (number instanceof List) {
               ((List<String>)number).add(phoneNumber);
               phoneBook.put(lastName,number);
           } else {
               List<String> phoneNumbersList = new ArrayList<>();
               phoneNumbersList.add(phoneNumber);
               phoneNumbersList.add((String)number);
               phoneBook.put(lastName, phoneNumbersList);
           }
        } else  {
            phoneBook.put(lastName, phoneNumber);
        }
    }

    public Object get(String lastName) {
        return phoneBook.get(lastName);
    }
}
