public class Lesson5 {
    public static void main(String[] args) {
        Presenter pr = new Presenter(new MyViev(), new MyModel());
        var a = pr.pickOption();
        pr.enter(a);

        pr.printDataBase();
    }
}
