import java.util.Scanner;

public class MyViev implements Viev {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String getData(String message) {
        printData(message, false);
        return scanner.next();
    }

    @Override
    public void printData(String message, boolean ifNewLine) {
        if(ifNewLine)
            System.out.println(message);
        else
            System.out.print(message);
    }
}