package view;

import java.io.PrintStream;

public abstract class View {
    public abstract void output(String msg);
    public abstract String input(String comment);
    public abstract void error(String msg);
    public abstract PrintStream getStream();
}
