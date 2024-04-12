package ex;

public class BadParametersCountException extends Exception {
    public BadParametersCountException(int mustbe, int cnt) {
        super(String.format("Неверное количество аргументов: %s вместо %s\n", cnt, mustbe));
    }
}
