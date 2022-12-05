import java.util.LinkedList;

public class FamilyTree{
    private Person person;
    private FamilyTree mother;
    private FamilyTree father;

    public FamilyTree(Person person, FamilyTree mother, FamilyTree father){
        this.person = person;
        this.mother = mother;
        this.father = father;
    }

    public FamilyTree(Person person){
        this.person = person;
        if(this.person.getMother() != null)
            this.mother = new FamilyTree(this.person.getMother());
        if(this.person.getFather() != null)
            this.father = new FamilyTree(this.person.getFather());
    }

    public String print(){
        StringBuilder SB = new StringBuilder();

        if(mother != null)
            SB.append(mother.print());
        if(father != null)
            SB.append(father.print());

        return SB.toString();
    }

    @Override
    public String toString() {
        return this.person.toString();
    }
}
