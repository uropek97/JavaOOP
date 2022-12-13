import java.util.HashMap;
import java.util.LinkedList;

public class MyModel implements Model {
    static DataBase file = new DataBase();
    private HashMap<String ,User> database = file.getDataBase(file.readFile());

    @Override
    public boolean signUp(String login, String pass){
        if(database.containsKey(login))
            return false;
        var newUser = new User(login, pass);
        database.put(login, newUser);
        file.writeInBase(newUser);
        return true;
    }

    @Override
    public boolean signIn(String login, String pass){
        if(this.database.containsKey(login)){
            return this.database.get(login).comparePass(pass);
        }
        else
            return false;
    }

    public LinkedList<String> getUsers(){
        var list = new LinkedList<String>();
        var i = 1;
        for(var item : this.database.entrySet())
            list.add(i++ + ") Пользователь: " + item.getKey() + " *какая-то ещё инфа*.");
        return list;
    }
}