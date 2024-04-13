package controller;

import ex.BadFormatDataException;
import ex.BadParametersCountException;
import model.Model;
import view.View;

import java.io.IOException;

public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model)
    {
        this.view = view;
        this.model = model;
    }

    public void run()
    {
        while (true)
        {
            view.output("\n\nВведите данные, в формате: Фамилия Имя Отчество dd.mm.yyyy Телефон Пол\n" +
                    "где:\n" +
                    "dd.mm.yyyy - дата рождения\n" +
                    "Телефон - номер телефона, только цифры\n" +
                    "Пол - символ (m - мужской, f - женский)\n" +
                    "\nили 'exit' - для выхода.\n");
            try {
                String cmd = view.input(">");
                if (cmd.equalsIgnoreCase("exit"))
                    break;
                model.save(cmd);
                view.output("\nЗапись успешно добавлена.\n");
            } catch (BadParametersCountException | BadFormatDataException e)
            {
                view.error(e.getMessage());
            } catch (IOException e) {
                view.error("Ошибка записи в файл: " + e.getMessage() + "\n");
                e.printStackTrace(view.getStream());
            }
        }

    }
    
}
