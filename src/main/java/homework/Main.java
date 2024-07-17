package homework;

import homework.lesson_2.Employee;
import homework.lesson_2.Park;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivan Petrov", "developer", "Ivan@company.com", 375334567890L, 3000, (short) 25);
        employees[1] = new Employee("Petr Petrov", "developer", "PetrP@company.com", 375334567891L, 2800, (short) 22);
        employees[2] = new Employee("Alexy Kozlov", "developer", "Alexy@company.com", 375334567892L, 3100, (short) 27);
        employees[3] = new Employee("Ivan Ivanov", "developer", "IvanI@company.com", 375334567893L, 1700, (short) 21);
        employees[4] = new Employee("John Doe", "developer", "John@company.com", 375334567894L, 4000, (short) 35);

        for (Employee employee : employees) {
            employee.print();
        }

        Park park = new Park("Местичковый парк таракционов");

        Park.Attraction[] attractions = {
                park.new Attraction("каруселька", LocalTime.of(9, 30), LocalTime.of(20, 30), 2.0),
                park.new Attraction("обезьянка", LocalTime.of(9, 30), LocalTime.of(20, 30), 1.5),
                park.new Attraction("трамвайчик", LocalTime.of(9, 30), LocalTime.of(20, 30), 2.5),
                park.new Attraction("машинка", LocalTime.of(9, 30), LocalTime.of(20, 30), 5.0)
        };

        park.setAttractions(attractions);

        System.out.println("Park name: " + park.getName());
        for ( Park.Attraction atr: park.getAttractions()) {
            System.out.println("Attractions: " + atr.getName());
        }
    }
}
