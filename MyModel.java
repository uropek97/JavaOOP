import java.util.HashMap;

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
}