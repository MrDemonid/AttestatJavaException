## Промежуточная аттестация по курсу "Исключения в программировании и их обработка"

```
Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:

Фамилия Имя Отчество дата _ рождения номер _ телефона пол

Форматы данных:

фамилия, имя, отчество - строки
дата _ рождения - строка формата dd.mm.yyyy
номер _ телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно распарсить полученную строку и выделить из них требуемые значения. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
<Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
```

Реализовал по шаблону MVC. 

Реализовал полную проверку даты, то есть не просто на заданный формат,
но и на корректность самой даты, учитывая и високосные годы. 

Для ФИО просто проверка на недопустимые символы, такие как "@#$%" и тд.,
которые совершенно точно не могут встретиться в нормальных именах.

Телефон можно задать любой, не меньше двузначного. Просто я не в курсе, 
может где-то и номера на 1000 цифр имеются :) 

Вывод стактрейса перенаправлен на стандартный PrintStream (System.out). 
Просто если выводить его на System.err, то он запаздывает и вылазит
в консоль в самый ненужный момент (такая вот рассинхронизация потоков
вывода).

