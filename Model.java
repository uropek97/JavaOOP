import java.util.LinkedList;

public interface Model {
    boolean signUp(String login, String pass);
    boolean signIn(String login, String pass);
    LinkedList<String> getUsers();
}