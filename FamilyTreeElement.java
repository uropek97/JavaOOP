import java.util.ArrayList;

public class FamilyTreeElement {
    private Person current;
    private ArrayList<Person> parents = new ArrayList<>();
    private ArrayList<Person> children = new ArrayList<>();
    private ArrayList<Person> siblings = new ArrayList<>();

    public Person getCurrent() {
        return current;
    }

    public ArrayList<Person> getParents() {
        return parents;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public ArrayList<Person> getSiblings() {
        return siblings;
    }

    public FamilyTreeElement(Person current){
        this.current = current;
    }

    public void addParent(Person parent){
        if(parents.size()<2)
            this.parents.add(parent);
    }

    public void addChild(Person child){
        this.children.add(child);
    }

    public void addSibling(Person sibling){
        this.siblings.add(sibling);
    }

    public String getParentsInfo(){
        StringBuilder SB = new StringBuilder();
        if (this.parents != null){
            for(var item : this.parents){
                if(item.getSex() == "Мужской")
                    SB.append("Отец: ").append(item);
                else
                    SB.append("Мать: ").append(item);
            }
        }
        return SB.toString();
    }

    public String getInfo(){
        StringBuilder SB = new StringBuilder();
        SB.append("Текущий человек: ").append(this.current);
        if(this.parents != null )
            SB.append(this.getParentsInfo());
        else
            SB.append("Родители неизвестны. ");
        return SB.toString();
    }
}
