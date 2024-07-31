import taskOne.ArrayHandler;
import taskTwo.PhoneBook;
import taskTwo.Subscriber;

public class mainTaskFive {

    public static void main(String[] args) {
        String[] words = {"Океан", "Медведь", "Пицца", "Солнце", "Океан", "Книга", "Пицца", "Океан", "Гитара", "Океан", "Пицца", "Шоколад", "Бегемот", "Пицца", "Цветок", "Автобус", "Шоколад"};

        ArrayHandler handler = new ArrayHandler();
        System.out.println(handler.getUniqueWords(words));
        System.out.println(handler.getWordsEncounteredNumber(words));

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Петров", "+375294565432");
        phoneBook.add("Иванов", "+375296784324");
        phoneBook.add("Петров", "+375334324556");
        phoneBook.add("Морозов", "+375297658909");
        phoneBook.add("Логунов", "+375335436246");
        phoneBook.add("Гусев", "+375334537654");
        phoneBook.add("Петров", "+375335239831");

        System.out.println(phoneBook.get("Петров"));
        System.out.println(phoneBook.get("Морозов"));
    }
}
