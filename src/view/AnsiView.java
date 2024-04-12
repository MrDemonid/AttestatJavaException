package view;

public class AnsiView extends ConsoleView {
    public static final String ANSI_RESET = "\u001b[0m";

    public static final String ANSI_OUTPUT = "\u001b[38;5;255m";
    public static final String ANSI_INPUT = "\u001b[36m";
    public static final String ANSI_ERROR = "\u001b[31;1m";
    public static final String ANSI_ERROR_TEXT = "\u001b[33m";


    @Override
    public void output(String msg) {
        super.output(ANSI_OUTPUT + msg + ANSI_RESET);
    }

    @Override
    public String input(String comment) {
        String s = super.input(ANSI_INPUT + comment);
        super.output(ANSI_RESET);
        return s;
    }

    @Override
    public void error(String msg) {
        super.error(String.format("%sError: %s%s%s%s", ANSI_ERROR, ANSI_RESET, ANSI_ERROR_TEXT, msg, ANSI_RESET));
    }
}
