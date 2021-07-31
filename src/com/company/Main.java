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
class groupPoint {
    private List <String> group1Point = new ArrayList<>();
    private List <String> group2Point = new ArrayList<>();
    private List <String> group3Point = new ArrayList<>();
    private List <String> nonGroupPoint = new ArrayList<>();

    public void add (String str){
        String[] strPoint = str.split(" ");
        if (strPoint.length % 3 == 0) {
            for (int i = 1; i < strPoint.length; i += 2) {
                if (Integer.parseInt(strPoint[i]) == Integer.parseInt(strPoint[i + 1])) {
                    group1Point.add(strPoint[i] + " " + strPoint[i + 1]);
                }
                if (Integer.parseInt(strPoint[i + 1]) == Math.pow(Integer.parseInt(strPoint[i]), 2)) {
                    group2Point.add(strPoint[i] + " " + strPoint[i + 1]);
                }
                if (Integer.parseInt(strPoint[i + 1]) == Math.pow(Integer.parseInt(strPoint[i]), 3)) {
                    group3Point.add(strPoint[i] + " " + strPoint[i + 1]);
                } else nonGroupPoint.add(strPoint[i] + " " + strPoint[i + 1]);

            }
        }else System.out.println("Ошибка ввода");

    }

    public void print (){

        System.out.println("В первую группу входит:");
        if(!group1Point.isEmpty()) {
            for (String s : group1Point) System.out.println(s + " ");
        }else System.out.println("-Группа пуста-)");

        System.out.println("Во вторую группу входит:");
        if(!group2Point.isEmpty()) {
            for (String s : group2Point) System.out.println(s + " ");
        }else System.out.println("-Группа пуста-");

        System.out.println("В третью группу входит:");
        if(!group3Point.isEmpty()) {
            for (String s : group3Point) System.out.println(s + " ");
        }else System.out.println("-Группа пуста-");

        System.out.println("Не входят в группу");
        if(!nonGroupPoint.isEmpty()){
            for (String s : nonGroupPoint) System.out.print(s + " ");
        }else System.out.println("-Группа пуста-");
    }
    public void print (String str){
        String[] strGroup = str.split(" ");
        if (strGroup.length > 1) {
            for (int i = 1; i < strGroup.length; i++) {
                if (strGroup[i].equals("1")) {
                    System.out.println("В первую группу входит:");
                    for (String s : group1Point) System.out.println(s + " ");

                }
                if (strGroup[i].equals("2")) {
                    System.out.println("Во вторую группу входит:");
                    for (String s : group2Point) System.out.println(s + " ");

                }
                if (strGroup[i].equals("3")) {
                    System.out.println("В третью группу входит:");
                    for (String s : group3Point) System.out.println(s + " ");

                }

            }
        }else print();
    }
    public void clear(){
        group1Point.clear();
        group2Point.clear();
        group3Point.clear();
        System.out.println("Память очищена");
    }
    public void remove (String str){
        String[] strGroup = str.split(" ");
        for (int i = 1; i < strGroup.length; i++) {
            if (strGroup[i].equals("1")) {
                group1Point.clear();
            }
            if (strGroup[i].equals("2")) {
                group2Point.clear();
            }
            if (strGroup[i].equals("3")) {
                group3Point.clear();
            }
        }
    }
}
