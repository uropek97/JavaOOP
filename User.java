public class User {
    private String login;
    private String pass;


    public User(String login, String pass){
        this.login = login;
        this.pass = pass;
    }

    public boolean comparePass(String somePass){
        return this.pass.equals(somePass);
    }

    @Override
    public int hashCode() {
        return this.login.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof User))
            return false;
        return this.login.equals(((User)obj).login);
    }

    @Override
    public String toString() {
        return "Логин: " + this.login + " Пароль: " + this.pass;
    }
}