import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

public class DataBase {
    File database = new File("users.txt");


    public void writeInBase(User user){
        try(FileWriter writer = new FileWriter(database.getPath(), true))
        {
            writer.write(user.toString() + " \n");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<String> readFile(){
        var list = new LinkedList<String>();
        try(FileReader fr = new FileReader(database.getPath());
            BufferedReader reader = new BufferedReader(fr)){
            String line = reader.readLine();
            list.add(line);
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, User> getDataBase(LinkedList<String> file){
        var map = new HashMap<String, User>();
        for(var item : file){
            try {
                var a = item.split(" ");
                map.put(a[1], new User(a[1], a[3]));
            }
            catch (Exception e){
                System.out.println(e);//неверно обработана ошибка на данном этапе.
            }
        }
        return map;
    }

}
