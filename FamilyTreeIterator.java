import java.util.Iterator;

public class FamilyTreeIterator implements Iterator<Person> {
    private FamilyTree familyTree;
    public FamilyTreeIterator(FamilyTree familyTree){
        this.familyTree = familyTree;
    }
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Person next() {
        return null;
    }

    public boolean hasNextMother(){
        return false;
    }

    public Person nextMother(){
        return null;
    }
}
