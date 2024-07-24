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
        phoneBook.add(new Subscriber("Петров", "+375294565432"));
        phoneBook.add(new Subscriber("Иванов", "+375296784324"));
        phoneBook.add(new Subscriber("Петров", "+375334324556"));
        phoneBook.add(new Subscriber("Морозов", "+375297658909"));
        phoneBook.add(new Subscriber("Логунов", "+375335436246"));
        phoneBook.add(new Subscriber("Гусев", "+375334537654"));

        System.out.println(phoneBook.get("Петров"));
        System.out.println(phoneBook.get("Морозов"));
    }
}
