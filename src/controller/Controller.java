package controller;

import ex.BadFormatDataException;
import ex.BadParametersCountException;
import model.Model;
import view.View;

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
        view.output("Введите данные, в формате: Фамилия Имя Отчество ДР Телефон Пол\n" +
                    "где:\n" +
                    "ДР - дата рождения, в формате дд.мм.гггг\n" +
                    "Телефон - номер телефона, только цифры\n" +
                    "Пол - символ (m - мужской, f - женский)\n");
        try {
            model.input("Иванов Сидор Сергеевич 27.08.1975 79534452805 m");
        } catch (BadParametersCountException | BadFormatDataException e)
        {
            view.error(e.getMessage());
        }

    }
    
}
