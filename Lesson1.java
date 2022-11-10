import java.time.LocalDate;

public class Lesson1 {
    public static void main(String[] args) {
        Person me = new Person("Igor", LocalDate.of(1997, 12, 2), "Мужской");
        Person p1 = new Person("Женя", LocalDate.of(1998, 1, 1), "Мужской");
        Person p2 = new Person("Маша", LocalDate.of(1999, 2, 2), "Женский");
        Person p3 = new Person("Даша", LocalDate.of(2000, 3, 3), "Женский");
        Person p4 = new Person("ГАААЛЯ", LocalDate.of(1970, 4, 4), "Женский");
        Person p5 = new Person("Федя", LocalDate.of(1990, 5, 5), "Мужской");
        Person p6 = new Person("Вася", LocalDate.of(1945, 9, 2), "Мужской");

        me.addRelative(p1, Person.connection.Father);
        p1.addRelative(p2, Person.connection.Mother);
        p2.addRelative(p3, Person.connection.Mother);
        p3.addRelative(p4, Person.connection.Mother);
        p4.addRelative(p5, Person.connection.Father);
        p5.addRelative(p6, Person.connection.Father);
    }
}
