package com.company;

import java.util.ArrayList;
import java.util.List;

class groupPoint {
    private List<String> group1Point = new ArrayList<>();
    private List<String> group2Point = new ArrayList<>();
    private List<String> group3Point = new ArrayList<>();
    private List<String> nonGroupPoint = new ArrayList<>();

    public void add(String str) {
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
        } else System.out.println("Ошибка ввода");

    }

    public void print() {

        System.out.println("В первую группу входит:");
        if (!group1Point.isEmpty()) {
            for (String s : group1Point) System.out.println(s + " ");
        } else System.out.println("-Группа пуста-)");

        System.out.println("Во вторую группу входит:");
        if (!group2Point.isEmpty()) {
            for (String s : group2Point) System.out.println(s + " ");
        } else System.out.println("-Группа пуста-");

        System.out.println("В третью группу входит:");
        if (!group3Point.isEmpty()) {
            for (String s : group3Point) System.out.println(s + " ");
        } else System.out.println("-Группа пуста-");

        System.out.println("Не входят в группу");
        if (!nonGroupPoint.isEmpty()) {
            for (String s : nonGroupPoint) System.out.print(s + " ");
        } else System.out.println("-Группа пуста-");
    }

    public void print(String str) {
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
        } else print();
    }

    public void clear() {
        group1Point.clear();
        group2Point.clear();
        group3Point.clear();
        System.out.println("Память очищена");
    }

    public void remove(String str) {
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
