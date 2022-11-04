import java.time.LocalDate;
import java.util.ArrayList;


public class Person {
    private String name;
    private LocalDate birthday;
    private String sex;

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }

    public Person(String name, LocalDate data, String sex){
        this.name = name;
        this.birthday = data;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, пол: %s. ", this.name, this.birthday, this.sex);
    }
}
