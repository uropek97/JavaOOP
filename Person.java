import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
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

    public Person getMother(){
        for (var item : this.relatives.entrySet()){
            if (item.getValue() == Person.connection.Mother){
                return item.getKey();
            }
        }
        return null;
    }
    public Person getFather(){
        for (var item : this.relatives.entrySet()){
            if (item.getValue() == Person.connection.Father){
                return item.getKey();
            }
        }
        return null;
    }

    public LinkedList<Person> getParents(){
        var listP = new LinkedList<Person>();
        listP.add(this.getMother());
        listP.add(this.getFather());
        return listP;
    }

    public LinkedList<Person> getBrothers(){
        var list = new LinkedList<Person>();
        for (var item : this.relatives.entrySet()){
            if (item.getValue() == Person.connection.Brother){
                list.add(item.getKey());
            }
        }
        return list;
    }
    public LinkedList<Person> getSisters(){
        var list = new LinkedList<Person>();
        for (var item : this.relatives.entrySet()){
            if (item.getValue() == Person.connection.Sister){
                list.add(item.getKey());
            }
        }
        return list;
    }

    public LinkedList<Person> getSiblings(){
        var listB = this.getBrothers();
        var listSis = this.getSisters();
        var listSib = new LinkedList<Person>();
        listSib.addAll(listB);
        listSib.addAll(listSis);
        return listSib;
    }

    public LinkedList<Person> getDaughters(){
        var list = new LinkedList<Person>();
        for (var item : this.relatives.entrySet()){
            if (item.getValue() == Person.connection.Daughter){
                list.add(item.getKey());
            }
        }
        return list;
    }

    public LinkedList<Person> getSons(){
        var list = new LinkedList<Person>();
        for (var item : this.relatives.entrySet()){
            if (item.getValue() == Person.connection.Son){
                list.add(item.getKey());
            }
        }
        return list;
    }

    public LinkedList<Person> getChildren(){
        var listS = this.getSons();
        var listD = this.getDaughters();
        var listC = new LinkedList<Person>();
        listC.addAll(listS);
        listC.addAll(listD);
        return listC;
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

