package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String commandLine,pointLine,info = """
                        Команды для работы с программой\s
                         add - Добавить точку(ки).
                         print num - Вывести группы.
                         remove num - Удвлить группу.
                         clear - Очистить все группы.
                         help - Вывод справки по командам.
                         exit - выход из программы.
                        \s""";
        groupPoint group = new groupPoint();
        boolean exit = true;
        System.out.println(info);
        while (exit) {
            System.out.println("Введите команду");
            Scanner str = new Scanner(System.in);
            commandLine = str.next();
            pointLine = str.nextLine();
            switch (commandLine) {
                case ("add") -> group.add(pointLine);
                case ("print") -> group.print(pointLine);
                case ("remove") -> group.remove(pointLine);
                case ("clear") -> group.clear();
                case ("help") -> System.out.println(info);
                case ("exit") -> exit = false;
                default -> System.out.print("Данная команда отсутствует");
            }
        }
    }
}
