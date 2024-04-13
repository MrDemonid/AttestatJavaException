package model;

import ex.BadFormatDataException;
import ex.BadParametersCountException;

import java.io.FileWriter;
import java.io.IOException;

public class Model {
    private static final int INDEX_FIRST_NAME = 1;
    private static final int INDEX_LAST_NAME = 0;
    private static final int INDEX_MIDDLE_NAME = 2;
    private static final int INDEX_DATE = 3;
    private static final int INDEX_PHONE = 4;
    private static final int INDEX_SEX = 5;
    private static final int INDEX_TOTAL = INDEX_SEX + 1;

    public Model() {
    }

    public void save(String source) throws BadParametersCountException, BadFormatDataException, IOException {
        String norm = source.replaceAll("\\s+", " ").trim();
        String[] inp = norm.split(" ");
        if (inp.length != INDEX_TOTAL)
            throw new BadParametersCountException(INDEX_TOTAL, inp.length);

        // проверяем данные
        checkFIO(inp[INDEX_FIRST_NAME], inp[INDEX_MIDDLE_NAME], inp[INDEX_LAST_NAME]);
        checkDate(inp[INDEX_DATE]);
        checkPhone(inp[INDEX_PHONE]);
        checkSex(inp[INDEX_SEX]);

        // скидываем в файл (в папке assert)
        try (FileWriter f = new FileWriter("assert/" + inp[INDEX_LAST_NAME], true))
        {
            f.append(norm).append("\n");
        }
    }

    private void checkFIO(String first, String middle, String last) throws BadFormatDataException
    {
        char[] errSymbols = {'&', '@', '!', '#', '$', '%', '^', '*', '(', ')', '[', ']', '"', ';', '.', '/', '\\', '|', '~', '+', '='};

        if (first.isBlank() || middle.isBlank() || last.isBlank())
            throw new BadFormatDataException("ФИО не может быть пустым.");

        for (char c : errSymbols) {
            if (first.indexOf((int) c) != -1 || middle.indexOf((int) c) != -1 || last.indexOf((int) c) != -1)
                throw new BadFormatDataException(String.format("Символ '%s' недопустим для ФИО", ""+c));
        }
    }

    private void checkDate(String date) throws BadFormatDataException
    {
        try {
            String[] d = date.split("\\.");
            int day, month, year;

            if (d.length != 3 || d[0].length() != 2 || d[1].length() != 2 || d[2].length() != 4)
                throw new RuntimeException();

            day = Integer.parseInt(d[0]);
            month = Integer.parseInt(d[1]);
            year = Integer.parseInt(d[2]);
            if (day == 0 || year < 0 || year > 9999)
                throw new RuntimeException();

            if (day <= 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12))
                return;
            if (day <= 30 && (month == 4 || month == 6 || month == 9 || month == 11))
                return;
            if (month == 2) {
                int n = 28;
                if (year % 4 == 0)
                    n = 29;
                if ((year % 100 == 0) && (year % 400 != 0))
                    n = 28;
                if (day <= n)
                    return;
            }
            throw new BadFormatDataException(String.format("Дата '%s' не действительная", date));

        } catch (RuntimeException e) {
            throw new BadFormatDataException(String.format("Дата '%s' имеет неверный формат", date));
        }
    }

    private void checkPhone(String phone) throws BadFormatDataException
    {
        if (phone.length() < 2)             // минимум две цифры (01, 02, 03)
            throw new BadFormatDataException("Номер телефона не может быть меньше двух цифр");

        //        if (!phone.matches("\\+?\\d+"))   // вариант если допускается + в начале числа, например +7
        if (!phone.matches("\\d+"))
            throw new BadFormatDataException("Неверный формат номера телефона, должны быть только цифры");
    }

    private void checkSex(String sex) throws BadFormatDataException
    {
        if (!sex.equals("m") && !sex.equals("f"))
            throw new BadFormatDataException("Пол должен быть указан только символами: 'm' - мужской, 'f' - женский");
    }


}
