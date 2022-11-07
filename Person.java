import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Person {
    private String name;
    private LocalDate birthday;
    private String sex;

    public Map<Person, connection> relatives;

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }

    public Map<Person, connection> getRelatives() {
        return relatives;
    }

    public Person(String name, LocalDate data, String sex){
        this.name = name;
        this.birthday = data;
        this.sex = sex;
        this.relatives = new HashMap<>();
    }

    public void addRelative(Person person, connection type){
        if(relatives.containsKey(person)){
            return;
        }
        this.relatives.put(person, type);

        if(type == connection.Mother || type == connection.Father){
            if(this.sex.equals("Мужской"))
                person.addRelative(this, connection.Son);
            else
                person.addRelative(this, connection.Daughter);
        }
        else if(type == connection.Brother || type == connection.Sister){
            if(this.sex.equals("Мужской"))
                person.addRelative(this, connection.Brother);
            else
                person.addRelative(this, connection.Sister);
        }
        else{
            if(this.sex.equals("Мужской"))
                person.addRelative(this, connection.Father);
            else
                person.addRelative(this, connection.Mother);
        }
    }

    @Override
    public int hashCode() {
        return (name + birthday.toString() + sex).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person){
            Person o = (Person) obj;
            if(this.name.equals(o.name)
                    && this.birthday == o.birthday
                    && this.sex.equals(o.sex))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, пол: %s. ", this.name, this.birthday, this.sex);
    }


    public enum connection{
        Mother,
        Father,
        Sister,
        Brother,
        Daughter,
        Son
    }
}

