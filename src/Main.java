import List.*;

import java.util.Scanner;

public class Main {
    private static String example1 = "-5x^6+3x^2-2x+7";
    private static String example2 = "x^3-x^2+7";
    private static String example3 = "-2x^3-3x^2+x";
    private static String example4 = "-x+7";
    private static String example5 = "5";

    public static void main(String[] args) {
        System.out.println("task 1:");
        ListTask1 list1 = new ListTask1(example1);
        System.out.println("list1    " + list1);

        ListTask1 list2 = new ListTask1(example2);
        System.out.println("list2    " + list2);

        System.out.println("list1 in point 1    " + ListTask1.Meaning(list1, 1));
        System.out.println("list2 in point 0    " + ListTask1.Meaning(list2, 0));

        System.out.println("list1 == list1    " + ListTask1.Equality(list1, list1));
        System.out.println("list1 == list2    " + ListTask1.Equality(list1, list2));

        ListTask1 sum = new ListTask1();
        ListTask1.Add(sum, list1, list2);

        System.out.println("sum    " + sum);

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("task 2:");
        System.out.println("enter k to delete:");
        int k = scanner.nextInt();
        System.out.println("+-----+------+");
        System.out.println("|  n  | last |");
        System.out.println("+-----+------+");
        for (int i = 0; i < 64; i++) {
            System.out.printf("| %3d | %4S |\n", i + 1, new ListTask2(i + 1, k).toString());
            System.out.println("+-----+------+");
        }

        System.out.println();
        System.out.println("task 3:");
        ListTask3 listTask3 = new ListTask3();
        listTask3.add(1123323, "ab");
        listTask3.add(1227643, "af");
        listTask3.add(1223733, "ac");
        listTask3.add(8315983, "abc");
        listTask3.add(1226333, "ad");
        listTask3.add(8315983, "aba");
        listTask3.add(1984289, "afc");
        System.out.println("whole list   " + listTask3);
        System.out.println("name for number 123     " + listTask3.getName(1226333));
        System.out.println("number for name af     " + listTask3.getNumber("af"));

        System.out.println();
        System.out.println("task 4:");
        ListTask4_bidirectional listTask4 = new ListTask4_bidirectional();
        listTask4.add(1123323);
        listTask4.add(1227643);
        listTask4.add(1223733);
        listTask4.add(1226333);
        listTask4.add(9143503);
        listTask4.add(5913851);
        listTask4.add(6983153);
        listTask4.add(133);
        listTask4.add(512);
        listTask4.add(190);
        System.out.println("full list     " + listTask4);
        System.out.print("reversed list     ");
        listTask4.showFromRightToLeft();
        System.out.println("sorted list with 7 digits number    " + listTask4.getUnidirectionalList());
    }
}
