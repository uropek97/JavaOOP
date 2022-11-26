import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class FamilyTree {
    private Person person;
    private LinkedList<Person> parents;
    private LinkedList<Person> children;
    private LinkedList<Person> siblings;

    public FamilyTree(){
        this.person = null;
        this.parents = null;
        this.children = null;
        this.siblings = null;
    }
    public FamilyTree(Person person) {
        this.person = person;
        this.parents = this.person.getParents();
        this.children = this.person.getChildren();
        this.siblings = this.person.getSiblings();
    }

    public Person getPerson() {
        return person;
    }

    public void goMother(){
        for (var item : this.person.relatives.entrySet()){
            if (item.getValue() == Person.connection.Mother){
                this.person = item.getKey();
            }
        }
    }

    public void goFather(){
        for (var item : this.person.relatives.entrySet()){
            if (item.getValue() == Person.connection.Father){
                this.person = item.getKey();
            }
        }
    }

    public void goBrother(){
        for (var item : this.person.relatives.entrySet()){
            if (item.getValue() == Person.connection.Brother){
                this.person = item.getKey();
            }
        }
    }

    public void goSister(){
        for (var item : this.person.relatives.entrySet()){
            if (item.getValue() == Person.connection.Sister){
                this.person = item.getKey();
            }
        }
    }

    public void goDaughter(){
        for (var item : this.person.relatives.entrySet()){
            if (item.getValue() == Person.connection.Daughter){
                this.person = item.getKey();
            }
        }
    }

    public void goSon(){
        for (var item : this.person.relatives.entrySet()){
            if (item.getValue() == Person.connection.Son){
                this.person = item.getKey();
            }
        }
    }

    public void goSmb(String somebody){
        if(somebody.equalsIgnoreCase("мать") || somebody.equalsIgnoreCase("мама"))
            goMother();
        else if(somebody.equalsIgnoreCase("отец") || somebody.equalsIgnoreCase("папа"))
            goFather();
        else if(somebody.equalsIgnoreCase("брат"))
            goBrother();
        else if(somebody.equalsIgnoreCase("сестра"))
            goSister();
        else if(somebody.equalsIgnoreCase("дочь"))
            goDaughter();
        else if(somebody.equalsIgnoreCase("сын"))
            goSon();
    }

}
