import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class FamilyTree implements Iterable<Person>{
    private Person person;
    private Person mother;
    private Person father;
    private int knee;

    public void setPerson(Person person) {
        this.person = person;
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

    public int getKnee() {
        return knee;
    }

    public void setKnee(int knee) {
        this.knee = knee;
    }

    public FamilyTree(){
        this.person = null;
        this.mother = null;
        this.father = null;
        this.knee = 0;
    }
    public FamilyTree(Person person) {
        this.person = person;
        this.mother = this.person.getMother();
        this.father = this.person.getFather();
        this.knee = 1;
    }

    public Person getPerson() {
        return person;
    }

    public void goMother(){
        this.person = this.mother;
        this.mother = this.person.getMother();
        this.father = this.person.getFather();
        this.knee++;
    }

    public void goFather(){
        this.person = this.father;
        this.mother = this.person.getMother();
        this.father = this.person.getFather();
        this.knee++;
    }

    @Override
    public Iterator<Person> iterator() {
        return new FamilyTreeIterator(this);
    }
}
