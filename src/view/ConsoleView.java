package view;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleView extends View {

    @Override
    public void output(String msg)
    {
        System.out.print(msg);
        System.out.flush();
    }

    @Override
    public String input(String comment)
    {
        output(comment);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public void error(String msg)
    {
        System.out.print(msg);
        System.out.flush();
    }

    @Override
    public PrintStream getStream()
    {
        return System.out;
    }
}
