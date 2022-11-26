import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate birthday;
    private String sex;
    private Person mother;
    private Person father;

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }


    public Person() {
        this.name = null;
        this.birthday = null;
        this.sex = null;
        this.mother = null;
        this.father = null;
    }
    public Person(String name){
        this();
        this.name = name;
    }

    public Person(String name, LocalDate data, String sex){
        this(name);
        this.birthday = data;
        this.sex = sex;
    }

    public Person(String name, LocalDate birthday, String sex, Person mother, Person father) {
        this(name, birthday, sex);
        this.mother = mother;
        this.father = father;
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
}

