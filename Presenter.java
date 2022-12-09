public class Presenter {
    Viev viev;
    Model model;

    public Presenter(Viev viev, Model model) {
        this.viev = viev;
        this.model = model;
    }

    public boolean enter(boolean ifRegistered){
        String login = viev.getData("Логин: ");
        String pass = viev.getData("Пароль: ");

        if(ifRegistered) {
            if(model.signIn(login, pass)) {
                viev.printData("Вход выполнен успешно.", true);
                return true;
            }
            else{
                viev.printData("Неверный логин или пароль.", true);
                return false;
            }
        }
        else {
            if(model.signUp(login, pass)) {
                viev.printData("Аккаунт успешно создан.", true);
                viev.printData("Вход выполнен успешно.", true);
                return true;
            }
            else {
                viev.printData("Данный логин уже существует.", true);
                return false;
            }
        }
    }

    public boolean pickOption(){
        viev.printData("1 - подключиться", true);
        viev.printData("2 - зарегистрироваться", true);
        String choice = viev.getData("Ваш выбор: ");
        //требуется допилить
        return choice.equals("1");
    }
}