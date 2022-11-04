import java.time.LocalDate;
import java.util.Locale;

public class Lesson1 {
    public static void main(String[] args) {
        LocalDate data = LocalDate.of(1997, 12, 2);
        Person current = new Person("Игорь", data, "Мужской");

        System.out.println(current);

        LocalDate dataM = LocalDate.of(1973, 12, 25);
        LocalDate dataF = LocalDate.of(1965, 12, 4);

        Person person1 = new Person("Александр", dataF, "Мужской");
        Person person2 = new Person("Виктория", dataM, "Женский");

        System.out.println(person1);
        System.out.println(person2);

        FamilyTreeElement el = new FamilyTreeElement(current);
        el.addParent(person1);
        el.addParent(person2);
        System.out.println(el.getInfo());
    }
}
