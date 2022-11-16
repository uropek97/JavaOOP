import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class FamilyTree {
    private Person person;

    public FamilyTree(){
        this.person = null;
    }
    public FamilyTree(Person person){
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void goMother(){
        var a = this.person.relatives.entrySet();
        for (var item : a){
            if (item.getValue() == Person.connection.Mother){
                this.person = item.getKey();
            }
        }
    }
    public Person getMother(){
        var a = this.person.relatives.entrySet();
        for (var item : a){
            if (item.getValue() == Person.connection.Mother){
                return item.getKey();
            }
        }
        return null;
    }
    public void goFather(){
        var a = this.person.relatives.entrySet();
        for (var item : a){
            if (item.getValue() == Person.connection.Father){
                this.person = item.getKey();
            }
        }
    }
    public Person getFather(){
        var a = this.person.relatives.entrySet();
        for (var item : a){
            if (item.getValue() == Person.connection.Father){
                return item.getKey();
            }
        }
        return null;
    }
    public void goBrother(){
        var a = this.person.relatives.entrySet();
        for (var item : a){
            if (item.getValue() == Person.connection.Brother){
                this.person = item.getKey();
            }
        }
    }

    public Person getBrother(){
        var a = this.person.relatives.entrySet();
        for (var item : a){
            if (item.getValue() == Person.connection.Brother){
                return item.getKey();
            }
        }
        return null;
    }
    public void goSister(){
        var a = this.person.relatives.entrySet();
        for (var item : a){
            if (item.getValue() == Person.connection.Sister){
                this.person = item.getKey();
            }
        }
    }

    public Person getSister(){
        var a = this.person.relatives.entrySet();
        for (var item : a){
            if (item.getValue() == Person.connection.Sister){
                return item.getKey();
            }
        }
        return null;
    }

    public void goDaughter(){
        var a = this.person.relatives.entrySet();
        for (var item : a){
            if (item.getValue() == Person.connection.Daughter){
                this.person = item.getKey();
            }
        }
    }

    public Person getDaughter(){
        var a = this.person.relatives.entrySet();
        for (var item : a){
            if (item.getValue() == Person.connection.Daughter){
                return item.getKey();
            }
        }
        return null;
    }

    public void goSon(){
        var a = this.person.relatives.entrySet();
        for (var item : a){
            if (item.getValue() == Person.connection.Son){
                this.person = item.getKey();
            }
        }
    }

    public Person getSon(){
        var a = this.person.relatives.entrySet();
        for (var item : a){
            if (item.getValue() == Person.connection.Son){
                return item.getKey();
            }
        }
        return null;
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

    //public Person goSmb(String somebody){
    //    if(somebody.equalsIgnoreCase("мать") || somebody.equalsIgnoreCase("мама"))
    //        return getMother();
    //    else if(somebody.equalsIgnoreCase("отец") || somebody.equalsIgnoreCase("папа"))
    //        return getFather();
    //    else if(somebody.equalsIgnoreCase("брат"))
    //        return getBrother();
    //    else if(somebody.equalsIgnoreCase("сестра"))
    //        return getSister();
    //    else if(somebody.equalsIgnoreCase("дочь"))
    //        return getDaughter();
    //    else if(somebody.equalsIgnoreCase("сын"))
    //        return getSon();
    //}

    public LinkedList<Person> getRoots(){
        var LL = new LinkedList<Person>();
        var copy = person;
        while (hasNextMother())
            LL.add(nextMother());
        person = copy;
        while (hasNextFather())
            LL.add(nextFather());
        person = copy;
        return LL;
    }

    public String getInfoTree(){
        StringBuilder SB = new StringBuilder();
        var a = getRoots();
        while (a.size()>0){
            SB.append(a.getLast()).append("------------------\n");
            a.removeLast();
        }
        return SB.toString();
    }

    public boolean hasNextMother(){
        return getMother() != null;
    }

    public boolean hasNextFather(){
        return getFather() != null;
    }

    public Person nextMother(){
        goMother();
        return getMother();
    }

    public Person nextFather(){
        goFather();
        return getFather();
    }
}
